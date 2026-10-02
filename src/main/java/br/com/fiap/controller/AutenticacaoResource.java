package br.com.fiap.controller;

import br.com.fiap.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoResource {

    private TokenService service;

    public AutenticacaoResource(TokenService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(Authentication authentication) {
        String token = service.gerarToken(authentication);
        return ResponseEntity.ok(token);
    }

}
