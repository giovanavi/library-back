package com.giovana.library.dto;

import com.giovana.library.entity.Emprestimo;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmprestimoDTO {

    private Integer id;
    private String dataEmprestimo;
    private String dataDevolucao;
    private String nomeUsuario;
    private String nomeLivro;

    public EmprestimoDTO(Emprestimo emp) {
        this.id = emp.getId();
        this.dataEmprestimo = emp.getDataEmprestimo();
        this.dataDevolucao = emp.getDataDevolucao();
        this.nomeUsuario = emp.getUsuario().getNome();
        this.nomeLivro = emp.getLivro().getNome();
    }
}
