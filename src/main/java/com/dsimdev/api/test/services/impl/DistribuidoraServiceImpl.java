package com.dsimdev.api.test.services.impl;

import com.dsimdev.api.test.entities.Distribuidora;
import com.dsimdev.api.test.entities.DistribuidoraResponse;
import com.dsimdev.api.test.exceptions.ResourceNotFoundException;
import com.dsimdev.api.test.repositories.DistribuidoraRepository;
import com.dsimdev.api.test.services.DistribuidoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DistribuidoraServiceImpl implements DistribuidoraService {

    @Autowired
    public DistribuidoraRepository distribuidoraRepository;

    @Override
    public Distribuidora crearDistribuidora(Distribuidora distribuidora) {

        Distribuidora nuevaDistribuidora = distribuidoraRepository.save(distribuidora);
        Distribuidora distribuidoraResponse = nuevaDistribuidora;

        return distribuidoraResponse;
    }

    @Override
    public DistribuidoraResponse obtenerTodasLasDistribuidoras(int pageNo, int pageSize, String orderBy, String sortBy) {
        Sort sort = sortBy.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(orderBy).ascending() : Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Distribuidora> distribuidoras = distribuidoraRepository.findAll(pageable);

        List<Distribuidora> listaDistribuidoraes = distribuidoras.getContent();
        List<Distribuidora> contenido = listaDistribuidoraes.stream().map(distribuidora -> distribuidora).collect(Collectors.toList());

        DistribuidoraResponse distribuidoraRespuesta = new DistribuidoraResponse();
        distribuidoraRespuesta.setContenido(contenido);
        distribuidoraRespuesta.setPageNo(distribuidoras.getNumber());
        distribuidoraRespuesta.setPageSize(distribuidoras.getSize());
        distribuidoraRespuesta.setTotalElements(distribuidoras.getTotalElements());
        distribuidoraRespuesta.setTotalPages(distribuidoras.getTotalPages());
        distribuidoraRespuesta.setLast(distribuidoras.isLast());

        return distribuidoraRespuesta;
    }

    @Override
    public Distribuidora obtenerDistribuidoraById(long id) {
        Distribuidora distribuidora = distribuidoraRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Distribuidora", "id", id));
        return distribuidora;
    }

    @Override
    public Distribuidora obtenerDistribuidoraByCodigoInterno(long codigoInterno) {
        Distribuidora distribuidora = distribuidoraRepository.findDistribuidoraByCodigoInterno(codigoInterno);
        return distribuidora;
    }


    @Override
    public Distribuidora actualizarDistribuidora(Distribuidora distribuidoraDto, long id) {
        Distribuidora distribuidora = distribuidoraRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Distribuidora", "id", id));

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        distribuidora.setCodigoInterno(distribuidoraDto.getCodigoInterno());
        distribuidora.setBase(distribuidoraDto.getBase());
        distribuidora.setRazonSocial(distribuidoraDto.getRazonSocial());
        distribuidora.setErp(distribuidoraDto.getErp());
        distribuidora.setEstado(distribuidoraDto.getEstado());
        distribuidora.setFechaInicio(distribuidoraDto.getFechaInicio());
        distribuidora.setFechaActualizacion(dateFormat.format(date));
        distribuidora.setMultinacional(distribuidoraDto.getMultinacional());

        Distribuidora distribuidoraActualizada = distribuidoraRepository.save(distribuidora);
        return distribuidoraActualizada;
    }

    @Override
    public void eliminarDistribuidora(long id) {
        Distribuidora distribuidora = distribuidoraRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Distribuidora", "id", id));
        distribuidoraRepository.delete(distribuidora);
    }

}