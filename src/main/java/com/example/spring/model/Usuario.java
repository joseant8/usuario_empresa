package com.example.spring.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Id del usuario")
    private Long id;

    @ApiModelProperty("Nombre del usuario")
    private String nombre;

    @ApiModelProperty("Primer apellido del usuario")
    private String apellido1;

    @Column(unique = true)
    @ApiModelProperty("Email del usuario")
    private String email;

    @ApiModelProperty("Edad del usuario expresada en años")
    private Integer edad;

    @ApiModelProperty("Estado civil del usuario")
    private Boolean casado;


    public Usuario() {
    }

    public Usuario(String nombre, String apellido1, String email, Integer edad, Boolean casado) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.email = email;
        this.edad = edad;
        this.casado = casado;
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

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Boolean getCasado() {
        return casado;
    }

    public void setCasado(Boolean casado) {
        this.casado = casado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", email='" + email + '\'' +
                ", edad=" + edad +
                ", casado=" + casado +
                '}';
    }
}
