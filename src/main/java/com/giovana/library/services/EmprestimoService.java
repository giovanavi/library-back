package com.giovana.library.services;

import com.giovana.library.entity.Emprestimo;
import com.giovana.library.entity.Livro;
import com.giovana.library.repositories.EmprestimoRepository;
import com.giovana.library.repositories.LivroRepository;
import com.giovana.library.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;
    @Autowired
    private LivroRepository livroRepository;

    public Emprestimo findById(Integer id){
        Optional<Emprestimo> emp =  emprestimoRepository.findById(id);
        return emp.orElseThrow( () -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: "+id+" - Tipo: "+ Emprestimo.class.getName()));
    }

    public List<Emprestimo> findAll(){
        return emprestimoRepository.findAll();
    }

    public Emprestimo create(Emprestimo emp){
        Livro livro = emp.getLivro();
        livro.setStatus("true");
        livroRepository.save(emp.getLivro());

        return emprestimoRepository.save(emp);
    }
}
