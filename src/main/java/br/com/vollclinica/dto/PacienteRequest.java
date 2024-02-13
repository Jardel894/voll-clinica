package br.com.vollclinica.dto;

public record PacienteRequest (

         String nome,
         String email,
         String cpf,
         String telefone,
         EnderecoDto endereco) {
}
