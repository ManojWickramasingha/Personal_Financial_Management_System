package edu.icet.pim.entity;

import edu.icet.pim.util.PaymentMethod;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity(name = "Expense")
    @Table(name = "expense")
    public class ExpenseEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String amount;
        private LocalDate createDate;
        private String category;
        private PaymentMethod paymentMethod;
        private String description;
        private Integer receipt;
    }


