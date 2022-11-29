package com.dsimdev.api.test.controllers;

import com.dsimdev.api.test.entities.Distribuidora;
import com.dsimdev.api.test.entities.DistribuidoraResponse;
import com.dsimdev.api.test.services.DistribuidoraService;
import com.dsimdev.api.test.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v2/axum/distribuidoras")
@CrossOrigin("*")
public class DistribuidoraController {

    @Autowired
    private DistribuidoraService distribuidoraService;

    @GetMapping
    public DistribuidoraResponse listarDistribuidoras(@RequestParam(value = "pageNo", defaultValue = Constants.NO_PAGE_DEFAULT, required = false) int pageNo,
                                                      @RequestParam(value = "pageSize", defaultValue = Constants.SIZE_PAGE_DEFAULT, required = false) int pageSize,
                                                      @RequestParam(value = "orderBy", defaultValue = Constants.ORDER_BY_DEFAULT, required = false) String orderBy,
                                                      @RequestParam(value = "sortBy", defaultValue = Constants.SORT_BY_DEFAULT, required = false) String sortBy) {
        return distribuidoraService.obtenerTodasLasDistribuidoras(pageNo, pageSize, orderBy, sortBy);
    }

    @GetMapping("/{codigoInterno}")
    public ResponseEntity<Distribuidora> obtenerDistribuidoByCodigoInterno(@PathVariable(name = "codigoInterno") long codigoInterno) {
        return ResponseEntity.ok(distribuidoraService.obtenerDistribuidoraByCodigoInterno(codigoInterno));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Distribuidora> guardarDistribuidora(@Valid @RequestBody Distribuidora distribuidora) {
        return new ResponseEntity<>(distribuidoraService.crearDistribuidora(distribuidora), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Distribuidora> actualizarDistribuidora(@Valid @RequestBody Distribuidora distribuidora, @PathVariable(name = "id") long id) {
        Distribuidora distribuidoraResponse = distribuidoraService.actualizarDistribuidora(distribuidora, id);
        return new ResponseEntity<>(distribuidoraResponse, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarDistribuidora(@PathVariable(name = "id") long id) {
        distribuidoraService.eliminarDistribuidora(id);
        return new ResponseEntity<>("Distribuidora eliminada con exito", HttpStatus.OK);
    }
}