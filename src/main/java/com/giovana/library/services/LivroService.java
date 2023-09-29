package com.giovana.library.services;

import com.giovana.library.entity.Livro;
import com.giovana.library.repositories.LivroRepository;
import com.giovana.library.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro findById(Integer id){
        Optional<Livro> livro = livroRepository.findById(id);
        return livro.orElseThrow( () -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: "+id+" - Tipo: "+Livro.class.getName()));
    }

    public List<Livro> findByTitle(String str){
        Optional<List<Livro>> livros = Optional.ofNullable(livroRepository.findByNomeContainingIgnoringCase(str));
        return livros.orElseThrow( () -> new ObjectNotFoundException(
                "Nenhum livro encontrado! "));
    }

    public List<Livro> findAll(){
        return livroRepository.findAll();
    }

    public Livro create(Livro livro){
        livro.setStatus("false");
        return livroRepository.save(livro);
    }

    public void setStatusTrue(Livro livro){
        livro.setStatus("true");
        livroRepository.save(livro);
    }

    public void setStatusFalse(Livro livro){
        livro.setStatus("false");
        livroRepository.save(livro);
    }

    public Livro update(Integer id, Livro livro) {
        Livro newLivro = findById(id);
        updateData(newLivro, livro);

//        emprestimoService.update(newLivro.getEmprestimo().getId(), newLivro.getEmprestimo());

        return livroRepository.save(newLivro);
    }

    private void updateData(Livro newLivro, Livro livro){
        newLivro.setNome(livro.getNome());
        newLivro.setIsbn(livro.getIsbn());
        newLivro.setAutor(livro.getAutor());
        newLivro.setEditora(livro.getEditora());
        newLivro.setGenero(livro.getGenero());
        newLivro.setStatus(livro.getStatus());
    }

    public void delete(Integer id) {
        findById(id);
        try {
            livroRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new com.giovana.library.services.exceptions.DataIntegrityViolationException(
                    "Livro não pode ser excluido! Possui emprestimos associados" );
        }
    }
}
