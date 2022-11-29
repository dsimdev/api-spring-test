package com.dsimdev.api.test.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Table(name = "contactos")
@Entity
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contacto")
    private long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    private String email;

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


}