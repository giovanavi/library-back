package com.giovana.library.services;

import com.giovana.library.entity.Emprestimo;
import com.giovana.library.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository repository;

    public Emprestimo findById(Integer id){
        Optional<Emprestimo> emp =  repository.findById(id);
        return emp.orElse(null);
    }

}
