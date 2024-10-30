package edu.icet.pim.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class CategoryEntity {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String name;
   private String icon;
   private String description;
}
