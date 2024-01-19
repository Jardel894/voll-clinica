package br.com.vollclinica.converter;

import br.com.vollclinica.dto.PacienteRequest;
import br.com.vollclinica.entities.Paciente;

public class PacienteConverter {

    public static Paciente toPaciente(PacienteRequest pacienteRequest){
        return Paciente.builder()
                .nome(pacienteRequest.nome())
                .cpf(pacienteRequest.cpf())
                .email(pacienteRequest.email())
                .telefone(pacienteRequest.telefone())
                .endereco(EnderecoConverter.toEndereco(pacienteRequest.endereco()))
                .build();
    }
}
