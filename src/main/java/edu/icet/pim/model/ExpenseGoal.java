package edu.icet.pim.model;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExpenseGoal {
    private double total;
    private double goal;
    private LocalDate createDate;
    private LocalDate updateDate;
}
