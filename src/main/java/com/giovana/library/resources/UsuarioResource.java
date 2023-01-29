package com.giovana.library.resources;

import com.giovana.library.dto.UsuarioDTO;
import com.giovana.library.entity.Usuario;
import com.giovana.library.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        usuario = service.create(usuario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(usuario);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario usuario){
        Usuario newUsuario = service.update(id, usuario);

        return ResponseEntity.ok().body(newUsuario);
    }
}


