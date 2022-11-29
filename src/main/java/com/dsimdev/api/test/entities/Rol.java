package com.dsimdev.api.test.entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @Column(name = "id_rol")
    private long id;

    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    public Rol() {
    }

    public Rol(long id, String nombre, Set<UsuarioRol> usuarioRoles) {
        this.id = id;
        this.nombre = nombre;
        this.usuarioRoles = usuarioRoles;
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

    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        if (this.usuarioRoles == null) {
            this.usuarioRoles = usuarioRoles;
        } else {
            this.usuarioRoles.retainAll(usuarioRoles);
            this.usuarioRoles.addAll(usuarioRoles);
        }
    }
}
