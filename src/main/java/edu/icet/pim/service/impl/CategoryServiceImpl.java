package edu.icet.pim.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.pim.entity.CategoryEntity;
import edu.icet.pim.model.Category;
import edu.icet.pim.repository.CategoryRepository;
import edu.icet.pim.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    final ObjectMapper mapper;
    final CategoryRepository repository;
    @Override
    public Boolean addCategory(Category category) {
        repository.save(mapper.convertValue(category, CategoryEntity.class));
        return true;
    }

    @Override
    public Boolean deleteCategory(Integer id) {
        repository.deleteById(id);
        return true;
    }


    @Override
    public Category searchByName(String name) {
        CategoryEntity categoryEntity = repository.findByName(name);
        return  mapper.convertValue(categoryEntity, Category.class);
    }

    @Override
    public List<Category> getAll() {
        List<CategoryEntity> categoryEntities = repository.findAll();
        List<Category> categoryList = new ArrayList<>();
        for(CategoryEntity categoryEntity : categoryEntities){
            categoryList.add(mapper.convertValue(categoryEntity, Category.class));
        }
        return categoryList;
    }
}
