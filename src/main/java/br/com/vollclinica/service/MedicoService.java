package br.com.vollclinica.service;

import br.com.vollclinica.dto.MedicoRequest;
import br.com.vollclinica.dto.MedicoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface MedicoService {

     void cadastrarMedico(MedicoRequest medicoRequest);

      Page<MedicoResponse> listarMedicos(Pageable pageable);
}
