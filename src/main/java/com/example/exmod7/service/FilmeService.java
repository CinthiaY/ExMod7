package com.example.exmod7.service;

import com.example.exmod7.domain.Filme;
import com.example.exmod7.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //para tornar injetavel - tudo que eh injetavel eh singleton
public class FilmeService { //responsavel por acessar os repositories

    @Autowired
    private FilmeRepository filmeRepository;

    public Filme retornaFilme(String nome, String genero, Integer ano) {
        return filmeRepository.findByNomeOrGeneroOrAno(nome, genero, ano);
    }


    public void cadastraFilme(Filme filme) {
        filmeRepository.save(filme);
    }

    public Filme retornaFilmePorAtor(String ator) {
        return filmeRepository.findByAtores_Nome(ator);
    }

    public List<Filme> listarFilmes() {
        return filmeRepository.findAll();
    }

    public Filme buscaPorId(Integer id) {
        Optional<Filme> filmeOptional = filmeRepository.findById(id);
        if(filmeOptional.isEmpty()){
            throw new IllegalArgumentException("Id invalido");
        }
        return filmeOptional.get(); //retorna o objeto Filme
    }

    public Filme removeFilme(Integer id){
        Filme filme = this.buscaPorId(id);
        filmeRepository.delete(filme);
        return filme; //retorna o item que ta em memoria
    }


}

