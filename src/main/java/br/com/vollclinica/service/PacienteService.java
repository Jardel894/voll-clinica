package br.com.vollclinica.service;

import br.com.vollclinica.dto.MedicoUpdateRequest;
import br.com.vollclinica.dto.PacienteRequest;
import br.com.vollclinica.dto.PacienteResponse;
import br.com.vollclinica.dto.PacienteUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PacienteService {

    void cadastrarPaciente(PacienteRequest pacienteRequest);

    Page<PacienteResponse> listarPacientes(Pageable pageable);

    void atualizarDadosPacientes(PacienteUpdateRequest pacienteUpdateRequest, Long id);

    void deletarPaciente(Long id);
}
