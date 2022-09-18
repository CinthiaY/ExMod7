package com.example.exmod7.controller;

import com.example.exmod7.domain.Filme;
import com.example.exmod7.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //pra dizer que a classe eh injetavel, faz o mesmo que o @Service
@RequestMapping("/filmes")
public class FilmeController { //serve para chamar os Services quando precisar (rotear)

    @Autowired
    private FilmeService filmeService;

//    @Autowired //todos que entram no construtor sao injetaveis
//    public FilmeController (FilmeService filmeService) {
//        this.filmeService = filmeService;
//    }
//
    @GetMapping
    public ResponseEntity <Filme> procurarFilmePorNome(@RequestParam String nome, @RequestParam String genero, @RequestParam Integer ano) {
        Filme filme = filmeService.retornaFilme(nome, genero, ano);
        if (filme == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(filme);
    }

//    @GetMapping
//    public ResponseEntity <Filme> procurarFilmePorAtor(@RequestParam String nome) {
//        Filme filme = filmeService.retornaFilmePorAtor(nome);
//        if (filme == null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        return ResponseEntity.ok(filme);
//    }

    @PostMapping
    public ResponseEntity <Filme> cadastraFilme (@RequestBody Filme filme) {
        filmeService.cadastraFilme(filme);
        return new ResponseEntity<>(filme, HttpStatus.CREATED);
    }

}
