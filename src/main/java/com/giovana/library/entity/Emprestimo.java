package com.giovana.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotEmpty;

import java.io.Serializable;


@CrossOrigin("*")
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "emprestimo")
public class Emprestimo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "o campo DATA_EMPRESTIMO é obrigatório")
    @Length(min = 8, max = 10)
    private String dataEmprestimo;
    @NotEmpty(message = "o campo DATA_DEVOLUÇÃO é obrigatório")
    @Length(min = 8, max = 10)
    private String dataDevolucao;

    @JsonIgnoreProperties("emprestimos")
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @NotEmpty(message = "o campo USUARIO é obrigatório")
    private Usuario usuario;
    @JsonIgnoreProperties("emprestimo")
    @OneToOne
    @JoinColumn(name = "livro_id")
    @NotEmpty(message = "o campo LIVRO é obrigatório")
    private Livro livro;

    public Emprestimo(String dataEmprestimo, String dataDevolucao, Usuario usuario, Livro livro) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.usuario = usuario;
        this.livro = livro;
    }
}
