package com.example.spring.controller;

import com.example.spring.model.Empresa;
import com.example.spring.service.EmpresaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/empresas")
    @ApiOperation("Recupera todas las empresas.")
    public List<Empresa> recuperarEmpresas(){
        return servicio.recuperarEmpresas();
    }

    @GetMapping("/empresas/{id}")
    @ApiOperation("Recupera una empresa según el id pasado por parámetro.")
    public ResponseEntity<Empresa> recuperarEmpresa(@PathVariable Long id){
        Optional<Empresa> empresa = servicio.recuperarEmpresa(id);
        if(empresa.isPresent()){
            return ResponseEntity.ok().body(empresa.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

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




    //------------------------------------------
    // Actualizar empresa
    //------------------------------------------



    //------------------------------------------
    // Eliminar empresa/s
    //------------------------------------------


    //------------------------------------------
    // Calular facturación de la empresa
    //------------------------------------------

    @GetMapping("/empresas/facturacion/{id}")
    @ApiOperation("Calcula la facturacón de la empresa cuyo id se pasa por parámetro.")
    public ResponseEntity<String> calcularFacturacion(@PathVariable Long id){
        Float facturacion = servicio.calcularFacturacion(id);
        System.out.println(facturacion);
        if(facturacion == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body("La facturación de la empresa con id " + id + " es de: " + facturacion + "€");
        }
    }
}
