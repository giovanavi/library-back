package com.giovana.library;

import com.giovana.library.entity.Emprestimo;
import com.giovana.library.entity.Livro;
import com.giovana.library.entity.Usuario;
import com.giovana.library.repositories.EmprestimoRepository;
import com.giovana.library.repositories.LivroRepository;
import com.giovana.library.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	@Autowired
	private EmprestimoRepository emprestimoRepository;

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Livro livro = new Livro(null, "Percy Jackson 1", "Rick Riordan", "Rocco", "Infantojuvenil", true);
		Usuario usuario = new Usuario(null, "123456", "João", "joao@email.com", "2B", "12345678909");

		Emprestimo emprestimo = new Emprestimo(null, "26/1/2023", "9/2/2023", usuario, livro);

		usuario.getEmprestimos().add(emprestimo);

		livroRepository.save(livro);
		usuarioRepository.save(usuario);
		emprestimoRepository.save(emprestimo);

	}
}
