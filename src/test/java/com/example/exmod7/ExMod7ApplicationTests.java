package com.example.exmod7;

import com.example.exmod7.domain.Filme;
import com.example.exmod7.service.FilmeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ExMod7ApplicationTests {

    @Autowired
    private FilmeService filmeService;

    @Test
    public void testaInsercaoNoBanco() {
        Filme filme = Filme.builder()
                .nome("Titanic")
                .genero("Drama")
                .ano("1999");

        filmeService.cadastraFilme(filme);

        List<Filme> filmeService.listarFilmes();

    }

}
