package com.giovana.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "livro")
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String isbn;

    @Getter @Setter
    private String  nome;

    @Getter @Setter
    private String autor;

    @Getter @Setter
    private String editora;

    @Getter @Setter
    private String genero;

    @Getter @Setter
    private boolean status;

    @JsonIgnoreProperties(value = {"usuario", "livro"})
    @OneToOne(mappedBy = "livro", cascade = CascadeType.REMOVE, targetEntity = Emprestimo.class)
    @Getter @Setter
    private Emprestimo emprestimo;

    public Livro(String isbn, String nome, String autor, String editora, String genero, boolean status) {
        this.isbn = isbn;
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.genero = genero;
        this.status = status;
    }
}
