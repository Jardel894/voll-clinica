package br.com.vollclinica.controller;

import br.com.vollclinica.dto.MedicoUpdateRequest;
import br.com.vollclinica.dto.PacienteRequest;
import br.com.vollclinica.dto.PacienteResponse;
import br.com.vollclinica.dto.PacienteUpdateRequest;
import br.com.vollclinica.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    Page<PacienteResponse> listarPacientes(@PageableDefault(size = 5, sort = {"id"}) Pageable pageable){
        return pacienteService.listarPacientes(pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("{id}")
    public void atulizarDadosPaciente(@RequestBody PacienteUpdateRequest pacienteUpdateRequest, @PathVariable Long id){
        pacienteService.atualizarDadosPacientes(pacienteUpdateRequest, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deletarPaciente(@PathVariable Long id){
        pacienteService.deletarPaciente(id);
}
}
