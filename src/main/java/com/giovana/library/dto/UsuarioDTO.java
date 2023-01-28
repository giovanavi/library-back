package com.giovana.library.dto;


import com.giovana.library.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioDTO {

    private Integer id;
    private String nome;
    private String email;

    private int quantEmprestimos;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.quantEmprestimos = usuario.getEmprestimos().size();
    }
}
