package com.giovana.library.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter
    private Integer id;

    @Getter@Setter
    private String dataEmprestimo;

    @Getter@Setter
    private String dataDevolução;

    @Getter@Setter
    private Livro livro;

    @Getter@Setter
    private Usuário usuário;

}
