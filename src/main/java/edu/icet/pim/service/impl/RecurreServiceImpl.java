package edu.icet.pim.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.pim.entity.ExpenseEntity;
import edu.icet.pim.entity.RecurrEntity;
import edu.icet.pim.model.Expense;
import edu.icet.pim.model.Recurre;
import edu.icet.pim.repository.ExpenseRepository;
import edu.icet.pim.repository.RecurreRepository;
import edu.icet.pim.service.RecurrService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecurreServiceImpl implements RecurrService {

    final RecurreRepository repository;
    final ObjectMapper mapper;
    final private ExpenseRepository expenseRepository;
    @Override
    public Boolean addRecurring(Recurre recurre) {
        if (recurre.getOptionType() == "daily") {
            LocalDate currentDate = recurre.getStartDate();
            while (!currentDate.isAfter(recurre.getEndDate())) {
                Expense dailyExpense = new Expense();
                dailyExpense.setDescription(recurre.getDescription());
                dailyExpense.setAmount(String.valueOf(recurre.getAmount()));
                dailyExpense.setCategory(recurre.getCategory());
                dailyExpense.setStartDate(currentDate);
                dailyExpense.setCategory("Recurring");
                dailyExpense.setEndDate(currentDate);
                dailyExpense.setRecurrenceType("daily");
                repository.save(mapper.convertValue(recurre, RecurrEntity.class));
                expenseRepository.save(mapper.convertValue(dailyExpense, ExpenseEntity.class));
                currentDate = currentDate.plusDays(1);
            }
        } else {
            repository.save(mapper.convertValue(recurre, RecurrEntity.class));
            expenseRepository.save(mapper.convertValue(recurre, ExpenseEntity.class));
        }
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

    @Override
    public Boolean updateRecurring(Recurre recurre) {
        repository.save(mapper.convertValue(recurre, RecurrEntity.class));
        return true;
    }

    @Override
    public Boolean deleteRecurr(Long id) {
        repository.deleteById(id);
        return true;
    }


}
