package edu.icet.pim.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recurring")
public class RecurrEntity {
    @Id
    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String optionType;
}
