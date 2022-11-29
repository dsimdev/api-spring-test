package com.dsimdev.api.test.repositories;

import com.dsimdev.api.test.entities.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuloRepository extends JpaRepository<Modulo, Long> {

    public List<Modulo> findByDistribuidoraId(Long distribuidoraId);

}