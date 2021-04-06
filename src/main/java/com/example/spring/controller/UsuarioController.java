package com.example.spring.controller;

import com.example.spring.model.Usuario;
import com.example.spring.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
public class UsuarioController {

    private UsuarioService servicio;

    public UsuarioController(UsuarioService servicio) {
        this.servicio = servicio;
    }

    //------------------------------------------
    // Recuperar usuario/s
    //------------------------------------------

    @GetMapping("/usuarios")
    @ApiOperation("Recupera todos los usuarios.")
    public List<Usuario> recuperarUsuarios(){
        return servicio.recuperarUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    @ApiOperation("Recupera un usuario según el id pasado por parámetro.")
    public ResponseEntity<Usuario> recuperarUsuario(@PathVariable Long id){
        Optional<Usuario> usuario = servicio.recuperarUsuario(id);
        if(usuario.isPresent()){
            return ResponseEntity.ok().body(usuario.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/usuarios/nombre/{nombre}")
    @ApiOperation("Recupera un usuario según el nombre pasado por parámetro.")
    public ResponseEntity<Usuario> recuperarUsuarioPorNombre(@PathVariable String nombre){
        Optional<Usuario> usuario = servicio.recuperarUsuarioPorNombre(nombre);
        if(usuario.isPresent()){
            return ResponseEntity.ok().body(usuario.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/usuarios/casados")
    @ApiOperation("Recupera los usuarios que estén casados.")
    public List<Usuario> recuperarUsuariosCasados(){
        return servicio.recuperarUsuariosCasados();
    }


    //------------------------------------------
    // Crear usuario
    //------------------------------------------

    @PostMapping("/usuarios")
    @ApiOperation("Crea un nuevo usuario.")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) throws URISyntaxException{
        if(usuario.getId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Usuario usuarioCreado = servicio.crearUsuario(usuario);
        return ResponseEntity.created(new URI("/api/usuarios/" + usuarioCreado.getId())).body(usuarioCreado);
    }


    //------------------------------------------
    // Actualizar usuario
    //------------------------------------------

    @PutMapping("/usuarios")
    @ApiOperation("Actualiza un usuario.")
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario){
        if(usuario.getId() == null || !servicio.existeUsuario(usuario.getId())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Usuario usuarioActualizado = servicio.actualizarUsuario(usuario);
        return ResponseEntity.ok().body(usuarioActualizado);
    }


    //------------------------------------------
    // Eliminar usuario/s
    //------------------------------------------

    @DeleteMapping("/usuarios/{id}")
    @ApiOperation("Elimina un usuario según el id pasado por parámetro.")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id){
        if(!servicio.eliminarUsuario(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body("El usuario con id " + id + " ha sido eliminado.");
        }
    }

    @DeleteMapping("usuarios")
    @ApiOperation("Elimina todos los usuarios.")
    public ResponseEntity<String> eliminarTodosUsuarios(){
        servicio.eliminarTodosUsuarios();
        return ResponseEntity.ok().body("Todos los usuarios han sido eliminados.");
    }




}
