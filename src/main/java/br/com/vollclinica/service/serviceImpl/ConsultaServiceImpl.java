package br.com.vollclinica.service.serviceImpl;

import br.com.vollclinica.dto.ConsultaRequest;
import br.com.vollclinica.entities.Consulta;
import br.com.vollclinica.entities.Medico;
import br.com.vollclinica.entities.Paciente;
import br.com.vollclinica.repository.ConsultaRepository;
import br.com.vollclinica.repository.MedicoRepository;
import br.com.vollclinica.repository.PacienteRepository;
import br.com.vollclinica.service.ConsultaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;

    private final MedicoRepository medicoRepository;

    private final PacienteRepository pacienteRepository;

    @Transactional
    @Override
    public void cadastrarConsulta(ConsultaRequest consultaRequest) {

        Medico medico = escolherMedico(consultaRequest);
        Paciente paciente = pacienteRepository.findById(consultaRequest.idPaciente()).orElseThrow(() -> new RuntimeException("Paciente não Encontrado"));
        consultaRepository.save(new Consulta(null, medico, paciente, consultaRequest.data()));
    }

    private Medico escolherMedico(ConsultaRequest consultaRequest) {

        if (consultaRequest.idMedico() != null) {
            return medicoRepository.findById(consultaRequest.idMedico()).orElseThrow(() -> new RuntimeException("Medico não Encontrado"));
        }
        if (consultaRequest.especialidade() == null){
            throw new RuntimeException("Especialidade é obrigatŕio quando médico não for escolhido");
        }
        return medicoRepository.findByEspecialidade(consultaRequest.especialidade()).get(0);
    }
}
