package com.dsimdev.api.test.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "modulos")
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modulo")
    private long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "fecha_fin")
    private String fechaFin;

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
}