package br.com.vollclinica.service.serviceImpl;

import br.com.vollclinica.converter.MedicoConverter;
import br.com.vollclinica.dto.MedicoRequest;
import br.com.vollclinica.dto.MedicoResponse;
import br.com.vollclinica.entities.Medico;
import br.com.vollclinica.repository.MedicoRepository;
import br.com.vollclinica.service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoServiceImpl  implements MedicoService {

    private final MedicoRepository medicoRepository;

    public void cadastrarMedico(MedicoRequest medicoRequest){
        Medico medico = MedicoConverter.toMedico(medicoRequest);
        medicoRepository.save(medico);

    }

    public Page<MedicoResponse> listarMedicos(Pageable pageable){
      Page<Medico> medicoList = medicoRepository.findAll(pageable);
      return medicoList.map(MedicoConverter::toMedicoResponse);
    }
}
