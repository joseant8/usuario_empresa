package com.example.spring.service;

import com.example.spring.model.Usuario;
import com.example.spring.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }


    // Recuperar usuario/s

    @Override
    public List<Usuario> recuperarUsuarios() {
        return repository.findAll();
    }

    @Override
    public Optional<Usuario> recuperarUsuario(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Usuario> recuperarUsuarioPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public List<Usuario> recuperarUsuariosCasados() {
        return repository.findByCasadoTrue();
    }


    // Crear usuario

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        Usuario usuarioCreado = repository.save(usuario);
        return usuarioCreado;
    }


    // Actualizar usuario

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        Usuario usuarioActualizado = repository.save(usuario);
        return usuarioActualizado;
    }


    // Eliminar usuario/s

    @Override
    public boolean eliminarUsuario(Long id) {
        if(!repository.existsById(id)){
            return false;
        }else{
            repository.deleteById(id);
            return true;
        }
    }

    @Override
    public void eliminarTodosUsuarios() {
        repository.deleteAll();
    }


    // Otros métodos

    @Override
    public boolean existeUsuario(Long id) {
        return repository.existsById(id);
    }



}
