package com.EstagioJava.Estagio.Cadastro;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Cadastro")
public class CadastroController {

    @Autowired
    private CadastroRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastro dados){
        repository.save(new Cadastro(dados));
    }

    @GetMapping
    public Page<DadosListagemCadastrados> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemCadastrados::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtuAlizacaoCadastrados dados){
        var cadastro =  repository.getReferenceById(dados.ID_cadastro());
        cadastro.atualizarCadastro(dados);
    }

    @DeleteMapping("/{ID_cadastro}")
    @Transactional
    public void excluir(@PathVariable Long ID_cadastro){
        repository.deleteById(ID_cadastro);
    }
}
