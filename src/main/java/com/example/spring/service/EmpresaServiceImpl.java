package com.example.spring.service;

import com.example.spring.model.Empresa;
import com.example.spring.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService{

    private final EmpresaRepository repository;
    private final Float SUELDO = 1600F;

    public EmpresaServiceImpl(EmpresaRepository repository) {
        this.repository = repository;
    }

    // Recuperar empresa/s

    @Override
    public List<Empresa> recuperarEmpresas() {
        return repository.findAll();
    }

    @Override
    public Optional<Empresa> recuperarEmpresa(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Empresa> recuperarEmpresaPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    // Crear empresa

    @Override
    public Empresa crearEmpresa(Empresa empresa) {
        Empresa empresaCreada = repository.save(empresa);
        return empresaCreada;
    }

    // Actualizar empresa

    @Override
    public Empresa actualizarEmpresa(Empresa empresa) {
        Empresa empresaActualizada = repository.save(empresa);
        return empresaActualizada;
    }

    // Eliminar empresa/s

    @Override
    public boolean eliminarEmpresa(Long id) {
        if(!repository.existsById(id)){
            return false;
        }else{
            repository.deleteById(id);
            return true;
        }
    }

    @Override
    public void eliminarTodasEmpresas() {
        repository.deleteAll();
    }

    // Otros métodos

    @Override
    public Float calcularFacturacion(Long id) {
        Optional<Empresa> empresa = repository.findById(id);
        if(empresa.isPresent()){
            Float sueldoTodosEmpleados = empresa.get().getNumEmpleados() * SUELDO;
            Float resultado = empresa.get().getNumProductos() * empresa.get().getPrecioProducto() * empresa.get().getTiempoMercado() - sueldoTodosEmpleados * empresa.get().getTiempoMercado();
            return resultado;
        }else{
            return null;
        }
    }

    @Override
    public boolean existeEmpresa(Long id) {
        return repository.existsById(id);
    }
}
