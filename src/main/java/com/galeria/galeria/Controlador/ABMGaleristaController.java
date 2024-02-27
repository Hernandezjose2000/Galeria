package com.galeria.galeria.Controlador;

import com.galeria.galeria.DTO.GaleristaEliminadoDTO;
import com.galeria.galeria.DTO.GaleristaNuevoDTO;
import com.galeria.galeria.DTO.NuevaPasswordGaleristaDTO;
import com.galeria.galeria.DTO.NuevoUsernameGaleristaDTO;
import com.galeria.galeria.Modelo.Galerista;
import com.galeria.galeria.Servicio.IServicioABMGalerista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ABMGaleristaController {

    @Autowired
    private IServicioABMGalerista servicioAbmGalerista;

    @PostMapping("/crearGalerista")
    @ResponseStatus(HttpStatus.CREATED)
    public Galerista crearGalerista(@RequestBody GaleristaNuevoDTO galeristaNuevoDTO){
        return servicioAbmGalerista.registrarGalerista(galeristaNuevoDTO);
    }

    @PutMapping("/cambiarUsernameGalerista")
    @ResponseStatus(HttpStatus.OK)
    public boolean cambiarUsernameGalerista(@RequestBody NuevoUsernameGaleristaDTO datosNuevosGalerista){
        return servicioAbmGalerista.cambiarUsernameGalerista(datosNuevosGalerista);

    }

    @PutMapping("/cambiarPasswordGalerista")
    @ResponseStatus(HttpStatus.OK)
    public boolean cambiarPasswordGalerista(@RequestBody NuevaPasswordGaleristaDTO datosGalerista){
        return servicioAbmGalerista.cambiarPassword(datosGalerista);
    }

    @DeleteMapping("/eliminarGalerista")
    @ResponseStatus(HttpStatus.OK)
    public boolean eliminarGalerista(@RequestBody GaleristaEliminadoDTO galeristaeEliminado){
        return servicioAbmGalerista.eliminarGalerista(galeristaeEliminado);
    }

}
