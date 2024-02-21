package com.galeria.galeria.Servicio;

import com.galeria.galeria.Modelo.Galerista;
import com.galeria.galeria.Repositorio.RegistroGalerista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioRegistro implements IServicioRegistro {


    @Autowired
    private RegistroGalerista registrarGalerista;


    @Override
    public void guardarGalerista(Galerista galerista) {
        registrarGalerista.save(galerista);
    }

}
