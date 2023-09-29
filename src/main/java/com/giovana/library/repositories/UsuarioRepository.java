package com.giovana.library.repositories;

import com.giovana.library.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Optional<List<Usuario>> findByNomeContainingIgnoringCase(String str);
}
