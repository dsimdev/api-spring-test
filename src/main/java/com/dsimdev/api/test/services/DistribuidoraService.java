package com.dsimdev.api.test.services;

import com.dsimdev.api.test.entities.Distribuidora;
import com.dsimdev.api.test.entities.DistribuidoraResponse;

public interface DistribuidoraService {

    public Distribuidora crearDistribuidora(Distribuidora distribuidoraDTO);

    public DistribuidoraResponse obtenerTodasLasDistribuidoras(int pageNo, int pageSize, String orderBy, String sortBy);

    public Distribuidora obtenerDistribuidoraById(long id);

    public Distribuidora obtenerDistribuidoraByCodigoInterno(long codigoInterno);

    public Distribuidora actualizarDistribuidora(Distribuidora distribuidoraDTO, long id);

    public void eliminarDistribuidora(long id);
}