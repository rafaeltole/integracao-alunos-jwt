package br.com.fiap.controller;

import br.com.fiap.dto.TurmaRequest;
import br.com.fiap.dto.TurmaResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/turmas")
public class TurmaResource {

    private AtomicLong sequence = new AtomicLong();
    private List<TurmaResponse> turmas = new ArrayList<>();

    @PostMapping
    public ResponseEntity<TurmaResponse> cadastrar(@RequestBody @Valid TurmaRequest request) {
        TurmaResponse response = new TurmaResponse(
                sequence.incrementAndGet(),
                request.cursoId(),
                request.nome());

        turmas.add(response);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TurmaResponse>> consultar() {
        return ResponseEntity.ok(turmas);
    }

}
