package com.dsimdev.api.test.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private String perfil;

    @Column(name = "fecha_inicio")
    private String fechaInicio;

    @Column(name = "creado_por")
    private String creadoPor;

    private boolean enabled = true;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
    @JsonIgnore
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "usuario")
    @JsonIgnore
    private Set<Distribuidora> distribuidoras = new HashSet<>();

    public Usuario() {
    }

    public Usuario(long id, String username, String password, String email, String perfil, boolean enabled, Set<UsuarioRol> usuarioRoles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.perfil = perfil;
        this.enabled = enabled;
        this.usuarioRoles = usuarioRoles;
    }

    public Usuario(long id, String username, String password, String email, String perfil, String fechaInicio, String creadoPor, boolean enabled, Set<UsuarioRol> usuarioRoles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.perfil = perfil;
        this.fechaInicio = fechaInicio;
        this.creadoPor = creadoPor;
        this.enabled = enabled;
        this.usuarioRoles = usuarioRoles;
    }

    public Usuario(long id, String username, String password, String email, String perfil, String fechaInicio, String creadoPor, boolean enabled, Set<UsuarioRol> usuarioRoles, Set<Distribuidora> distribuidoras) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.perfil = perfil;
        this.fechaInicio = fechaInicio;
        this.creadoPor = creadoPor;
        this.enabled = enabled;
        this.usuarioRoles = usuarioRoles;
        this.distribuidoras = distribuidoras;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> authorities = new HashSet<>();
        this.usuarioRoles.forEach(usuarioRol -> {
            authorities.add(new Authority(usuarioRol.getRol().getNombre()));
        });
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public Set<Distribuidora> getDistribuidoras() {
        return distribuidoras;
    }

    public void setDistribuidoras(Set<Distribuidora> distribuidoras) {
        this.distribuidoras = distribuidoras;
    }
}
