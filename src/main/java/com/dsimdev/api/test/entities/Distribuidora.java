package com.dsimdev.api.test.entities;

import javax.persistence.*;
import java.util.Date;
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
    private String base;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "erp")
    private String erp;

    @Column(name = "multinacional")
    private String multinacional;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_inicio")
    private String fechaInicio;

    @Column(name = "fecha_actualizacion")
    private String fechaActualizacion;

    @OneToMany(mappedBy = "distribuidora", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comentario> comentarios = new HashSet<>();

    @OneToMany(mappedBy = "distribuidora", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Contacto> contactos = new HashSet<>();

    @OneToMany(mappedBy = "distribuidora", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Modulo> modulos = new HashSet<>();

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
}