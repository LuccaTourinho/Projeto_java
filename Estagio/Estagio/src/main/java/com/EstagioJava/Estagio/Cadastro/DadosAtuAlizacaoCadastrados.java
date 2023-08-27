package com.EstagioJava.Estagio.Cadastro;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtuAlizacaoCadastrados(
        @NotNull
        Long ID_cadastro,

        @Pattern(regexp = "^(\\d{1,3})?\\s\\d{9}$")
        String telefone,
        @Valid
        DadosEndereco dadosEndereco) {
}
