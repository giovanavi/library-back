package com.giovana.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotEmpty;

import java.io.Serializable;

@CrossOrigin("*")
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

    @NotEmpty(message = "o campo ISBN é obrigatório")
    @Length(min = 8, max = 13)
    private String isbn;

    @NotEmpty(message = "o campo NOME é obrigatório")
    @Length(min = 3, max = 100)
    private String nome;

    @NotEmpty(message = "o campo AUTOR é obrigatório")
    @Length(min = 3, max = 100)
    private String autor;

    @NotEmpty(message = "o campo EDITORA é obrigatório")
    @Length(min = 3, max = 50)
    private String editora;

    @NotEmpty(message = "o campo GENRERO é obrigatório")
    @Length(min = 3, max = 50)
    private String genero;

    private String status;

    @JsonIgnoreProperties(value = {"usuario", "livro"})
    @OneToOne(mappedBy = "livro", targetEntity = Emprestimo.class)
    private Emprestimo emprestimo;

    public Livro(String isbn, String nome, String autor, String editora, String genero, String status) {
        this.isbn = isbn;
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.genero = genero;
        this.status = status;
    }

    public Livro(String isbn, String nome, String autor, String editora, String genero) {
        this.isbn = isbn;
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.genero = genero;
        this.status = "false";
    }
}
