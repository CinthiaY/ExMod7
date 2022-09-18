package com.example.exmod7.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@AllArgsConstructor
@Entity //JPA - cada registro da tabela eh um Filme -Object Relational Mapping - o JPA vai linkar os dados SOMEHOW (???)
@Getter
@Setter
@Builder //uso no teste
@RequiredArgsConstructor //para usar o Builder
@NoArgsConstructor //JPA precisa do construtor padrao para funcionar (OBRIGATORIO) -->filme()
public class Filme {
    @Id
    @GeneratedValue //equivalente ao Serial no SQL
    private Integer id;
    private String nome;
    private String genero;
    private Integer ano;

    @ManyToMany
    private List<Ator> atores;

}
