package br.com.vollclinica.controller;

import br.com.vollclinica.dto.MedicoRequest;
import br.com.vollclinica.dto.MedicoResponse;
import br.com.vollclinica.service.MedicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("v1/medicos")
@RestController
public class MedicoController {

    private final MedicoService medicoService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public void cadastrarMedico(@RequestBody @Valid MedicoRequest medicoRequest){
        medicoService.cadastrarMedico(medicoRequest);
    }

    @GetMapping
    Page<MedicoResponse> listarMedicos(@PageableDefault(size = 5, sort = {"nome"}) Pageable pageable){
        return medicoService.listarMedicos(pageable);
    }
}
