package com.giovana.library.services;

import com.giovana.library.entity.Emprestimo;
import com.giovana.library.entity.Livro;
import com.giovana.library.entity.Usuario;
import com.giovana.library.repositories.EmprestimoRepository;
import com.giovana.library.repositories.LivroRepository;
import com.giovana.library.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void initDataBase() {

        Livro livro1 = new Livro(null, "45612", "HP1", "Hermione Granger", "Rocco", "Infantojuvenil", false);
        Livro livro2 = new Livro(null, "12345", "HP2", "Hermione Granger", "Rocco", "Infantojuvenil", false);
        Livro livro3 = new Livro(null, "78945", "HP3", "Hermione Granger", "Rocco", "Infantojuvenil", false);
        Livro livro4 = new Livro(null, "45784", "HP4", "Hermione Granger", "Rocco", "Infantojuvenil", false);
        Livro livro5 = new Livro(null, "12548", "HP5", "Hermione Granger", "Rocco", "Infantojuvenil", false);
        Livro livro6 = new Livro(null, "63254", "HP6", "Hermione Granger", "Rocco", "Infantojuvenil", false);
        Livro livro7 = new Livro(null, "58796", "HP7", "Hermione Granger", "Rocco", "Infantojuvenil", false);

        Usuario usuario1 = new Usuario(null, "123456", "João", "joao@email.com", "2B", "12345678909");
        Usuario usuario2 = new Usuario(null, "698745", "Maria", "maria@email.com", "3B", "96385274151");
        Usuario usuario3 = new Usuario(null, "635241", "Pedro", "pedro@email.com", "1C", "09876543211");

        Emprestimo emprestimo1 = new Emprestimo(null, "26/1/2023", "9/2/2023", usuario1, livro1);
        livro1.setStatus(true);
        Emprestimo emprestimo2 = new Emprestimo(null, "27/1/2023", "10/2/2023", usuario2, livro3);
        livro3.setStatus(true);
        Emprestimo emprestimo3 = new Emprestimo(null, "28/1/2023", "11/2/2023", usuario3, livro5);
        livro5.setStatus(true);
        Emprestimo emprestimo4 = new Emprestimo(null, "29/1/2023", "12/2/2023", usuario1, livro2);
        livro2.setStatus(true);

        usuario1.getEmprestimos().add(emprestimo1);
        usuario2.getEmprestimos().add(emprestimo2);
        usuario3.getEmprestimos().add(emprestimo3);
        usuario1.getEmprestimos().add(emprestimo4);

        livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3, livro4, livro5, livro6, livro7));
        usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3));
        emprestimoRepository.saveAll(Arrays.asList(emprestimo1, emprestimo2, emprestimo3, emprestimo4));
    }

}
