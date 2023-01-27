package com.giovana.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emprestimo")
public class Emprestimo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter
    private Integer id;

    @Getter@Setter
    private String dataEmprestimo;

    @Getter@Setter
    private String dataDevolução;

    @JsonIgnoreProperties("emprestimos")
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @Getter@Setter
    private Usuario usuario;

    @JsonIgnoreProperties("emprestimo")
    @Getter@Setter
    @OneToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

}
