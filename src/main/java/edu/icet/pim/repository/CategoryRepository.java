package edu.icet.pim.repository;
import edu.icet.pim.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
    CategoryEntity findByName(String name);

}