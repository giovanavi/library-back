package com.giovana.library.resources;

import com.giovana.library.dto.LivroDTO;
import com.giovana.library.entity.Livro;
import com.giovana.library.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livro")
public class LivroResource {

    @Autowired
    private LivroService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id){
        Livro livro = service.findById(id);
        return ResponseEntity.ok().body(livro);
    }
    @GetMapping(value = "/")
    public ResponseEntity<List<LivroDTO>> findAll(){
        List<Livro> list = service.findAll();

        List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).toList();

        return ResponseEntity.ok().body(listDTO);
    }
}
