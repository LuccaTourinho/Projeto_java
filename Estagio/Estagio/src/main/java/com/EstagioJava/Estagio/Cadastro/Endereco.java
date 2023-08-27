package com.EstagioJava.Estagio.Cadastro;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String UF;
    private String municipio;
    private String CEP;
    private String complemento;

    public Endereco(DadosEndereco dados) {
        this.UF = dados.UF();;
        this.municipio = dados.municipio();
        this.CEP = dados.CEP();
        this.complemento = dados.complemento();
    }

    public void atualizarEndereco(DadosEndereco dadosEndereco) {
        if(dadosEndereco.UF() != null){
            this.UF = dadosEndereco.UF();
        }
       if(dadosEndereco.municipio() != null){
           this.municipio = dadosEndereco.municipio();
       }
       if(dadosEndereco.CEP() != null){
           this.CEP = dadosEndereco.CEP();
       }
       if(dadosEndereco.complemento() != null){
           this.complemento = dadosEndereco.complemento();
       }
    }
}
