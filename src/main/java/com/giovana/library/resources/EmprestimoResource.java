package com.giovana.library.resources;

import com.giovana.library.dto.EmprestimoDTO;
import com.giovana.library.entity.Emprestimo;
import com.giovana.library.entity.Livro;
import com.giovana.library.services.EmprestimoService;
import com.giovana.library.services.LivroService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/emprestimo")
public class EmprestimoResource {

    @Autowired
    private EmprestimoService emprestimoService;

    @Autowired
    private LivroService livroService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Emprestimo> findById(@PathVariable Integer id){
        Emprestimo emp = emprestimoService.findById(id);
        return ResponseEntity.ok().body(emp);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<EmprestimoDTO>> findAll(){
        List<Emprestimo> list = emprestimoService.findAll();

        List<EmprestimoDTO> listDTO = list.stream().map(obj -> new EmprestimoDTO(obj)).toList();

        return ResponseEntity.ok().body(listDTO);
    }
    @PostMapping
    public ResponseEntity<Emprestimo> create(@RequestBody Emprestimo emp){
        livroService.create(emp.getLivro());

        emp = emprestimoService.create(emp);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emp.getId()).toUri();

        return ResponseEntity.created(uri).body(emp);
    }
}
