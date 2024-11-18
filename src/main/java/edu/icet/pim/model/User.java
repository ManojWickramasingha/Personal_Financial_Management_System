package edu.icet.pim.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @NotBlank(message = "Name can't blank")
    @Size(min = 2,max = 50, message = "Name must be 2 between 50 characters")
    private String name;

    @NotBlank(message = "Email can't blank")
    @Email(message = "Invalid Email format")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).*$",
            message = "Password must include at least one uppercase letter, one lowercase letter, one number, and one special character"
    )
    private String password;
}
