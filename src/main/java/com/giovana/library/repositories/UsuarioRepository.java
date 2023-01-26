package com.giovana.library.repositories;

import com.giovana.library.entity.Usuário;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuário, Integer> {
}
