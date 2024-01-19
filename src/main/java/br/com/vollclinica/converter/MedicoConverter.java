package br.com.vollclinica.converter;

import br.com.vollclinica.dto.MedicoRequest;
import br.com.vollclinica.entities.Medico;

public class MedicoConverter {

    public static Medico toMedico(MedicoRequest medicoRequest){
        return Medico.builder()
                .crm(medicoRequest.crm())
                .email(medicoRequest.email())
                .nome(medicoRequest.nome())
                .especialidade(medicoRequest.especialidade())
                .endereco(EnderecoConverter.toEndereco(medicoRequest.endereco()))
                .build();
    }
}
