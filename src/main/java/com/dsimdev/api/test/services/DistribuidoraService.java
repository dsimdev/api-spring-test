package com.dsimdev.api.test.services;

import com.dsimdev.api.test.entities.Distribuidora;

import java.util.List;

public interface DistribuidoraService {

    public Distribuidora crearDistribuidora(Distribuidora distribuidora);

    public List<Distribuidora> obtenerDistribuidoras();
    public Distribuidora obtenerDistribuidoraById(long id);

    public Distribuidora obtenerDistribuidoraByCodigoInterno(long codigoInterno);

    public Distribuidora actualizarDistribuidora(Distribuidora distribuidora, long id);

    public void eliminarDistribuidora(long id);
}