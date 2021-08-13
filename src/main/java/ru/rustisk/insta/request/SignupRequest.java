package ru.rustisk.insta.request;

import lombok.Data;
import ru.rustisk.insta.annotations.ValidEmail;

import javax.validation.constraints.*;

@Data
public class SignupRequest {
    @Email(message = "It should be email format")
    @NotBlank(message = "Email can not be empty")
    @ValidEmail
    private String email;
    @NotEmpty(message = "Please enter your username")
    private String username;
    private String firstname;
    private String lastname;
    @NotEmpty(message = "Please enter password")
    @Size(min = 6)
    private String password;
    private String confirmPassword;
}
