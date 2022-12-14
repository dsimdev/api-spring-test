package com.dsimdev.api.test.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "modulos")
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modulo")
    private long id;

    @Column(name = "nombre", nullable = false)
    @NotNull
    private String nombre;

    @Column(name = "estado", nullable = false)
    @NotNull
    private String estado;

    @Column(name = "fecha_fin")
    private String fechaFin;

    @Column(name = "fecha_inicio")
    private String fechaInicio;

    @Column(name = "creado_por")
    private String creadoPor;

    @Column(name = "fecha_actualizacion")
    private String fechaActualizacion;

    @Column(name = "actualizado_por")
    private String actualizadoPor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distribuidora_id", nullable = false)
    @JsonIgnore
    private Distribuidora distribuidora;

    public Modulo() {
    }

    public Modulo(long id, String nombre, String estado, Distribuidora distribuidora) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.distribuidora = distribuidora;
    }

    public Modulo(long id, String nombre, String estado, String fechaFin, Distribuidora distribuidora) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaFin = fechaFin;
        this.distribuidora = distribuidora;

    }

    public Modulo(long id, String nombre, String estado, String fechaFin, String fechaInicio, String creadoPor, String fechaActualizacion, String actualizadoPor, Distribuidora distribuidora) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
        this.creadoPor = creadoPor;
        this.fechaActualizacion = fechaActualizacion;
        this.actualizadoPor = actualizadoPor;
        this.distribuidora = distribuidora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Distribuidora getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(Distribuidora distribuidora) {
        this.distribuidora = distribuidora;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getActualizadoPor() {
        return actualizadoPor;
    }

    public void setActualizadoPor(String actualizadoPor) {
        this.actualizadoPor = actualizadoPor;
    }
}