package com.example.exmod7.repository;

import com.example.exmod7.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//@Repository //tambem eh igual ao @Service e @RestController, eh para dizer que eh injetavel
public interface FilmeRepository extends JpaRepository <Filme, Integer> {//responsavel por pegar os dados, chamar outra API

    @Query("Select f from Filme f where f.nome = ?1 and f.genero = ?2 and f.ano=?3")
    Filme findByNomeOrGeneroOrAno(String nome, String genero, Integer ano);

    Filme findByAtores_Nome(String ator);
}
