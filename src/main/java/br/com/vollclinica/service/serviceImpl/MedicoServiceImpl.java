package br.com.vollclinica.service.serviceImpl;

import br.com.vollclinica.converter.EnderecoConverter;
import br.com.vollclinica.converter.MedicoConverter;
import br.com.vollclinica.dto.MedicoRequest;
import br.com.vollclinica.dto.MedicoResponse;
import br.com.vollclinica.dto.MedicoUpdateRequest;
import br.com.vollclinica.entities.Medico;
import br.com.vollclinica.repository.MedicoRepository;
import br.com.vollclinica.service.MedicoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    @Transactional
    public void atualizarDadosMedico(MedicoUpdateRequest medicoUpdateRequest, Long id){
        Medico medicoSalvo = medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Medico não encontrado!"));
        medicoSalvo.setNome(medicoUpdateRequest.nome() == null ? medicoSalvo.getNome() : medicoUpdateRequest.nome());
        medicoSalvo.setEmail(medicoUpdateRequest.email() == null ? medicoSalvo.getEmail() : medicoUpdateRequest.email());
        medicoSalvo.setTelefone(medicoUpdateRequest.telefone() == null ? medicoSalvo.getTelefone() : medicoUpdateRequest.telefone());
        medicoSalvo.setEndereco(EnderecoConverter.toEndereco(medicoUpdateRequest.endereco()));
        medicoRepository.save(medicoSalvo);

    }
    @Transactional
    public void deletarMedico(Long id){
        Medico medicosalvo = medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Medico não encontrado!"));
        medicoRepository.delete(medicosalvo);

    }
}
