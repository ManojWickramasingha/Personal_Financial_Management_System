package edu.icet.pim.controller;

import edu.icet.pim.entity.ReceiptEntity;
import edu.icet.pim.model.Expense;
import edu.icet.pim.model.ExpenseRequestDTO;
import edu.icet.pim.model.Receipt;
import edu.icet.pim.service.ExpenseService;
import edu.icet.pim.util.PaymentMethod;
import edu.icet.pim.util.RecurringOption;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/expense")
public class ExpenseController {

   final ExpenseService service;

    @PostMapping
    public ResponseEntity<?> addExpenseWithReceipt(@RequestBody ExpenseRequestDTO request){
        try {
            Boolean isSaved = service.addExpenseWithReceipt(request.getExpense(), request.getReceipt());
            return ResponseEntity.ok(isSaved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving expense and receipt");
        }
    }

    @GetMapping("/search-by-date/{date}")
    public List<Expense> searchByDate(@PathVariable LocalDate date){
        return service.searchByDate(date);
    }

    @GetMapping("/search-by-category/{category}")
    public List<Expense> searchByCategory(@PathVariable String category){
        return service.searchByCategory(category);
    }

    @GetMapping("/search-by-paymentMethod/{paymentMethod}")
    public List<Expense> searchByPaymentMethod(@PathVariable PaymentMethod paymentMethod){
        return service.searchByPaymentMethod(paymentMethod);
    }

    @GetMapping("/search-by-currency/{currency}")
    public List<Expense> searchByCurrency(@PathVariable String currency){
        return service.searchByCurrency(currency);
    }

    @GetMapping("/search-by-recurringOption/{recurringOption}")
    public List<Expense> searchByRecurringOption(@PathVariable RecurringOption recurringOption){
        return service.searchByRecurringOption(recurringOption);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteById(@PathVariable Integer id){
       return service.deleteById(id);
    }
}
