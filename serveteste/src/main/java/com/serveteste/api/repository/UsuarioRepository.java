package com.serveteste.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.serveteste.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
