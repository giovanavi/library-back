package com.giovana.library.dto;

import com.giovana.library.entity.Livro;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter @Setter
public class LivroDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String autor;
    private String status;


    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getNome();
        this.autor = livro.getAutor();
        this.status = livro.getStatus();
    }
}
