package ru.rustisk.insta.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginRequest {
    @NotEmpty(message = "Username can't not be empty")
    private String username;
    @NotEmpty(message = "Password can't not be empty")
    private String password;
}
