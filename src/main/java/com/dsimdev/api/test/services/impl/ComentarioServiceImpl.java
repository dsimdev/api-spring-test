package com.dsimdev.api.test.services.impl;

import com.dsimdev.api.test.entities.Comentario;
import com.dsimdev.api.test.entities.Distribuidora;
import com.dsimdev.api.test.exceptions.AppException;
import com.dsimdev.api.test.exceptions.ResourceNotFoundException;
import com.dsimdev.api.test.repositories.ComentarioRepository;
import com.dsimdev.api.test.repositories.DistribuidoraRepository;
import com.dsimdev.api.test.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioServiceImpl implements ComentarioService {


    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private DistribuidoraRepository distribuidoraRepository;

    @Override
    public Comentario crearComentario(Long distribuidoraId, Comentario comentario) {
        Distribuidora distribuidora = distribuidoraRepository.findById(distribuidoraId).orElseThrow(() -> new ResourceNotFoundException("Distribuidora", "id", distribuidoraId));

        comentario.setDistribuidora(distribuidora);
        Comentario nuevoComentario = comentarioRepository.save(comentario);

        return nuevoComentario;
    }

    @Override
    public List<Comentario> obtenerComentariosPorDistribuidoraId(Long distribuidoraId) {
        List<Comentario> comentarios = comentarioRepository.findByDistribuidoraId(distribuidoraId);
        return comentarios.stream().collect(Collectors.toList());
    }

    @Override
    public Comentario obtenerComentarioPorId(Long distribuidoraId, Long comentarioId) {
        Comentario comentario = buscarComentarioYDistribuidora(distribuidoraId, comentarioId);
        return comentario;
    }

    @Override
    public Comentario actualizarComentario(Long distribuidoraId, Long comentarioId, Comentario comentarioRequest) {
        Comentario comentario = buscarComentarioYDistribuidora(distribuidoraId, comentarioId);
        comentario.setUsuario(comentarioRequest.getUsuario());
        comentario.setMensaje(comentarioRequest.getMensaje());

        Comentario comentarioActualizado = comentarioRepository.save(comentario);
        return comentarioActualizado;
    }

    private Comentario buscarComentarioYDistribuidora(Long distribuidoraId, Long comentarioId) {
        Distribuidora distribuidora = distribuidoraRepository.findById(distribuidoraId).orElseThrow(() -> new ResourceNotFoundException("Distribuidora", "id", distribuidoraId));
        Comentario comentario = comentarioRepository.findById(comentarioId).orElseThrow(() -> new ResourceNotFoundException("Comentario", "id", comentarioId));

        if (comentario.getDistribuidora().getId() != distribuidora.getId()) {
            throw new AppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece a la distribuidora");
        }
        return comentario;
    }
}