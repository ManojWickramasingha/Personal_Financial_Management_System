package edu.icet.pim.service.impl;

import edu.icet.pim.entity.ExpenseEntity;
import edu.icet.pim.entity.IncomeEntity;
import edu.icet.pim.repository.ExpenseRepository;
import edu.icet.pim.repository.IncomeRepository;
import edu.icet.pim.service.AnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AnalysisServiceImpl implements AnalysisService {
    private final ExpenseRepository expenseRepository;
    private final IncomeRepository incomeRepository;

    private Double T = 0.0;
    @Override
    public Double expenseTotal() {
        List<ExpenseEntity> expenses = expenseRepository.findAll();
        double Total = 0.0;
        for(ExpenseEntity expense:expenses){

            Total += Double.parseDouble(expense.getAmount().substring(3));
        }
        T += Total;
        return Total;
    }

    @Override
    public Double incomeTotal() {
        List<IncomeEntity> incomes = incomeRepository.findAll();
        double Total = 0.0;
        for(IncomeEntity income : incomes){
            Total += Double.parseDouble(income.getAmount().substring(3).replaceAll(",", ""));
        }
        T += Total;
        return Total;
    }

    @Override
    public Double Total() {
      return incomeTotal() + expenseTotal();
    }

    @Override
    public Double Balance() {
       return incomeTotal() - expenseTotal();
    }

    @Override
    public Map<String, List<Double>> getWeeklySummary() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(6);

        List<String> expenses = expenseRepository.findWeeklyExpenses(startDate, endDate);
        List<String> incomes = incomeRepository.findWeeklyIncomes(startDate, endDate);
        List<Double> clearExpenses = new ArrayList<>();
        List<Double> clearIncomes = new ArrayList<>();

        for(String expense : expenses){
           clearExpenses.add(Double.parseDouble(expense.toString().substring(3).replaceAll(",", "")));
        }

        for(String income : incomes){
            clearIncomes.add(Double.parseDouble(income.substring(3).replaceAll(",","")));
        }

        Map<String, List<Double>> data = new HashMap<>();
        data.put("expenses", clearExpenses);
        data.put("incomes", clearIncomes);
        return data;
    }

    @Override
    public Map<String, List<Double>> getMonthlySummary() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(29);

        List<String> expenses = expenseRepository.findMonthlyExpenses(startDate, endDate);
        List<String> incomes = incomeRepository.findMonthlyIncomes(startDate, endDate);
        List<Double> clearExpenses = new ArrayList<>();
        List<Double> clearIncomes = new ArrayList<>();

        for(String expense : expenses){
            clearExpenses.add(Double.parseDouble(expense.toString().substring(3).replaceAll(",", "")));
        }

        for(String income : incomes){
            clearIncomes.add(Double.parseDouble(income.substring(3).replaceAll(",","")));
        }

        Map<String, List<Double>> data = new HashMap<>();
        data.put("expenses", clearExpenses);
        data.put("incomes", clearIncomes);
        return data;
    }

    @Override
    public Map<String, Double> categoryByTotal() {
        Map<String, Double> categoryAmountMap = new HashMap<>();
        List<Object[]> totalAmountByCategory = expenseRepository.findTotalAmountByCategory();

        for (Object[] record : totalAmountByCategory) {
            String category = (String) record[0];
            Double amount = Double.parseDouble(record[1].toString());
            categoryAmountMap.put(category, amount);
        }
         return categoryAmountMap;
    }

    @Override
    public Double monthlyExpenseTotal() {
        List<ExpenseEntity> expenses = expenseRepository.findAll();
        double total = 0.0;
        LocalDate today = LocalDate.now();
        LocalDate startDate = today.minusDays(29);

        for (ExpenseEntity expense : expenses) {
            LocalDate expenseDate = expense.getCreateDate();
            if(expenseDate == null){
                continue;
            }
            if (!expenseDate.isBefore(startDate) && !expenseDate.isAfter(today)) {
                    total += Double.parseDouble(expense.getAmount().substring(3));
                }


        }
        return total;
    }

    @Override
    public Double monthlyIncomeTotal() {
        List<IncomeEntity> incomes = incomeRepository.findAll();
        double total = 0.0;
        LocalDate today = LocalDate.now();
        LocalDate startDate = today.minusDays(29);

        for (IncomeEntity income : incomes) {
            LocalDate incomeDate = income.getCreateDate();
            if(incomeDate == null){
                continue;
            }
            if (!incomeDate.isBefore(startDate) && !incomeDate.isAfter(today)) {
                total += Double.parseDouble(income.getAmount().substring(3));
            }


        }
        return total;
    }

    @Override
    public Double monthlyProfit() {
        return monthlyIncomeTotal()-monthlyExpenseTotal();
    }

    @Override
    public Map<String, Double> monthlyCategoryByTotal() {
        Map<String, Double> categoryAmountMap = new HashMap<>();

        // Calculate the date range
        LocalDate today = LocalDate.now();
        LocalDate startDate = today.minusDays(29);

        // Fetch data from repository
        List<Object[]> totalAmountByCategory = expenseRepository.findTotalAmountByCategoryInDateRange(startDate, today);

        // Map the results to categoryAmountMap
        for (Object[] record : totalAmountByCategory) {
            String category = (String) record[0];
            Double amount = Double.parseDouble(record[1].toString());
            categoryAmountMap.put(category, amount);
        }

        return categoryAmountMap;
    }

    @Override
    public Double weeklyExpenseTotal() {
        List<ExpenseEntity> expenses = expenseRepository.findAll();
        double total = 0.0;
        LocalDate today = LocalDate.now();
        LocalDate startDate = today.minusDays(6);

        for (ExpenseEntity expense : expenses) {
            LocalDate expenseDate = expense.getCreateDate();
            if(expenseDate == null){
                continue;
            }
            if (!expenseDate.isBefore(startDate) && !expenseDate.isAfter(today)) {
                total += Double.parseDouble(expense.getAmount().substring(3));
            }


        }
        return total;
    }

    @Override
    public Double weeklyIncomeTotal() {
        List<IncomeEntity> incomes = incomeRepository.findAll();
        double total = 0.0;
        LocalDate today = LocalDate.now();
        LocalDate startDate = today.minusDays(6);

        for (IncomeEntity income : incomes) {
            LocalDate incomeDate = income.getCreateDate();
            if(incomeDate == null){
                continue;
            }
            if (!incomeDate.isBefore(startDate) && !incomeDate.isAfter(today)) {
                total += Double.parseDouble(income.getAmount().substring(3));
            }


        }
        return total;
    }

    @Override
    public Double weeklyProfit() {
        return weeklyIncomeTotal()-weeklyExpenseTotal();
    }


}
