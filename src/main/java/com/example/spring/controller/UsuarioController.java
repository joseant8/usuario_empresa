package com.example.spring.controller;

import com.example.spring.model.Usuario;
import com.example.spring.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
public class UsuarioController {

    UsuarioService servicio;

    public UsuarioController(UsuarioService servicio) {
        this.servicio = servicio;
    }

    //------------------------------------------
    // Recuperar usuario/s
    //------------------------------------------

    @GetMapping("/usuarios")
    public List<Usuario> recuperarUsuarios(){
        return servicio.recuperarUsuarios();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> recuperarUsuario(@PathVariable Long id){
        Optional<Usuario> usuario = servicio.recuperarUsuario(id);
        if(usuario.isPresent()){
            return ResponseEntity.ok().body(usuario.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/usuario/{nombre}")
    public ResponseEntity<Usuario> recuperarUsuarioPorNombre(@PathVariable String nombre){
        Optional<Usuario> usuario = servicio.recuperarUsuarioPorNombre(nombre);
        if(usuario.isPresent()){
            return ResponseEntity.ok().body(usuario.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/usuarios/casados")
    public List<Usuario> recuperarUsuariosCasados(){
        return servicio.recuperarUsuariosCasados();
    }


    //------------------------------------------
    // Crear usuario
    //------------------------------------------






    //------------------------------------------
    // Actualizar usuario
    //------------------------------------------



    //------------------------------------------
    // Eliminar usuario/s
    //------------------------------------------




}
