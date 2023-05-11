package com.example.EjerciciosSpring78y9.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;


@Entity
@ApiModel
public class LaptopEntity {

    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave ficticia autoincremental tipo Long")
    private Long id;
    private String marca;
    private String modelo;
    private String ram;
    private String procesador;
    private String almacenamiento;
    // constructores

    public LaptopEntity() {
    }

    public LaptopEntity(Long id, String marca, String modelo, String ram, String procesador, String almacenamiento) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ram = ram;
        this.procesador = procesador;
        this.almacenamiento = almacenamiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }
}
