package com.dsimdev.api.test.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "distribuidoras", uniqueConstraints = {@UniqueConstraint(columnNames = {"base"})})
public class Distribuidora {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_distribuidora")
    private long id;

    @Column(name = "codigo_interno", nullable = false)
    private long codigoInterno;

    @Column(name = "base", nullable = false)
    @NotEmpty
    private String base;

    @Column(name = "razon_social", nullable = false)
    @NotEmpty
    private String razonSocial;

    @Column(name = "erp", nullable = false)
    @NotEmpty
    private String erp;

    @Column(name = "multinacional", nullable = false)
    @NotEmpty
    private String multinacional;

    @Column(name = "estado", nullable = false)
    @NotEmpty
    private String estado;

    @Column(name = "fecha_inicio")
    private String fechaInicio;

    @Column(name = "creado_por")
    private String creadoPor;

    @Column(name = "fecha_actualizacion")
    private String fechaActualizacion;

    @Column(name = "actualizado_por")
    private String actualizadoPor;

    @Column(name = "vendedor")
    @NotEmpty
    private String vendedor;

    @OneToMany(mappedBy = "distribuidora", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comentario> comentarios = new HashSet<>();

    @OneToMany(mappedBy = "distribuidora", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Contacto> contactos = new HashSet<>();

    @OneToMany(mappedBy = "distribuidora", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Modulo> modulos = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

    public Distribuidora() {
    }

    public Distribuidora(long id, long codigoInterno, String base, String razonSocial, String erp, String multinacional, String estado, String fechaInicio) {
        this.id = id;
        this.codigoInterno = codigoInterno;
        this.base = base;
        this.razonSocial = razonSocial;
        this.erp = erp;
        this.multinacional = multinacional;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
    }

    public Distribuidora(long id, long codigoInterno, String base, String razonSocial, String erp, String multinacional, String estado, String fechaInicio, String fechaActualizacion) {
        this.id = id;
        this.codigoInterno = codigoInterno;
        this.base = base;
        this.razonSocial = razonSocial;
        this.erp = erp;
        this.multinacional = multinacional;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Distribuidora(long id, long codigoInterno, String base, String razonSocial, String erp, String multinacional, String estado, String fechaInicio, String fechaActualizacion, Set<Comentario> comentarios, Set<Contacto> contactos, Set<Modulo> modulos) {
        this.id = id;
        this.codigoInterno = codigoInterno;
        this.base = base;
        this.razonSocial = razonSocial;
        this.erp = erp;
        this.multinacional = multinacional;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaActualizacion = fechaActualizacion;
        this.comentarios = comentarios;
        this.contactos = contactos;
        this.modulos = modulos;
    }

    public Distribuidora(long id, long codigoInterno, String base, String razonSocial, String erp, String multinacional, String estado, String fechaInicio, String creadoPor, String fechaActualizacion, String actualizadoPor, Set<Comentario> comentarios, Set<Contacto> contactos, Set<Modulo> modulos, String vendedor) {
        this.id = id;
        this.codigoInterno = codigoInterno;
        this.base = base;
        this.razonSocial = razonSocial;
        this.erp = erp;
        this.multinacional = multinacional;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.creadoPor = creadoPor;
        this.fechaActualizacion = fechaActualizacion;
        this.actualizadoPor = actualizadoPor;
        this.comentarios = comentarios;
        this.contactos = contactos;
        this.modulos = modulos;
        this.vendedor = vendedor;
    }

    public Distribuidora(long id, long codigoInterno, String base, String razonSocial, String erp, String multinacional, String estado, String fechaInicio, String creadoPor, String fechaActualizacion, String actualizadoPor, String vendedor, Set<Comentario> comentarios, Set<Contacto> contactos, Set<Modulo> modulos, Usuario usuario) {
        this.id = id;
        this.codigoInterno = codigoInterno;
        this.base = base;
        this.razonSocial = razonSocial;
        this.erp = erp;
        this.multinacional = multinacional;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.creadoPor = creadoPor;
        this.fechaActualizacion = fechaActualizacion;
        this.actualizadoPor = actualizadoPor;
        this.vendedor = vendedor;
        this.comentarios = comentarios;
        this.contactos = contactos;
        this.modulos = modulos;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(long codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getErp() {
        return erp;
    }

    public void setErp(String erp) {
        this.erp = erp;
    }

    public String getMultinacional() {
        return multinacional;
    }

    public void setMultinacional(String multinacional) {
        this.multinacional = multinacional;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActulizacion) {
        this.fechaActualizacion = fechaActulizacion;
    }

    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        if (this.comentarios == null) {
            this.comentarios = comentarios;
        } else {
            this.comentarios.retainAll(comentarios);
            this.comentarios.addAll(comentarios);
        }
    }

    public Set<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(Set<Contacto> contactos) {
        if (this.contactos == null) {
            this.contactos = contactos;
        } else {
            this.contactos.retainAll(contactos);
            this.contactos.addAll(contactos);
        }
    }

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        if (this.modulos == null) {
            this.modulos = modulos;
        } else {
            this.modulos.retainAll(modulos);
            this.modulos.addAll(modulos);
        }
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public String getActualizadoPor() {
        return actualizadoPor;
    }

    public void setActualizadoPor(String actualizadoPor) {
        this.actualizadoPor = actualizadoPor;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}