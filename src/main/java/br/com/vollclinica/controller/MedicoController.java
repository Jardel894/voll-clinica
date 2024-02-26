package br.com.vollclinica.controller;

import br.com.vollclinica.dto.MedicoRequest;
import br.com.vollclinica.dto.MedicoResponse;
import br.com.vollclinica.dto.MedicoUpdateRequest;
import br.com.vollclinica.service.MedicoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("v1/medicos")
@SecurityRequirement(name = "bearer-key")
@RestController
public class MedicoController {

    private final MedicoService medicoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void cadastrarMedico(@RequestBody @Valid MedicoRequest medicoRequest){
        medicoService.cadastrarMedico(medicoRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    Page<MedicoResponse> listarMedicos(@PageableDefault(size = 5, sort = {"id"}) Pageable pageable){
        return medicoService.listarMedicos(pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("{id}")
    public void atulizarDadosMedico(@RequestBody MedicoUpdateRequest medicoUpdateRequest, @PathVariable Long id){
        medicoService.atualizarDadosMedico(medicoUpdateRequest, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deletarMedico(@PathVariable Long id){
        medicoService.deletarMedico(id);
    }
}
