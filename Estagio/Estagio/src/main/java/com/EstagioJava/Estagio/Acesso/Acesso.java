package com.EstagioJava.Estagio.Acesso;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Table(name = "Acesso")
@Entity(name = "Acesso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "ID_acesso")
public class Acesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_acesso;
    private Long ID_cadastro;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private LocalTime permanencia;

    public Acesso(DadosAcesso dados){
        this.ID_cadastro = dados.ID_cadastro();
        this.entrada = dados.entrada();
    }

    public void Saida(DadosAcessoSaida dados) {
        this.saida = dados.saida();
    }

    public void calcularPermanencia(){
        if (entrada != null && saida != null) {
            Duration duracao = Duration.between(entrada, saida);

            long horas = duracao.toHours();
            long minutosRestantes = duracao.minusHours(horas).toMinutes();
            long segundosRestantes = duracao.minusHours(horas).minusMinutes(minutosRestantes).getSeconds();

            this.permanencia = LocalTime.of((int) horas, (int) minutosRestantes, (int) segundosRestantes);
        }
    }
}
