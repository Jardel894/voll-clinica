package br.com.vollclinica.service.serviceImpl;

import br.com.vollclinica.converter.PacienteConverter;
import br.com.vollclinica.dto.PacienteRequest;
import br.com.vollclinica.entities.Paciente;
import br.com.vollclinica.repository.PacienteRepository;
import br.com.vollclinica.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

   public void cadastrarPaciente(PacienteRequest pacienteRequest){

       Paciente paciente = PacienteConverter.toPaciente(pacienteRequest);
       pacienteRepository.save(paciente);
   }
}
