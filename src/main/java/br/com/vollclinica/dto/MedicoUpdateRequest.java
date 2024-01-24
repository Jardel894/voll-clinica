package br.com.vollclinica.dto;

public record MedicoUpdateRequest(
        String nome,
        String email,
        String telefone,
        EnderecoRequest endereco) {
}
