package edu.icet.pim.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Income {
    private String amount;
    private LocalDate createDate;
    private String source;
    private String description;
    private String category;
}
