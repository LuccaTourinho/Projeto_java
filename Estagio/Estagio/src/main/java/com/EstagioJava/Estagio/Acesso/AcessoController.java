package com.EstagioJava.Estagio.Acesso;

import com.EstagioJava.Estagio.Cadastro.DadosListagemCadastrados;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Acesso")
public class AcessoController {

    @Autowired
    private AcessoRepository repository;

    @PostMapping
    @Transactional
    public void Entrada(@RequestBody @Valid DadosAcesso dados) {

        Long entradasSemsaida = repository.countActiveEntriesByCadastro(dados.ID_cadastro());

        if(entradasSemsaida == 0){
            repository.save(new Acesso(dados));
        }else {
            throw new IllegalStateException("Já existe uma entrada ativa para o ID_cadastro fornecido.");
        }
    }

    @PutMapping
    @Transactional
    public void Saida(@RequestBody @Valid DadosAcessoSaida dados){
        var acesso = repository.getReferenceById(dados.ID_acesso());
        acesso.Saida(dados);
        acesso.calcularPermanencia();
    }

    @GetMapping
    public Page<DadosAcessoPermanencia> Permanencia(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosAcessoPermanencia::new);
    }

    @DeleteMapping("/{ID_acesso}")
    @Transactional
    public void cancelar(@PathVariable Long ID_acesso){
        repository.deleteById(ID_acesso);
    }
}
