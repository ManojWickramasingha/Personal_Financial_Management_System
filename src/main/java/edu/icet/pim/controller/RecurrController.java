package edu.icet.pim.controller;

import edu.icet.pim.model.Recurre;
import edu.icet.pim.service.RecurrService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/recurre")
@RequiredArgsConstructor
public class RecurrController {

    final RecurrService service;
    @PostMapping("/")
    public Boolean addRecurring(@RequestBody Recurre recurre){
        service.addRecurring(recurre);
        return true;
    }

    @GetMapping("/get-all")
    public List<Recurre> getAll(){
        return service.getAll();
    }
}
