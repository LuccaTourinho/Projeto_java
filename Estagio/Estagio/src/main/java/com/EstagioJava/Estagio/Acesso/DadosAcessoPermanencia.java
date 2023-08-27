package com.EstagioJava.Estagio.Acesso;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record DadosAcessoPermanencia(
        @NotBlank
        Long ID_acesso,
        @ManyToOne
        @JoinColumn(name = "ID_cadastro")
        Long ID_cadastro,
        LocalTime permanencia){

    public DadosAcessoPermanencia(Acesso acesso){
            this(acesso.getID_acesso(), acesso.getID_cadastro(), acesso.getPermanencia());
    }
}
