package com.giovana.library.resources;

import com.giovana.library.dto.EmprestimoDTO;
import com.giovana.library.entity.Emprestimo;
import com.giovana.library.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/emprestimo")
public class EmprestimoResource {

    @Autowired
    private EmprestimoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Emprestimo> findById(@PathVariable Integer id){
        Emprestimo emp = service.findById(id);
        return ResponseEntity.ok().body(emp);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<EmprestimoDTO>> findAll(){
        List<Emprestimo> list = service.findAll();

        List<EmprestimoDTO> listDTO = list.stream().map(obj -> new EmprestimoDTO(obj)).toList();

        return ResponseEntity.ok().body(listDTO);
    }
}
