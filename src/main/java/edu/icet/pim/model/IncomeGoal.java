package edu.icet.pim.model;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class IncomeGoal {
    private double total;
    private double goal;
    private LocalDate createDate;
    private LocalDate updateDate;
}
