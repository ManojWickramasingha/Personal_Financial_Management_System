package edu.icet.pim.model;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Recurre {
   private LocalDate startDate;
   private LocalDate endDate;
   private String optionType;
}
