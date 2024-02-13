package br.com.vollclinica.dto;// Trecho de código suprimido

import br.com.vollclinica.enums.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaRequest(
        Long idMedico,

        @NotNull
        Long idPaciente,

        @NotNull
        @Future
        LocalDateTime data,
        Especialidade especialidade) {
}