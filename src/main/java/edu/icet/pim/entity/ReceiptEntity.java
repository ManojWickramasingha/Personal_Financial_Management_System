package edu.icet.pim.entity;

import edu.icet.pim.model.Expense;
import jakarta.persistence.*;
import lombok.*;

import java.io.File;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Receipt")
@Table(name = "receipt")
public class ReceiptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Lob
    private byte[] receiptImage;

}
