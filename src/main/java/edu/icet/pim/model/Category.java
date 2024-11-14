package edu.icet.pim.model;

import lombok.*;

import java.util.Base64;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private String name;
    private String icon;
    private String type;
    private String description;

    public void setIcon(String icon) {
        this.icon = Base64.getEncoder().encodeToString(icon.getBytes());
    }

}
