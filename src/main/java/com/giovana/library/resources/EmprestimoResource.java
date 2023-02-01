package com.giovana.library.resources;

import com.giovana.library.dto.EmprestimoDTO;
import com.giovana.library.entity.Emprestimo;
import com.giovana.library.services.EmprestimoService;
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

        emprestimoService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<List<EmprestimoDTO>> findAllByUser(@RequestParam(value = "usuario", defaultValue = "0") Integer id){
        List<Emprestimo> list = emprestimoService.findAllByUser(id);
        List<EmprestimoDTO> listDTO = list.stream().map( obj -> new EmprestimoDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);
        //localhost:8080/emprestimo?user=x
        // quero ver na lista de emprestimos, todos os emprestimos do usuário x
    }

}
