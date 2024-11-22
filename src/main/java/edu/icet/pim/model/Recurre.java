package edu.icet.pim.model;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Recurre {
   private Long id;
   private LocalDate startDate;
   private LocalDate endDate;
   private Double amount;
   private String optionType;
   private String category;
   private String description;
}
