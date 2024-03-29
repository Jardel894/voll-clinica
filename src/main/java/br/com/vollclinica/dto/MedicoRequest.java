package br.com.vollclinica.dto;

import br.com.vollclinica.enums.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoRequest (
        @NotBlank
        String nome,
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotBlank
        String telefone,

        @NotNull
        Especialidade especialidade,
        @Valid
        EnderecoDto endereco) {
}
