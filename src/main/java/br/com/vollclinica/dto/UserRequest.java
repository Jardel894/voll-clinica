package br.com.vollclinica.dto;

import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank
        String login,
        @NotBlank
        String senha) {
}
