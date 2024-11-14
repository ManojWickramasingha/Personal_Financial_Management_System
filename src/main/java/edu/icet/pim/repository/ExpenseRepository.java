package edu.icet.pim.repository;

import edu.icet.pim.entity.ExpenseEntity;
import edu.icet.pim.util.PaymentMethod;
import edu.icet.pim.util.RecurringOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Integer> {
    List<ExpenseEntity> findByCreateDate(LocalDate date);
    List<ExpenseEntity> findByCategory(String category);

    List<ExpenseEntity> findByPaymentMethod(PaymentMethod paymentMethod);

    @Query(value = "SELECT e.amount FROM Expense e WHERE e.create_date >= :startDate AND e.create_date <= :endDate", nativeQuery = true)
    List<String> findWeeklyExpenses(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = "SELECT e.category, SUM(CAST(SUBSTRING(e.amount, 4) AS DECIMAL)) FROM Expense e GROUP BY e.category", nativeQuery = true)
    List<Object[]> findTotalAmountByCategory();


}
