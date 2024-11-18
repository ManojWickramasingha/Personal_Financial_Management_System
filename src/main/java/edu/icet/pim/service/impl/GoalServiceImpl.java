package edu.icet.pim.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.pim.entity.ExpenseGoalEntity;
import edu.icet.pim.entity.IncomeGoalEntity;
import edu.icet.pim.model.ExpenseGoal;
import edu.icet.pim.model.IncomeGoal;
import edu.icet.pim.repository.ExpenseGoalRepository;
import edu.icet.pim.repository.IncomeGoalRepository;
import edu.icet.pim.service.GoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoalServiceImpl implements GoalService {

    private final ExpenseGoalRepository repository;
    private final IncomeGoalRepository incomeGoalRepository;
    private final ObjectMapper mapper;
    @Override
    public Boolean addExpenseGoal(ExpenseGoal expenseGoal) {
        repository.save(mapper.convertValue(expenseGoal, ExpenseGoalEntity.class));
        return true;
    }

    @Override
    public ExpenseGoal getLastRecord() {
      return   mapper.convertValue(repository.getLastRecord(),ExpenseGoal.class);
    }

    @Override
    public Boolean addIncomeGoal(IncomeGoal incomeGoal) {
        incomeGoalRepository.save(mapper.convertValue(incomeGoal, IncomeGoalEntity.class));
        return true;
    }

    @Override
    public IncomeGoal getIncomeLast() {
      return   mapper.convertValue(incomeGoalRepository.findLastRecord(),IncomeGoal.class);
    }
}
