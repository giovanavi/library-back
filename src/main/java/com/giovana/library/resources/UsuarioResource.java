package com.giovana.library.resources;

import com.giovana.library.dto.UsuarioDTO;
import com.giovana.library.entity.Usuario;
import com.giovana.library.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id){
        Usuario user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }
    @GetMapping(value = "/")
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        List<Usuario> list = service.findAll();

        List<UsuarioDTO> listDTO = list.stream().map( obj -> new UsuarioDTO(obj)).toList();

        return ResponseEntity.ok().body(listDTO);
    }
}


