package br.com.vollclinica.dto;

import lombok.Builder;

@Builder
public record PacienteUpdateRequest(
        String nome,

        String email,

        String telefone,

        EnderecoDto endereco) {
}
