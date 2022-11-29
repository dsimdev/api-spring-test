package com.dsimdev.api.test.repositories;

import com.dsimdev.api.test.entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    public List<Comentario> findByDistribuidoraId(Long distribuidoraId);

}