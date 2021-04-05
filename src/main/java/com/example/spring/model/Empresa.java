package com.example.spring.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Id de la empresa")
    private Long id;

    @Column(unique = true)
    @ApiModelProperty("nombre de la empresa")
    private String nombre;

    @ApiModelProperty("Número total de empleados en la empresa")
    private Integer numEmpleados;

    @ApiModelProperty("Número de productos de la empresa")
    private Integer numProductos;

    @ApiModelProperty("Precio del producto de la empresa")
    private Float precioProducto;    // expresado en euros

    @ApiModelProperty("Años que lleva la empresa en el mercado")
    private Integer tiempoMercado;   // expresado en años


    public Empresa() {
    }

    public Empresa(String nombre, Integer numEmpleados, Integer numProductos, Float precioProducto, Integer tiempoMercado) {
        this.nombre = nombre;
        this.numEmpleados = numEmpleados;
        this.numProductos = numProductos;
        this.precioProducto = precioProducto;
        this.tiempoMercado = tiempoMercado;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumEmpleados() {
        return numEmpleados;
    }

    public void setNumEmpleados(Integer numEmpleados) {
        this.numEmpleados = numEmpleados;
    }

    public Integer getNumProductos() {
        return numProductos;
    }

    public void setNumProductos(Integer numProductos) {
        this.numProductos = numProductos;
    }

    public Float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Integer getTiempoMercado() {
        return tiempoMercado;
    }

    public void setTiempoMercado(Integer tiempoMercado) {
        this.tiempoMercado = tiempoMercado;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", numEmpleados=" + numEmpleados +
                ", numProductos=" + numProductos +
                ", precioProducto=" + precioProducto +
                ", tiempoMercado=" + tiempoMercado +
                '}';
    }
}
