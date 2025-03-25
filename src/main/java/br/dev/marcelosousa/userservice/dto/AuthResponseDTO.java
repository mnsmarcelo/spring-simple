package br.dev.marcelosousa.userservice.dto;

import lombok.Data;

@Data
public class AuthResponseDTO {
    private String name;
    private String token;
}
