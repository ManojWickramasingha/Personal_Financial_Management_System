package edu.icet.pim.repository;

import edu.icet.pim.entity.ExpenseEntity;
import edu.icet.pim.util.PaymentMethod;
import edu.icet.pim.util.RecurringOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Integer> {
    List<ExpenseEntity> findByCreateDate(LocalDate date);
    List<ExpenseEntity> findByCategory(String category);

    List<ExpenseEntity> findByPaymentMethod(PaymentMethod paymentMethod);

    List<ExpenseEntity> findByCurrency(String currency);

    List<ExpenseEntity> findByRecurringOption(RecurringOption recurringOption);
}
