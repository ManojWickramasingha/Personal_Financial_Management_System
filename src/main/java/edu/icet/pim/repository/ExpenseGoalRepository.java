package edu.icet.pim.repository;

import edu.icet.pim.entity.ExpenseGoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExpenseGoalRepository extends JpaRepository<ExpenseGoalEntity,Long> {

    @Query(value = "SELECT * FROM expense_goal ORDER BY id DESC LIMIT 1", nativeQuery = true)
    ExpenseGoalEntity getLastRecord();
}
