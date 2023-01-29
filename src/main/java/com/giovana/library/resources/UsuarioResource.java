package com.giovana.library.resources;

import com.giovana.library.dto.UsuarioDTO;
import com.giovana.library.entity.Emprestimo;
import com.giovana.library.entity.Livro;
import com.giovana.library.entity.Usuario;
import com.giovana.library.services.EmprestimoService;
import com.giovana.library.services.LivroService;
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
    private UsuarioService usuarioService;

    @Autowired
    private EmprestimoService emprestimoService;

    @Autowired
    private LivroService livroService;



    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id){
        Usuario user = usuarioService.findById(id);
        return ResponseEntity.ok().body(user);
    }
    @GetMapping(value = "/")
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        List<Usuario> list = usuarioService.findAll();

        List<UsuarioDTO> listDTO = list.stream().map( obj -> new UsuarioDTO(obj)).toList();

        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        usuario = usuarioService.create(usuario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(usuario);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario usuario){
        //alterando informações do user nos emprestimos
        List<Emprestimo> emprestimos = usuario.getEmprestimos();
        for (Emprestimo e: emprestimos){
            e.setUsuario(usuario);
            emprestimoService.update(e.getId(), e);
        }

        Usuario newUsuario = usuarioService.update(id, usuario);

        return ResponseEntity.ok().body(newUsuario);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        Emprestimo emp = emprestimoService.findById(id);
        Livro livro = emp.getLivro();
        livro.setStatus("false");
        livroService.update(emp.getLivro().getId(), emp.getLivro());

        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}


