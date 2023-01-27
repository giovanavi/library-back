package com.giovana.library.services;

import com.giovana.library.entity.Livro;
import com.giovana.library.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    LivroRepository repository;

    public Livro findById(Integer id){
        Optional<Livro> livro = repository.findById(id);
        return livro.orElse(null);
    }

}
