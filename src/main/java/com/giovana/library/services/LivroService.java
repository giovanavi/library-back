package com.giovana.library.services;

import com.giovana.library.entity.Emprestimo;
import com.giovana.library.entity.Livro;
import com.giovana.library.repositories.LivroRepository;
import com.giovana.library.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private EmprestimoService emprestimoService;

    public Livro findById(Integer id){
        Optional<Livro> livro = livroRepository.findById(id);
        return livro.orElseThrow( () -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: "+id+" - Tipo: "+Livro.class.getName()));
    }

    public List<Livro> findAll(){
        return livroRepository.findAll();
    }

    public Livro create(Livro livro){
        return livroRepository.save(livro);
    }

    public Livro update(Integer id, Livro livro) {
        //alterando informações do livro no emprestimo
        Emprestimo emp = livro.getEmprestimo();
        emp.setLivro(livro);
        emprestimoService.update(emp.getId(), emp);


        Livro l = findById(id);
        l.setNome(livro.getNome());
        l.setIsbn(livro.getIsbn());
        l.setAutor(livro.getAutor());
        l.setEditora(livro.getEditora());
        l.setGenero(livro.getGenero());
        l.setStatus(livro.getStatus());

        return livroRepository.save(l);
    }
}
