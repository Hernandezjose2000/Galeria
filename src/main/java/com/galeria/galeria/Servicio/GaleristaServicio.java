package com.galeria.galeria.Servicio;

import com.galeria.galeria.Modelo.Galerista;
import com.galeria.galeria.Repositorio.GaleristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GaleristaServicio implements IGaleristaService {


    @Autowired
    private GaleristaRepository repositorioGalerista;

    @Override
    public void guardarGalerista(Galerista galeristaNuevo) {
        repositorioGalerista.save(galeristaNuevo);
    }
}
