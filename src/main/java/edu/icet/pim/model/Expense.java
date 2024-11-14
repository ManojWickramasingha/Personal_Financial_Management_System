package edu.icet.pim.model;
import edu.icet.pim.entity.FileDataEntity;
import edu.icet.pim.util.PaymentMethod;
import edu.icet.pim.util.RecurringOption;
import lombok.*;

import java.time.LocalDate;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
   private String amount;
   private LocalDate createDate;
   private String category;
   private PaymentMethod paymentMethod;
   private String description;
   private Integer receipt;

}
