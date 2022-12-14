package com.dsimdev.api.test.controllers;

import com.dsimdev.api.test.entities.Contacto;
import com.dsimdev.api.test.services.ContactoService;
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
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @GetMapping("/{distribuidoraId}/contactos")
    public List<Contacto> listarContactoPorDisitrbuidoraId(@PathVariable(value = "distribuidoraId") Long distribuidoraId) {
        return contactoService.obtenerContactoPorDistribuidoraId(distribuidoraId);
    }

    @GetMapping("/{distribuidoraId}/contactos/{contactoId}")
    public ResponseEntity<Contacto> obtenerContactoPorId(@PathVariable(value = "distribuidoraId") Long distribuidoraId, @PathVariable(value = "contactoId") Long contactoId) {
        Contacto contacto = contactoService.obtenerContactoPorId(distribuidoraId, contactoId);
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    }

    @PostMapping("/{distribuidoraId}/contactos")
    public ResponseEntity<Contacto> guardarContacto(@PathVariable(value = "ditribuidoraId") Long distribuidoraId, @Valid @RequestBody Contacto contacto) {
        return new ResponseEntity<>(contactoService.crearContacto(distribuidoraId, contacto), HttpStatus.CREATED);
    }

    @PutMapping("/{distribuidoraId}/contactos/{contactoId}")
    public ResponseEntity<Contacto> actualizarContacto(@PathVariable(value = "distribuidoraId") Long distribuidoraId, @PathVariable(value = "comentarioId") Long contactoId, @Valid @RequestBody Contacto contacto) {
        Contacto contactoActualizado = contactoService.actualizarContacto(distribuidoraId, contactoId, contacto);
        return new ResponseEntity<>(contactoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{distribuidoraId}/contactos/{contactoId}")
    @PreAuthorize("hasAnyRole('SYS', 'ADMIN')")
    public ResponseEntity<String> eliminarContacto(@PathVariable(name = "contactoId") long id) {
        contactoService.eliminarContacto(id);
        return new ResponseEntity<>("Contacto eliminada con exito", HttpStatus.OK);
    }

}