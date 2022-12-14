package com.dsimdev.api.test.services.impl;

import com.dsimdev.api.test.entities.Distribuidora;
import com.dsimdev.api.test.entities.Modulo;
import com.dsimdev.api.test.exceptions.AppException;
import com.dsimdev.api.test.exceptions.ResourceNotFoundException;
import com.dsimdev.api.test.repositories.DistribuidoraRepository;
import com.dsimdev.api.test.repositories.ModuloRepository;
import com.dsimdev.api.test.services.ModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModuloServiceImpl implements ModuloService {

    @Autowired
    private ModuloRepository moduloRepository;

    @Autowired
    private DistribuidoraRepository distribuidoraRepository;

    @Override
    public Modulo crearModulo(Long distribuidoraId, Modulo modulo) {

        Distribuidora distribuidora = distribuidoraRepository.findById(distribuidoraId).orElseThrow(() -> new ResourceNotFoundException("Distribuidora", "id", distribuidoraId));

        modulo.setDistribuidora(distribuidora);
        Modulo nuevoModulo = moduloRepository.save(modulo);
        return nuevoModulo;
    }

    @Override
    public List<Modulo> obtenerModuloPorDistribuidoraId(Long distribuidoraId) {
        List<Modulo> modulos = moduloRepository.findByDistribuidoraId(distribuidoraId);
        return modulos.stream().map(modulo -> modulo).collect(Collectors.toList());
    }

    @Override
    public Modulo obtenerModuloPorId(Long distribuidoraId, Long moduloId) {
        Modulo modulo = buscarModuloYDistribuidora(distribuidoraId, moduloId);
        return modulo;
    }

    @Override
    public Modulo actualizarModulo(Long distribuidoraId, Long moduloId, Modulo moduloRequest) {
        Modulo modulo = buscarModuloYDistribuidora(distribuidoraId, moduloId);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        modulo.setNombre(moduloRequest.getNombre());
        modulo.setEstado(moduloRequest.getEstado());
        modulo.setFechaFin(moduloRequest.getFechaFin());
        modulo.setFechaInicio(moduloRequest.getFechaInicio());
        modulo.setCreadoPor(modulo.getCreadoPor());
        modulo.setActualizadoPor(modulo.getActualizadoPor());
        modulo.setFechaActualizacion(dateFormat.format(date));

        Modulo moduloActualizado = moduloRepository.save(modulo);
        return moduloActualizado;
    }

    @Override
    public void eliminarModulo(Long moduloId) {
        Modulo modulo = moduloRepository.findById(moduloId).orElseThrow(() -> new ResourceNotFoundException("Modulo", "id", moduloId));
        moduloRepository.delete(modulo);
    }


    private Modulo buscarModuloYDistribuidora(Long distribuidoraId, Long moduloId) {
        Distribuidora distribuidora = distribuidoraRepository.findById(distribuidoraId).orElseThrow(() -> new ResourceNotFoundException("Distribuidora", "id", distribuidoraId));
        Modulo modulo = moduloRepository.findById(moduloId).orElseThrow(() -> new ResourceNotFoundException("Modulo", "id", moduloId));

        if (modulo.getDistribuidora().getId() != distribuidora.getId()) {
            throw new AppException(HttpStatus.BAD_REQUEST, "El módulo no pertenece a la distribuidora");
        }
        return modulo;
    }
}