package edu.icet.pim.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseRequestDTO {
    private Expense expense;
    private Receipt receipt;
}
