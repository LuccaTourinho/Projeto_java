package com.EstagioJava.Estagio.Acesso;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAcesso(
        @ManyToOne
        @JoinColumn(name = "ID_cadastro")
        Long ID_cadastro,
        @NotNull
        LocalDateTime entrada
) {
}
