package edu.icet.pim.controller;

import edu.icet.pim.service.AnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/analysis")
@RequiredArgsConstructor
public class AnalysisController {

    private final AnalysisService service;
    @GetMapping("/expense/total")
    public Double expenseTotal(){
       return service.expenseTotal();

    }

    @GetMapping("/income/total")
    public Double incomeTotal(){
       return service.incomeTotal();
    }

    @GetMapping("/total")
    public Double Total(){
        return service.Total();
    }

    @GetMapping("/balance")
    public Double balance(){
        return service.Balance();
    }

    @GetMapping("/weekly-summary")
    public ResponseEntity<Map<String, List<Double>>> getWeeklySummary() {
        Map<String, List<Double>> data = new HashMap<>();

        Map<String, List<Double>> weeklySummary = service.getWeeklySummary();
        List<Double> expenses = weeklySummary.get("expenses");
        List<Double> incomes = weeklySummary.get("incomes");

        data.put("expenses", expenses);
        data.put("incomes", incomes);

        return ResponseEntity.ok(data);
    }
    @GetMapping("/monthly-summary")
    public ResponseEntity<Map<String, List<Double>>> getMonthlySummary() {
        Map<String, List<Double>> data = new HashMap<>();

        Map<String, List<Double>> weeklySummary = service.getWeeklySummary();
        List<Double> expenses = weeklySummary.get("expenses");
        List<Double> incomes = weeklySummary.get("incomes");

        data.put("expenses", expenses);
        data.put("incomes", incomes);

        return ResponseEntity.ok(data);
    }


    @GetMapping("/categoryTotal")
    public Map<String, Double> categoryByTotal(){
       return service.categoryByTotal();
    }

    @GetMapping("/expense/monthly/total")
    public Double monthlyTotal(){
        return service.monthlyExpenseTotal();
    }

    @GetMapping("/income/monthly/total")
    public Double monthlyIncomeTotal(){
        return service.monthlyIncomeTotal();
    }

    @GetMapping("/monthly/netProfit")
    public Double monthlyProfit(){
        return service.monthlyProfit();
    }

    @GetMapping("/monthly/category_bY/total")
    public Map<String, Double> monthlyCategoryByTotal(){
        return service.monthlyCategoryByTotal();
    }


}
