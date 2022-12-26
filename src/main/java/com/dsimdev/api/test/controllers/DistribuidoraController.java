package com.dsimdev.api.test.controllers;

import com.dsimdev.api.test.entities.Distribuidora;
import com.dsimdev.api.test.services.DistribuidoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;


import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v2/axum/usuarios/{username}/distribuidoras")
@CrossOrigin("*")
public class DistribuidoraController {

    @Autowired
    private DistribuidoraService distribuidoraService;

    @GetMapping
    public List<Distribuidora> listarDistribuidoras() {
        return distribuidoraService.obtenerDistribuidoras();
    }

    @GetMapping("/{codigoInterno}")
    public ResponseEntity<Distribuidora> obtenerDistribuidoByCodigoInterno(@PathVariable(name = "codigoInterno") long codigoInterno) {
        return ResponseEntity.ok(distribuidoraService.obtenerDistribuidoraByCodigoInterno(codigoInterno));
    }

    @PostMapping
    public ResponseEntity<Distribuidora> guardarDistribuidora(@Valid @RequestBody Distribuidora distribuidora) {
        return new ResponseEntity<>(distribuidoraService.crearDistribuidora(distribuidora), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Distribuidora> actualizarDistribuidora(@Valid @RequestBody Distribuidora distribuidora, @PathVariable(name = "id") long id) {
        Distribuidora distribuidoraResponse = distribuidoraService.actualizarDistribuidora(distribuidora, id);
        return new ResponseEntity<>(distribuidoraResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SYS', 'ADMIN')")
    public ResponseEntity<String> eliminarDistribuidora(@PathVariable(name = "id") long id) {
        distribuidoraService.eliminarDistribuidora(id);
        return new ResponseEntity<>("Distribuidora eliminada con exito", HttpStatus.OK);
    }
}