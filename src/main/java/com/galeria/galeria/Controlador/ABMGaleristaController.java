package com.galeria.galeria.Controlador;

import com.galeria.galeria.DTO.GaleristaEliminadoDTO;
import com.galeria.galeria.DTO.GaleristaNuevoDTO;
import com.galeria.galeria.DTO.NuevaPasswordGaleristaDTO;
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
    public boolean cambiarUsernameGalerista(@RequestBody NuevoUsernameGaleristaDTO datosNuevosGalerista){
        return servicioAbmGalerista.cambiarUsernameGalerista(datosNuevosGalerista);
    }

    @PostMapping("/cambiarPasswordGalerista")
    public boolean cambiarPasswordGalerista(@RequestBody NuevaPasswordGaleristaDTO datosGalerista){
        return servicioAbmGalerista.cambiarPassword(datosGalerista);
    }

    @PostMapping("/eliminarGalerista")
    public boolean eliminarGalerista(@RequestBody GaleristaEliminadoDTO galeristaeEliminado){
        System.out.println("enviado");
        return servicioAbmGalerista.eliminarGalerista(galeristaeEliminado);
    }

}
