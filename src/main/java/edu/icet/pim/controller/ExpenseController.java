package edu.icet.pim.controller;


import edu.icet.pim.model.Expense;
import edu.icet.pim.model.ExpenseRequestDTO;
import edu.icet.pim.service.ExpenseService;
import edu.icet.pim.service.ImageService;
import edu.icet.pim.util.PaymentMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/expense")
public class ExpenseController {

   final ExpenseService service;

    @PostMapping
    public Boolean addExpenseWithReceipt(@RequestBody Expense request){
        try {
             service.addExpenseWithReceipt(request);
             return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
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



    @DeleteMapping("/delete/{id}")
    public Boolean deleteById(@PathVariable Integer id){
       return service.deleteById(id);
    }

    @GetMapping("/receipt_id")
    public Integer getReceiptId(){
        return service.getReceiptId();
    }

    @GetMapping("/get_all")
    public List<Expense> getAll(){
        return service.getAll();
    }
}
