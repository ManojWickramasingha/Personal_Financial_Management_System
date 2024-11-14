package edu.icet.pim.controller;

import edu.icet.pim.service.AnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/categoryTotal")
    public Map<String, Double> categoryByTotal(){
       return service.categoryByTotal();
    }

}
