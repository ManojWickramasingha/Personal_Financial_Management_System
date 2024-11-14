package edu.icet.pim.repository;

import edu.icet.pim.entity.IncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IncomeRepository extends JpaRepository<IncomeEntity,Long> {
    @Query(value = "SELECT e.amount FROM Income e WHERE e.create_date >= :startDate AND e.create_date <= :endDate", nativeQuery = true)
    List<String> findWeeklyIncomes(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
