package com.dsimdev.api.test.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private long id;

    @NotNull
    private String usuario;
    @NotNull
    private String mensaje;

    @Column(name = "fecha_inicio")
    private String fechaInicio;

    @Column(name = "creado_por")
    private String creadoPor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distribuidora_id", nullable = false)
    @JsonIgnore
    private Distribuidora distribuidora;

    public Comentario() {
    }

    public Comentario(long id, String usuario, String mensaje, Distribuidora distribuidora) {
        this.id = id;
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.distribuidora = distribuidora;
    }

    public Comentario(long id, String usuario, String mensaje, String fechaInicio, String creadoPor, Distribuidora distribuidora) {
        this.id = id;
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.fechaInicio = fechaInicio;
        this.creadoPor = creadoPor;
        this.distribuidora = distribuidora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
}