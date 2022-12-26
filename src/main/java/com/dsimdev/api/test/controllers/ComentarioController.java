package com.dsimdev.api.test.controllers;

import com.dsimdev.api.test.entities.Comentario;
import com.dsimdev.api.test.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v2/axum/usuarios/{username}/distribuidoras")
@CrossOrigin("*")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping("/{distribuidoraId}/comentarios")
    public List<Comentario> listarComentariosPorPublicacionId(@PathVariable(value = "distribuidoraId") Long distribuidoraId) {
        return comentarioService.obtenerComentariosPorDistribuidoraId(distribuidoraId);
    }

    @GetMapping("/{distribuidoraId}/comentarios/{comentarioId}")
    public ResponseEntity<Comentario> obtenerComentarioPorId(@PathVariable(value = "distribuidoraId") Long distribuidoraId, @PathVariable(value = "comentarioId") Long comentarioId) {
        Comentario comentario = comentarioService.obtenerComentarioPorId(distribuidoraId, comentarioId);
        return new ResponseEntity<>(comentario, HttpStatus.OK);
    }

    @PostMapping("/{distribuidoraId}/comentarios")
    public ResponseEntity<Comentario> guardarComentario(@PathVariable(value = "ditribuidoraId") Long distribuidoraId, @Valid @RequestBody Comentario comentario) {
        return new ResponseEntity<>(comentarioService.crearComentario(distribuidoraId, comentario), HttpStatus.CREATED);
    }

    @PutMapping("/{distribuidoraId}/comentarios/{comentarioId}")
    public ResponseEntity<Comentario> actualizarComentario(@PathVariable(value = "distribuidoraId") Long distribuidoraId, @PathVariable(value = "comentarioId") Long comentarioId, @Valid @RequestBody Comentario comentario) {
        Comentario comentarioDtoActualizado = comentarioService.actualizarComentario(distribuidoraId, comentarioId, comentario);
        return new ResponseEntity<>(comentarioDtoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{distribuidoraId}/comentarios/{comentarioId}")
    @PreAuthorize("hasAnyRole('SYS', 'ADMIN')")
    public ResponseEntity<String> eliminarContacto(@PathVariable(name = "comentarioId") long id) {
        comentarioService.eliminarComentario(id);
        return new ResponseEntity<>("Comentario eliminada con exito", HttpStatus.OK);
    }

}