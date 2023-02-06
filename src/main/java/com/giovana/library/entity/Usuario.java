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
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @Length(min = 6, max = 6)
    private String matricula;

    @NotEmpty(message = "campo obrigatório")
    @Length(min = 3, max = 100)
    private String nome;
    @Column(unique = true)
    @NotEmpty(message = "campo obrigatório")
    @Length(min = 3, max = 100)
    private String email;

    private String turma;

    @Column(unique = true)
    @NotEmpty(message = "campo obrigatório")
    @Length(min = 11, max = 11)
    private String cpf;

    @JsonIgnoreProperties(value = {"usuario", "livro"})
    @OneToMany(mappedBy = "usuario")
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Usuario(String matricula, String nome, String email, String turma, String cpf) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.turma = turma;
        this.cpf = cpf;
    }
}