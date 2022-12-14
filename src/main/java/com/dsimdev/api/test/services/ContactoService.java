package com.dsimdev.api.test.services;

import com.dsimdev.api.test.entities.Contacto;

import java.util.List;

public interface ContactoService {

    public Contacto crearContacto(Long distribuidoraId, Contacto contacto);

    public List<Contacto> obtenerContactoPorDistribuidoraId(Long distribuidoraId);

    public Contacto obtenerContactoPorId(Long distribuidoraId, Long contactoId);

    public Contacto actualizarContacto(Long distribuidoraId, Long contactoId, Contacto conctactoRequest);

    public void eliminarContacto(Long moduloId);
}