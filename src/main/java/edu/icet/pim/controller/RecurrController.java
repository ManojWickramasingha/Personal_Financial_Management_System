package edu.icet.pim.controller;

import edu.icet.pim.model.Expense;
import edu.icet.pim.model.Recurre;
import edu.icet.pim.service.RecurrService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recurre")
@RequiredArgsConstructor
@CrossOrigin
public class RecurrController {

    final RecurrService service;
    @PostMapping("/")
    public Boolean addRecurring(@RequestBody Recurre recurre){
        service.addRecurring(recurre);
        return true;
    }

    @PutMapping("/update")
    public Boolean updateRecurring(@RequestBody Recurre recurre){
       return service.updateRecurring(recurre);

    }

    @GetMapping("/get-all")
    public List<Recurre> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteRecurr(@PathVariable Long id){
        return service.deleteRecurr(id);
    }


}
