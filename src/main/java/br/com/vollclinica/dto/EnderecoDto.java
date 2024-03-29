package br.com.vollclinica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

@Builder
public record EnderecoDto(
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        String numero,
        String complemento,
        @NotBlank
        String cidade,
        @NotBlank
        String uf) {
}
