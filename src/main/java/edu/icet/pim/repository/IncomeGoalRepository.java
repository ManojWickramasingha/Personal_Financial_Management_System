package edu.icet.pim.repository;

import edu.icet.pim.entity.IncomeGoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IncomeGoalRepository extends JpaRepository<IncomeGoalEntity,Long> {

    @Query(value = "SELECT * from income_goal ORDER BY id DESC LIMIT 1", nativeQuery = true)
    IncomeGoalEntity findLastRecord();
}
