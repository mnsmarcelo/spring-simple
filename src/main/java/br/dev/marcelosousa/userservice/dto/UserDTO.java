package br.dev.marcelosousa.userservice.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private UUID id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email()
    @NotBlank(message = "Email is required")
    private String email;

    private boolean active;

    @NotBlank(message = "Password is required")
    private String password;

}
