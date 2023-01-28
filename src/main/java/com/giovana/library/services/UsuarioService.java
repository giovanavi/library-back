package com.giovana.library.services;

import com.giovana.library.entity.Livro;
import com.giovana.library.entity.Usuario;
import com.giovana.library.repositories.UsuarioRepository;
import com.giovana.library.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario findById(Integer id){
        Optional<Usuario> user = repository.findById(id);
        return user.orElseThrow( () -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: "+id+" - Tipo: "+ Usuario.class.getName()));
    }

    public List<Usuario> findAll(){
        return repository.findAll();
    }
}
