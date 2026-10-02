package br.com.fiap.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TurmaRequest(
        @NotNull(message = "Código do curso deve ser informado.") Long cursoId,
        @NotBlank(message = "Nome da turma deve ser informado.") String nome) {
}
