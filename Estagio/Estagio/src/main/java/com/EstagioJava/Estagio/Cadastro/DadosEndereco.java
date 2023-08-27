package com.EstagioJava.Estagio.Cadastro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record DadosEndereco(
        @NotBlank
        @Pattern(regexp = "^[A-Z]{2}$")
        String UF,
        @NotBlank
        @Pattern(regexp = "^[A-ZÀ-Ú ]{1,40}$")
        String municipio,
        @NotBlank
        @Pattern(regexp = "^\\d{5}-\\d{3}$")
        String CEP,
        @NotBlank
        @Size(max = 255)
        String complemento) {
}
