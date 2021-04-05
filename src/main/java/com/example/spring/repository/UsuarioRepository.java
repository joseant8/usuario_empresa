package com.example.spring.repository;


import com.example.spring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference

    Optional<Usuario> findByNombre(String nombre);

    List<Usuario> findByCasadoTrue();


}
