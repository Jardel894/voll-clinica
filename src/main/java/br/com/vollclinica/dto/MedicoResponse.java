package br.com.vollclinica.dto;

import br.com.vollclinica.enums.Especialidade;
import lombok.Builder;

@Builder
public record MedicoResponse(
         String nome,
         String email,
         String crm,
         Especialidade especialidade) {
}
