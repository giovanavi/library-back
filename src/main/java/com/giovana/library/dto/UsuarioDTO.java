package com.giovana.library.dto;


import com.giovana.library.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class UsuarioDTO implements Serializable {

    private Integer id;
    private String nome;
    private String email;
    private String cpf;

    private int quantEmprestimos;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.cpf = usuario.getCpf();
        this.quantEmprestimos = usuario.getEmprestimos().size();
    }
}
