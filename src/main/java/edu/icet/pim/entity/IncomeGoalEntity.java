package edu.icet.pim.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "incomeGoal")
public class IncomeGoalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double total;
    private Double goal;
    private LocalDate createDate;
    private String goalType;
    private LocalDate updateDate;
}
