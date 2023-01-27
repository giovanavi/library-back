package com.giovana.library.services;

import com.giovana.library.entity.Usuario;
import com.giovana.library.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario findById(Integer id){
        Optional<Usuario> user = repository.findById(id);
        return user.orElse(null);
    }
}
