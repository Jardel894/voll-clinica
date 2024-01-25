package br.com.vollclinica.controller;

import br.com.vollclinica.dto.PacienteRequest;
import br.com.vollclinica.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("v1/pacientes")
@RestController
public class PacienteController {

    private final PacienteService pacienteService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void cadastrarPaciente(@RequestBody PacienteRequest pacienteRequest){
         pacienteService.cadastrarPaciente(pacienteRequest);
    }
}
