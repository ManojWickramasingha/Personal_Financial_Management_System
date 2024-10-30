package edu.icet.pim.controller;

import edu.icet.pim.model.Category;
import edu.icet.pim.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@CrossOrigin
public class CategoryController {

    final CategoryService service;

    @PostMapping("/")
    public Boolean addCategory(@RequestBody Category category){
        service.addCategory(category);
        return true;
    }



    @GetMapping("/search-by-name/{name}")
    public Category saerchByName(@PathVariable String name){
       return service.searchByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteCategory(@PathVariable Integer id){
        service.deleteCategory(id);
        return true;
    }

    @GetMapping("/get-all")
    public List<Category> getAll(){
        return service.getAll();
    }
}
