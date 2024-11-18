package edu.icet.pim.controller;
import edu.icet.pim.model.ExpenseGoal;
import edu.icet.pim.model.IncomeGoal;
import edu.icet.pim.service.GoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goal")
@RequiredArgsConstructor
@CrossOrigin
public class GoalController {

  private final GoalService service;

    @PostMapping("/expense")
    public Boolean addExpenseGoal(@RequestBody ExpenseGoal expenseGoal){
       return service.addExpenseGoal(expenseGoal);
    }

    @GetMapping("/last_record")
    public ExpenseGoal getLastRecord(){
        return service.getLastRecord();
    }

    @PostMapping("/income")
    public Boolean addIncomeGoal(@RequestBody IncomeGoal incomeGoal){
        return service.addIncomeGoal(incomeGoal);
    }

    @GetMapping("lastIncome")
    public IncomeGoal getIncomeLastRecord(){
        return service.getIncomeLast();
    }
}
