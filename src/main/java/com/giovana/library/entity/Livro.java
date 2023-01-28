package com.giovana.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "livro")
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String isbn;

    private String  nome;

    private String autor;

    private String editora;

    private String genero;

    private String status;

    @JsonIgnoreProperties(value = {"usuario", "livro"})
    @OneToOne(mappedBy = "livro", cascade = CascadeType.ALL, targetEntity = Emprestimo.class)
    private Emprestimo emprestimo;

    public Livro(String isbn, String nome, String autor, String editora, String genero, String status) {
        this.isbn = isbn;
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.genero = genero;
        this.status = status;
    }
}
