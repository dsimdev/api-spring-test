package com.dsimdev.api.test.controllers;

import com.dsimdev.api.test.entities.Modulo;
import com.dsimdev.api.test.services.ModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v2/axum/distribuidoras")
@CrossOrigin("*")
public class ModuloController {

    @Autowired
    private ModuloService moduloService;

    @GetMapping("/{distribuidoraId}/modulos")
    public List<Modulo> listarModuloPorDistribuidoraId(@PathVariable(value = "distribuidoraId") long distribuidoraId) {
        return moduloService.obtenerModuloPorDistribuidoraId(distribuidoraId);
    }

    @GetMapping("/{distribuidoraId}/modulos/{moduloId}")
    public ResponseEntity<Modulo> obtenerModuloPorId(@PathVariable(value = "distribuidoraId") long distribuidoraId, @PathVariable(value = "moduloId") long moduloId) {
        Modulo moduloDTO = moduloService.obtenerModuloPorId(distribuidoraId, moduloId);
        return new ResponseEntity<>(moduloDTO, HttpStatus.OK);
    }

    @PostMapping("/{distribuidoraId}/modulos")
    public ResponseEntity<Modulo> guardarModulo(@PathVariable(value = "disribuidoraId") long distribuidoraId, @Valid @RequestBody Modulo modulo) {
        return new ResponseEntity<>(moduloService.crearModulo(distribuidoraId, modulo), HttpStatus.CREATED);
    }

    @PutMapping("/distribuidoraId/modulos/{moduloId}")
    public ResponseEntity<Modulo> actualizarModulo(@PathVariable(value = "distribuidoraId") long distribuidoraId, @PathVariable(value = "moduloId") long moduloId, @Valid @RequestBody Modulo modulo) {
        Modulo moduloActualizado = moduloService.actualizarModulo(distribuidoraId, moduloId, modulo);
        return new ResponseEntity<>(moduloActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/distribuidoraId/modulos/{moduloId}")
    @PreAuthorize("hasAnyRole('SYS', 'ADMIN')")
    public ResponseEntity<String> eliminarDistribuidora(@PathVariable(name = "moduloId") long id) {
        moduloService.eliminarModulo(id);
        return new ResponseEntity<>("Modulo eliminada con exito", HttpStatus.OK);
    }
}