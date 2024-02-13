package br.com.vollclinica.service.serviceImpl;

import br.com.vollclinica.converter.EnderecoConverter;
import br.com.vollclinica.converter.PacienteConverter;
import br.com.vollclinica.dto.MedicoUpdateRequest;
import br.com.vollclinica.dto.PacienteRequest;
import br.com.vollclinica.dto.PacienteResponse;
import br.com.vollclinica.dto.PacienteUpdateRequest;
import br.com.vollclinica.entities.Medico;
import br.com.vollclinica.entities.Paciente;
import br.com.vollclinica.repository.PacienteRepository;
import br.com.vollclinica.service.PacienteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

   public void cadastrarPaciente(PacienteRequest pacienteRequest){

       Paciente paciente = PacienteConverter.toPaciente(pacienteRequest);
       pacienteRepository.save(paciente);
   }

    @Override
    public Page<PacienteResponse> listarPacientes(Pageable pageable) {
       Page<Paciente> pacienteList= pacienteRepository.findAll(pageable);
       return pacienteList.map(PacienteConverter::toPacienteResponse);

    }

    @Override
    public void atualizarDadosPacientes(PacienteUpdateRequest pacienteUpdateRequest, Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado!"));
        paciente.setNome(pacienteUpdateRequest.nome() == null ? paciente.getNome() : pacienteUpdateRequest.nome());
        paciente.setEmail(pacienteUpdateRequest.email() == null ? paciente.getEmail() : pacienteUpdateRequest.email());
        paciente.setTelefone(pacienteUpdateRequest.telefone() == null ? paciente.getTelefone() : pacienteUpdateRequest.telefone());
        paciente.setEndereco(EnderecoConverter.toEndereco(pacienteUpdateRequest.endereco()));
        pacienteRepository.save(paciente);
    }

    @Transactional
    @Override
    public void deletarPaciente(Long id) {
       pacienteRepository.deleteById(id);
    }
}
