package com.giovana.library.repositories;

import com.giovana.library.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {

    @Query(value = "SELECT obj FROM Emprestimo obj WHERE obj.usuario.id = :id")
    List<Emprestimo> findAllByUser(@Param(value = "id") Integer id);
}

