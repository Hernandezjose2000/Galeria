package com.galeria.galeria.Repositorio;

import com.galeria.galeria.Modelo.Galerista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroGalerista extends JpaRepository<Galerista, Integer> {


    public Galerista findGaleristaByUsername(String username);
}
