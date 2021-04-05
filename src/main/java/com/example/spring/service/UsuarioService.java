package com.example.spring.service;

import com.example.spring.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    // Recuperar usuario/s

    public List<Usuario> recuperarUsuarios();

    public Optional<Usuario> recuperarUsuario(Long id);

    public Optional<Usuario> recuperarUsuarioPorNombre(String nombre);

    public List<Usuario> recuperarUsuariosCasados();

    // Crear usuario

    public Usuario crearUsuario(Usuario usuario);

    // Actualizar usuario

    public Usuario actualizarUsuario(Usuario usuario);

    // Eliminar usuario/s

    public boolean eliminarUsuario(Long id);

    public void eliminarTodosUsuarios();

}
