package com.example.exmod7.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor //obrigatorio para o JPA funcionar
public class Ator {
    @Id
    @GeneratedValue
    private Integer id;

    private String nome;
    @ManyToMany
    private List<Filme> listaFilmes;
}
