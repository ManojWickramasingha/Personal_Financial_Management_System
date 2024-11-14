package edu.icet.pim.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.pim.entity.IncomeEntity;
import edu.icet.pim.model.Income;
import edu.icet.pim.repository.IncomeRepository;
import edu.icet.pim.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {
    private final IncomeRepository repository;
    private final ObjectMapper mapper;
    @Override
    public void addIncome(Income income) {
        repository.save(mapper.convertValue(income, IncomeEntity.class));
    }
}
