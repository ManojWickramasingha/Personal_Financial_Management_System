package edu.icet.pim.controller;

import edu.icet.pim.model.Income;
import edu.icet.pim.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/income")
@RequiredArgsConstructor
public class IncomeController {

    private  final IncomeService service;
    @PostMapping
    public Boolean addIncome(@RequestBody Income income){
        try {
            service.addIncome(income);
            return true;

        } catch (Exception e) {
        e.printStackTrace();
        return false;
        }

    }
}
