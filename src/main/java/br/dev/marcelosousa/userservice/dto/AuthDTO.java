package br.dev.marcelosousa.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthDTO {

    @Email()
    @NotBlank(message = "Email is required")
    private String email;


    @NotBlank(message = "Password is required")
    private String password;
}
