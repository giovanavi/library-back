package com.giovana.library.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @NonNull @Getter @Setter
    private String  nome;

    @NonNull @Getter @Setter
    private String autor;

    @NonNull @Getter @Setter
    private String editora;

    @NonNull @Getter @Setter
    private String genero;

//    @Getter @Setter private boolean status;

    @Getter @Setter
    private Emprestimo emprestimo;

}
