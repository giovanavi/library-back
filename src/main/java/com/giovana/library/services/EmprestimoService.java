package com.giovana.library.services;

import com.giovana.library.entity.Emprestimo;
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
    private UsuarioService usuarioService;

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
        livroService.updateStatus(emp.getLivro());
        return emprestimoRepository.save(emp);
    }

    public Emprestimo update(Integer id, Emprestimo emp){
        Emprestimo newEmp = findById(id);
        updateData(newEmp, emp);

        return emprestimoRepository.save(newEmp);
    }

    private void updateData(Emprestimo newEmp, Emprestimo emp){
        newEmp.setDataEmprestimo(emp.getDataEmprestimo());
        newEmp.setDataDevolucao(emp.getDataDevolucao());
        newEmp.setLivro(emp.getLivro());
    }

    public void delete(Integer id) {
        findById(id);
        livroService.updateStatus(findById(id).getLivro());
        emprestimoRepository.deleteById(id);
    }

    public List<Emprestimo> findAllByUser(Integer id) {
        usuarioService.findById(id);
        return emprestimoRepository.findAllByUser(id);
    }
}
