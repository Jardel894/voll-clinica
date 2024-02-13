package br.com.vollclinica.dto;

import lombok.Builder;

@Builder
public record PacienteResponse(
        String nome,
        String email,
        String cpf,
        String telefone,
        EnderecoDto endereco) {
}
