package com.giovana.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuário implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String matricula;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String turma;

    @Getter @Setter
    private String cpf;

    @Getter @Setter
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Usuário(Integer id, String matricula, String nome, String email, String turma, String cpf) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.turma = turma;
        this.cpf = cpf;
    }
}
