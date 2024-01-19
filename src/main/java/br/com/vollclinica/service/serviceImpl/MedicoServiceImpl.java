package br.com.vollclinica.service.serviceImpl;

import br.com.vollclinica.converter.MedicoConverter;
import br.com.vollclinica.dto.MedicoRequest;
import br.com.vollclinica.entities.Medico;
import br.com.vollclinica.repository.MedicoRepository;
import br.com.vollclinica.service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicoServiceImpl  implements MedicoService {

    private final MedicoRepository medicoRepository;

    public void cadastrarMedico(MedicoRequest medicoRequest){
        Medico medico = MedicoConverter.toMedico(medicoRequest);
        medicoRepository.save(medico);

    }
}
