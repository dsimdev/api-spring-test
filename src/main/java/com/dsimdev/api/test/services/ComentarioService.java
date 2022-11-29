package com.dsimdev.api.test.services;

import com.dsimdev.api.test.entities.Comentario;

import java.util.List;

public interface ComentarioService {

    public Comentario crearComentario(Long distribuidoraId, Comentario comentario);

    public List<Comentario> obtenerComentariosPorDistribuidoraId(Long distribuidoraId);

    public Comentario obtenerComentarioPorId(Long distribuidoraId, Long comentarioId);

    public Comentario actualizarComentario(Long distribuidoraId, Long comentarioId, Comentario comentarioRequest);
}