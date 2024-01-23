package br.com.vollclinica.converter;

import br.com.vollclinica.dto.MedicoRequest;
import br.com.vollclinica.dto.MedicoResponse;
import br.com.vollclinica.entities.Medico;

public class MedicoConverter {

    public static Medico toMedico(MedicoRequest medicoRequest){
        return Medico.builder()
                .crm(medicoRequest.crm())
                .email(medicoRequest.email())
                .nome(medicoRequest.nome())
                .telefone(medicoRequest.telefone())
                .especialidade(medicoRequest.especialidade())
                .endereco(EnderecoConverter.toEndereco(medicoRequest.endereco()))
                .build();
    }

    public static MedicoResponse toMedicoResponse(Medico medico){
        return MedicoResponse.builder()
                .crm(medico.getCrm())
                .email(medico.getEmail())
                .nome(medico.getNome())
                .especialidade(medico.getEspecialidade())
                .build();
    }
}
