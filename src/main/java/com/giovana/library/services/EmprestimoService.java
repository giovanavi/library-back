package com.giovana.library.services;

import com.giovana.library.dto.EmprestimoDTO;
import com.giovana.library.entity.Emprestimo;
import com.giovana.library.entity.Livro;
import com.giovana.library.entity.Usuario;
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
    @Autowired
    private LivroService livroService;

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
        livroService.update(emp.getLivro().getId(), emp.getLivro());

        return emprestimoRepository.save(emp);
    }

    public Emprestimo update(Integer id, Emprestimo emp){
        Emprestimo e = findById(id);

        e.setDataEmprestimo(emp.getDataEmprestimo());
        e.setDataDevolucao(emp.getDataDevolucao());

        return emprestimoRepository.save(e);
    }
}
