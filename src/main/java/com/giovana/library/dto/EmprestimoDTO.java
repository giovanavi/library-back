package com.giovana.library.dto;

import com.giovana.library.entity.Emprestimo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class EmprestimoDTO implements Serializable {

    private Integer id;
    private String dataEmprestimo;
    private String dataDevolucao;
    private String usuario;
    private String email;
    private String livro;
    private String isbn;

    public EmprestimoDTO(Emprestimo emp) {
        this.id = emp.getId();
        this.dataEmprestimo = emp.getDataEmprestimo();
        this.dataDevolucao = emp.getDataDevolucao();
        this.usuario = emp.getUsuario().getNome();
        this.email = emp.getUsuario().getEmail();
        this.livro = emp.getLivro().getNome();
        this.isbn = emp.getLivro().getIsbn();
    }
}
