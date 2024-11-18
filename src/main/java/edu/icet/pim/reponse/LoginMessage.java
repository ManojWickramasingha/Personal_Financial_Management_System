package edu.icet.pim.reponse;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginMessage {
    private String message;
    private Boolean status;
}
