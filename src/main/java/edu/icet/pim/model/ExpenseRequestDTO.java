package edu.icet.pim.model;

import edu.icet.pim.entity.FileDataEntity;
import edu.icet.pim.entity.ImageDataEntity;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseRequestDTO {
    private Expense expense;
    private FileDataEntity receipt;
}
