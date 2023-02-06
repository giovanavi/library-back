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
public class Emprestimo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "campo obrigatório")
    @Length(min = 8, max = 10)
    private String dataEmprestimo;
    @NotEmpty(message = "campo obrigatório")
    @Length(min = 8, max = 10)
    private String dataDevolucao;

    @JsonIgnoreProperties("emprestimos")
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @NotEmpty(message = "campo obrigatório")
    private Usuario usuario;
    @JsonIgnoreProperties("emprestimo")
    @OneToOne
    @JoinColumn(name = "livro_id")
    @NotEmpty(message = "campo obrigatório")
    private Livro livro;

    public Emprestimo(String dataEmprestimo, String dataDevolucao, Usuario usuario, Livro livro) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.usuario = usuario;
        this.livro = livro;
    }
}
