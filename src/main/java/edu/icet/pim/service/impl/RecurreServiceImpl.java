package edu.icet.pim.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.pim.entity.RecurrEntity;
import edu.icet.pim.model.Recurre;
import edu.icet.pim.repository.RecurreRepository;
import edu.icet.pim.service.RecurrService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecurreServiceImpl implements RecurrService {

    final RecurreRepository repository;
    final ObjectMapper mapper;
    @Override
    public Boolean addRecurring(Recurre recurre) {
        repository.save(mapper.convertValue(recurre, RecurrEntity.class));
        return true;
    }

    @Override
    public List<Recurre> getAll() {
        List<RecurrEntity> recurringEntities = repository.findAll();
        List<Recurre> recurrs = new ArrayList<>();
        for(RecurrEntity recurrEntity : recurringEntities){
            recurrs.add(mapper.convertValue(recurrEntity, Recurre.class));
        }
        return recurrs;
    }
}
