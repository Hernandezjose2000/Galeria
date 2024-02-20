package com.galeria.galeria.Repositorio;

import com.galeria.galeria.Modelo.Galerista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GaleristaRepository extends JpaRepository<Galerista, Long> {
}
