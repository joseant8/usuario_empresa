package com.example.spring.controller;

import com.example.spring.model.Empresa;
import com.example.spring.service.EmpresaService;
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
public class EmpresaController {

    private EmpresaService servicio;

    public EmpresaController(EmpresaService servicio) {
        this.servicio = servicio;
    }

    //------------------------------------------
    // Recuperar empresa/s
    //------------------------------------------

    /**
     * Recupera todas las empresas
     * @return List<Empresa> lista de empresas
     */
    @GetMapping("/empresas")
    @ApiOperation("Recupera todas las empresas.")
    public List<Empresa> recuperarEmpresas(){
        return servicio.recuperarEmpresas();
    }


    /**
     * Recupera una empresa según el id
     * @param id
     * @return ResponseEntity<Empresa>
     */
    @GetMapping("/empresas/{id}")
    @ApiOperation("Recupera una empresa según el id pasado por parámetro.")
    public ResponseEntity<Empresa> recuperarEmpresa(@PathVariable Long id){
        Optional<Empresa> empresa = servicio.recuperarEmpresa(id);
        if(empresa.isPresent()){
            return ResponseEntity.ok().body(empresa.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Recupera una empresa según el nombre
     * @param nombre
     * @return ResponseEntity<Empresa>
     */
    @GetMapping("/empresas/nombre/{nombre}")
    @ApiOperation("Recupera una empresa según el nombre pasado por parámetro.")
    public ResponseEntity<Empresa> recuperarEmpresaPorNombre(@PathVariable String nombre){
        Optional<Empresa> empresa = servicio.recuperarEmpresaPorNombre(nombre);
        if(empresa.isPresent()){
            return ResponseEntity.ok().body(empresa.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    //------------------------------------------
    // Crear empresa
    //------------------------------------------

    /**
     * Crea una nueva empresa
     * @param empresa
     * @return ResponseEntity<Empresa>
     * @throws URISyntaxException
     */
    @PostMapping("/empresas")
    @ApiOperation("Crea una nueva empresa.")
    public ResponseEntity<Empresa> crearEmpresa(@RequestBody Empresa empresa) throws URISyntaxException {
        if(empresa.getId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Empresa empresaCreada = servicio.crearEmpresa(empresa);
        return ResponseEntity.created(new URI("/api/empresas/" + empresaCreada.getId())).body(empresaCreada);
    }


    //------------------------------------------
    // Actualizar empresa
    //------------------------------------------

    /**
     * Actualiza una empresa
     * @param empresa
     * @return ResponseEntity<Empresa>
     */
    @PutMapping("/empresas")
    @ApiOperation("Actualiza una empresa.")
    public ResponseEntity<Empresa> actualizarEmpresa(@RequestBody Empresa empresa) {
        if(empresa.getId() == null || !servicio.existeEmpresa(empresa.getId())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Empresa empresaActualizada = servicio.actualizarEmpresa(empresa);
        return ResponseEntity.ok().body(empresaActualizada);
    }


    //------------------------------------------
    // Eliminar empresa/s
    //------------------------------------------

    /**
     * Elimina una empresa según el id
     * @param id
     * @return
     */
    @DeleteMapping("/empresas/{id}")
    @ApiOperation("Elimina una empresa según el id pasado por parámetro.")
    public ResponseEntity<String> eliminarEmpresa(@PathVariable Long id){
        if(!servicio.eliminarEmpresa(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body("La empresa con id " + id + " ha sido eliminada.");
        }
    }


    /**
     * Elimina todas las empresas
     * @return ResponseEntity<String>
     */
    @DeleteMapping("/empresas")
    @ApiOperation("Elimina todas las empresas.")
    public ResponseEntity<String> eliminarTodasEmpresas() {
        servicio.eliminarTodasEmpresas();
        return ResponseEntity.ok().body("Todas las empresas han sido eliminadas.");
    }


    //------------------------------------------
    // Calular facturación de la empresa
    //------------------------------------------

    /**
     * Calcula la facturacón de una empresa
     * @param id
     * @return ResponseEntity<String>
     */
    @GetMapping("/empresas/facturacion/{id}")
    @ApiOperation("Calcula la facturacón de la empresa cuyo id se pasa por parámetro.")
    public ResponseEntity<String> calcularFacturacion(@PathVariable Long id){
        Float facturacion = servicio.calcularFacturacion(id);
        if(facturacion == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body("La facturación de la empresa con id " + id + " es de: " + facturacion + "€");
        }
    }
}
