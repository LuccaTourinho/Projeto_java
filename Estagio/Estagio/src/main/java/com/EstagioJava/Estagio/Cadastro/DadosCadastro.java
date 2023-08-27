package com.EstagioJava.Estagio.Cadastro;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DadosCadastro(
        @NotBlank
        @Pattern(regexp = "^[A-ZÀ-Ú ]{1,60}$")
        String nome,
        @NotNull
        LocalDate data_nascimento,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String CPF,
        @NotBlank
        @Pattern(regexp = "^(\\d{1,3})?\\s\\d{9}$")
        String telefone,
        @NotBlank
        @Email
        String email,

        @NotNull @Valid
        DadosEndereco endereco) {
}
