package com.example.spring.service;

import com.example.spring.model.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {

    // Recuperar empresa/s

    public List<Empresa> recuperarEmpresas();

    public Optional<Empresa> recuperarEmpresa(Long id);

    public Optional<Empresa> recuperarEmpresaPorNombre(String nombre);

    // Crear empresa

    public Empresa crearEmpresa(Empresa empresa);

    // Actualizar empresa

    public Empresa actualizarEmpresa(Empresa empresa);

    // Eliminar empresa/s

    public void eliminarEmpresa(Long id);

    public void eliminarTodasEmpresas();

    // Otros métodos

    public Float calcularFacturacion(Long id);
}
