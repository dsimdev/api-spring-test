package com.dsimdev.api.test.services;

import com.dsimdev.api.test.entities.Modulo;

import java.util.List;

public interface ModuloService {

    public Modulo crearModulo(Long distribuidoraId, Modulo modulo);

    public List<Modulo> obtenerModuloPorDistribuidoraId(Long distribuidoraId);

    public Modulo obtenerModuloPorId(Long distribuidoraId, Long moduloId);

    public Modulo actualizarModulo(Long distribuidoraId, Long moduloId, Modulo moduloRequest);


}