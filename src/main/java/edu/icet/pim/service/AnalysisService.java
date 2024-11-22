package edu.icet.pim.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface AnalysisService {
    public Double expenseTotal();

   public Double incomeTotal();

   public Double Total();

   public Double Balance();

    public Map<String, List<Double>> getWeeklySummary();

    public Map<String, List<Double>> getMonthlySummary();

    Map<String, Double> categoryByTotal();

    Double monthlyExpenseTotal();

    Double monthlyIncomeTotal();

    Double monthlyProfit();

    Map<String, Double> monthlyCategoryByTotal();
}
