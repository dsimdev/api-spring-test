package com.dsimdev.api.test.services.impl;

import com.dsimdev.api.test.entities.Contacto;
import com.dsimdev.api.test.entities.Distribuidora;
import com.dsimdev.api.test.exceptions.AppException;
import com.dsimdev.api.test.exceptions.ResourceNotFoundException;
import com.dsimdev.api.test.repositories.ContactoRepository;
import com.dsimdev.api.test.repositories.DistribuidoraRepository;
import com.dsimdev.api.test.services.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactoServiceImpl implements ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    @Autowired
    private DistribuidoraRepository distribuidoraRepository;

    @Override
    public Contacto crearContacto(Long distribuidoraId, Contacto contacto) {

        Distribuidora distribuidora = distribuidoraRepository.findById(distribuidoraId).orElseThrow(() -> new ResourceNotFoundException("Distribuidora", "id", distribuidoraId));

        contacto.setDistribuidora(distribuidora);
        Contacto nuevoContacto = contactoRepository.save(contacto);

        return nuevoContacto;
    }

    @Override
    public List<Contacto> obtenerContactoPorDistribuidoraId(Long distribuidoraId) {
        List<Contacto> contactos = contactoRepository.findByDistribuidoraId(distribuidoraId);
        return contactos.stream().map(contacto -> contacto).collect(Collectors.toList());
    }

    @Override
    public Contacto obtenerContactoPorId(Long distribuidoraId, Long contactoId) {
        Contacto contacto = buscarContactoYDistribuidora(distribuidoraId, contactoId);
        return contacto;
    }

    @Override
    public Contacto actualizarContacto(Long distribuidoraId, Long contactoId, Contacto conctactoRequest) {
        Contacto contacto = buscarContactoYDistribuidora(distribuidoraId, contactoId);
        contacto.setNombre(conctactoRequest.getNombre());
        contacto.setTelefono(conctactoRequest.getTelefono());
        contacto.setEmail(conctactoRequest.getEmail());

        Contacto contactoActualizado = contactoRepository.save(contacto);
        return contactoActualizado;
    }


    private Contacto buscarContactoYDistribuidora(Long distribuidoraId, Long contactoId) {
        Distribuidora distribuidora = distribuidoraRepository.findById(distribuidoraId).orElseThrow(() -> new ResourceNotFoundException("Distribuidora", "id", distribuidoraId));
        Contacto contacto = contactoRepository.findById(contactoId).orElseThrow(() -> new ResourceNotFoundException("Contacto", "id", contactoId));

        if (contacto.getDistribuidora().getId() != distribuidora.getId()) {
            throw new AppException(HttpStatus.BAD_REQUEST, "El contacto no pertenece a la distribuidora");
        }
        return contacto;
    }
}