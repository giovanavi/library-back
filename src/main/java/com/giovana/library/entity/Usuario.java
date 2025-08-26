package com.giovana.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "usuario")
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "o campo NOME é obrigatório")
    @Length(min = 3, max = 100)
    private String nome;

    @Column(unique = true)
    @NotEmpty(message = "o campo EMAIL é obrigatório")
    @Length(min = 3, max = 100)
    private String email;


    @Column(unique = true)
    @NotEmpty(message = "o campo CPF é obrigatório")
    @Length(min = 11, max = 11)
    private String cpf;

    @JsonIgnoreProperties(value = {"usuario", "livro"})
    @OneToMany(mappedBy = "usuario")
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Usuario(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }
}