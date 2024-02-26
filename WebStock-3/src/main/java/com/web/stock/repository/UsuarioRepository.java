package com.web.stock.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.web.stock.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}

