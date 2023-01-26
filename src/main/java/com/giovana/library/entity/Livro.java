package com.giovana.library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;
    
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

    @Getter @Setter
    private boolean status;

//    @OneToOne(mappedBy = "livro", cascade = CascadeType.REMOVE, targetEntity = Emprestimo.class)
//    @Getter @Setter
//    private Emprestimo emprestimo;

}
