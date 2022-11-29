package com.dsimdev.api.test.repositories;

import com.dsimdev.api.test.entities.Distribuidora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistribuidoraRepository extends JpaRepository<Distribuidora, Long> {

    public Distribuidora findDistribuidoraByCodigoInterno(Long codigoInterno);

}
