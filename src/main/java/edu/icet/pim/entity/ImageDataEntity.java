package edu.icet.pim.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "ImageData")
@Builder
public class ImageDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    @Lob
    @Column(name = "imagedata",length = 1000)
    private byte[] imageData;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expenseId")
    private ExpenseEntity expense;}
