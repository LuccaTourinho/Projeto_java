package com.EstagioJava.Estagio.Cadastro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "Cadastro")
@Entity(name = "Cadastro")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "ID_cadastro")
public class Cadastro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_cadastro;
    private String nome;
    private LocalDate data_nascimento;
    private String CPF;
    private String telefone;
    private String email;

    @Embedded
    private Endereco endereco;

    public Cadastro(DadosCadastro dados) {
        this.nome = dados.nome();
        this.data_nascimento = dados.data_nascimento();
        this.CPF = dados.CPF();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarCadastro(DadosAtuAlizacaoCadastrados dados) {
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.dadosEndereco() != null){
            this.endereco.atualizarEndereco(dados.dadosEndereco());
        }
    }
}
