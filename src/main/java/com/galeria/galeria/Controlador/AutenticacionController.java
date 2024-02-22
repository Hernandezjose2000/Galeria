package com.galeria.galeria.Controlador;

import com.galeria.galeria.DTO.LoggingGaleristaDTO;
import com.galeria.galeria.Modelo.Galerista;
import com.galeria.galeria.Servicio.ServicioLogging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutenticacionController {

    @Autowired
    private ServicioLogging autenticarGalerista;

    @PostMapping("/autenticarGalerista")
    public Galerista autenticarGalerista(@RequestBody LoggingGaleristaDTO credencialesGalerista){

        Galerista galeristaLogueado = autenticarGalerista.autenticarGalerista(credencialesGalerista.getUsername(), credencialesGalerista.getPassword());
        return galeristaLogueado;

    }
}
