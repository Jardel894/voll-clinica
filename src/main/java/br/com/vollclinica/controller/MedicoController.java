package br.com.vollclinica.controller;

import br.com.vollclinica.dto.MedicoRequest;
import br.com.vollclinica.service.MedicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
