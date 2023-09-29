package com.giovana.library.repositories;

import com.giovana.library.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>  {
    public List<Livro> findByNomeContainingIgnoringCase(String str);
}
