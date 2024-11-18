package edu.icet.pim.service;

import edu.icet.pim.model.ExpenseGoal;
import edu.icet.pim.model.IncomeGoal;

public interface GoalService {
    Boolean addExpenseGoal(ExpenseGoal expenseGoal);

    ExpenseGoal getLastRecord();

    Boolean addIncomeGoal(IncomeGoal incomeGoal);

    IncomeGoal getIncomeLast();
}
