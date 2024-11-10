package edu.icet.pim.service;

import edu.icet.pim.entity.ReceiptEntity;
import edu.icet.pim.model.Expense;
import edu.icet.pim.model.Receipt;
import edu.icet.pim.util.PaymentMethod;
import edu.icet.pim.util.RecurringOption;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseService {

    Boolean addExpenseWithReceipt(Expense expense, Receipt receipt);
    List<Expense> searchByDate(LocalDate date);

    List<Expense> searchByCategory(String category);

    List<Expense> searchByPaymentMethod(PaymentMethod paymentMethod);

    List<Expense> searchByCurrency(String currency);

    List<Expense> searchByRecurringOption(RecurringOption recurringOption);

    Boolean deleteById(Integer id);
}
