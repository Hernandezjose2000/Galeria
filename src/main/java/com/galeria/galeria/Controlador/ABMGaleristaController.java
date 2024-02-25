package com.galeria.galeria.Controlador;

import com.galeria.galeria.DTO.GaleristaNuevoDTO;
import com.galeria.galeria.DTO.NuevoUsernameGaleristaDTO;
import com.galeria.galeria.Modelo.Galerista;
import com.galeria.galeria.Servicio.IServicioABMGalerista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ABMGaleristaController {

    @Autowired
    private IServicioABMGalerista servicioAbmGalerista;

    @PostMapping("/crearGalerista")
    public Galerista crearGalerista(@RequestBody GaleristaNuevoDTO galeristaNuevoDTO){
        return servicioAbmGalerista.registrarGalerista(galeristaNuevoDTO);
    }

    @PostMapping("/cambiarUsernameGalerista")
    public boolean obtenerGalerista(@RequestBody NuevoUsernameGaleristaDTO datosNuevosGalerista){
        return servicioAbmGalerista.cambiarUsernameGalerista(datosNuevosGalerista);
    }

}
