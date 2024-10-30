package edu.icet.pim.service;


import edu.icet.pim.model.Category;

import java.util.List;

public interface CategoryService {
    Boolean addCategory(Category category);

    Boolean deleteCategory(Integer id);

     Category searchByName(String name);

     List<Category> getAll();
}
