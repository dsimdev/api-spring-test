package com.dsimdev.api.test.repositories;

import com.dsimdev.api.test.entities.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {

    public List<Contacto> findByDistribuidoraId(Long distribuidoraId);
}
