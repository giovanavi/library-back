package com.giovana.library.services;

import com.giovana.library.entity.Emprestimo;
import com.giovana.library.entity.Livro;
import com.giovana.library.repositories.EmprestimoRepository;
import com.giovana.library.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public Emprestimo findById(Integer id){
        Optional<Emprestimo> emp =  emprestimoRepository.findById(id);
        return emp.orElseThrow( () -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: "+id+" - Tipo: "+ Emprestimo.class.getName()));
    }

    public List<Emprestimo> findAll(){
        return emprestimoRepository.findAll();
    }

    public Emprestimo create(Emprestimo emp){
        return emprestimoRepository.save(emp);
    }

    public Emprestimo update(Integer id, Emprestimo emp){
        Emprestimo e = findById(id);

        e.setDataEmprestimo(emp.getDataEmprestimo());
        e.setDataDevolucao(emp.getDataDevolucao());
        e.setUsuario(emp.getUsuario());
        e.setLivro(emp.getLivro());

        return emprestimoRepository.save(e);
    }
}
