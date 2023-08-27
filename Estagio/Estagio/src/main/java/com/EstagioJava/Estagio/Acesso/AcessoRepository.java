package com.EstagioJava.Estagio.Acesso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AcessoRepository extends JpaRepository<Acesso, Long> {
    @Query("SELECT COUNT(a) FROM Acesso a WHERE a.ID_cadastro = :ID_cadastro AND a.saida IS NULL")
    Long countActiveEntriesByCadastro(@Param("ID_cadastro") Long ID_cadastro);
}
