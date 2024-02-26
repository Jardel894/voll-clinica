package br.com.vollclinica.controller;

import br.com.vollclinica.dto.ConsultaRequest;
import br.com.vollclinica.service.ConsultaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("v1/consulta")
@SecurityRequirement(name = "bearer-key")
@RequiredArgsConstructor
@RestController
public class ConsultaController {

    private final ConsultaService consultaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void cadastrarConsultas( @Valid @RequestBody ConsultaRequest consultaRequest){
        consultaService.cadastrarConsulta(consultaRequest);
    }
}
