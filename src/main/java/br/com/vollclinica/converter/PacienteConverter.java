package br.com.vollclinica.converter;

import br.com.vollclinica.dto.PacienteRequest;
import br.com.vollclinica.dto.PacienteResponse;
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

    public static PacienteResponse toPacienteResponse(Paciente paciente){
        return PacienteResponse.builder()
                .nome(paciente.getNome())
                .cpf(paciente.getCpf())
                .email(paciente.getEmail())
                .telefone(paciente.getTelefone())
                .endereco(EnderecoConverter.toEnderecoDto(paciente.getEndereco()))
                .build();
    }
}
