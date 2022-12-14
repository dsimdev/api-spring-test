package com.dsimdev.api.test.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Table(name = "contactos")
@Entity
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contacto")
    private long id;

    @Column(name = "nombre", nullable = false)
    @NotNull
    private String nombre;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @NotNull
    private String email;

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

    public Contacto() {
    }

    public Contacto(long id, String nombre, String telefono, String email, Distribuidora distribuidora) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.distribuidora = distribuidora;
    }

    public Contacto(long id, String nombre, String telefono, String email, String fechaInicio, String creadoPor, String fechaActualizacion, String actualizadoPor, Distribuidora distribuidora) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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