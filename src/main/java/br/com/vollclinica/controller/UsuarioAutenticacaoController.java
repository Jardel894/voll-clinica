package br.com.vollclinica.controller;

import br.com.vollclinica.dto.UserRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RequiredArgsConstructor
@RestController
public class UsuarioAutenticacaoController {

    private final AuthenticationManager manager;

    @PostMapping
    public ResponseEntity efetuarLogin(@Valid @RequestBody UserRequest userRequest){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userRequest.login(), userRequest.senha());
        Authentication authentication = manager.authenticate(token);
        return ResponseEntity.ok().build();

    }
}
