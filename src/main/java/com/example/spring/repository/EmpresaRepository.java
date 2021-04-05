package com.example.spring.repository;



import com.example.spring.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference

    Optional<Empresa> findByNombre(String nombre);


}
