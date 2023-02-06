package com.giovana.library.resources;

import com.giovana.library.dto.LivroDTO;
import com.giovana.library.entity.Livro;
import com.giovana.library.services.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/livro")
public class LivroResource {

    @Autowired
    private LivroService livroService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id){
        Livro livro = livroService.findById(id);
        return ResponseEntity.ok().body(livro);
    }
    @GetMapping(value = "/")
    public ResponseEntity<List<LivroDTO>> findAll(){
        List<Livro> list = livroService.findAll();

        List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).toList();

        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Livro> create(@Valid @RequestBody Livro livro){
        livro = livroService.create(livro);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();

        return ResponseEntity.created(uri).body(livro);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> update(@PathVariable Integer id, @Valid @RequestBody Livro livro){
        Livro newLivro = livroService.update(id, livro);

        return ResponseEntity.ok().body(newLivro);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
