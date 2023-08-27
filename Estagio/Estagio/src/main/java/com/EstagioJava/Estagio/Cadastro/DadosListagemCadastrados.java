package com.EstagioJava.Estagio.Cadastro;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosListagemCadastrados(
        @NotNull
        Long ID_cadastro,
        @NotBlank
        @Pattern(regexp = "^[A-Z]{1,60}$")
        String nome,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String CPF,
        @NotBlank
        @Pattern(regexp = "^(\\d{1,3})?\\s\\d{9}$")
        String telefone,
        @NotBlank
        @Email
        String email) {

    public DadosListagemCadastrados(Cadastro cadastro){
        this(cadastro.getID_cadastro(), cadastro.getNome(), cadastro.getCPF(), cadastro.getTelefone(), cadastro.getEmail());
    }
}
