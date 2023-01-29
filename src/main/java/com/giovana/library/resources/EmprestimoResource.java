package com.giovana.library.resources;

import com.giovana.library.dto.EmprestimoDTO;
import com.giovana.library.entity.Emprestimo;
import com.giovana.library.entity.Livro;
import com.giovana.library.services.EmprestimoService;
import com.giovana.library.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
        Livro livro = emp.getLivro();
        livro.setStatus("true");
        livroService.update(emp.getLivro().getId(), emp.getLivro());

        emp = emprestimoService.create(emp);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emp.getId()).toUri();

        return ResponseEntity.created(uri).body(emp);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Emprestimo> update(@PathVariable Integer id, @RequestBody Emprestimo emp){
        Emprestimo newEmprestimo = emprestimoService.update(id, emp);

        return ResponseEntity.ok().body(newEmprestimo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        Emprestimo emp = findById(id).getBody();
        Livro livro = emp.getLivro();
        livro.setStatus("false");
        livroService.update(emp.getLivro().getId(), emp.getLivro());

        emprestimoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
