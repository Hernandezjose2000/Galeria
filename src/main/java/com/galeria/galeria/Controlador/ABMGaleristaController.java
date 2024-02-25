package com.galeria.galeria.Controlador;

import com.galeria.galeria.DTO.GaleristaEliminadoDTO;
import com.galeria.galeria.DTO.GaleristaNuevoDTO;
import com.galeria.galeria.DTO.NuevaPasswordGaleristaDTO;
import com.galeria.galeria.DTO.NuevoUsernameGaleristaDTO;
import com.galeria.galeria.Modelo.Galerista;
import com.galeria.galeria.Servicio.IServicioABMGalerista;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Boolean> cambiarUsernameGalerista(@RequestBody NuevoUsernameGaleristaDTO datosNuevosGalerista){
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping("/cambiarPasswordGalerista")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> cambiarPasswordGalerista(@RequestBody NuevaPasswordGaleristaDTO datosGalerista){
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @DeleteMapping("/eliminarGalerista")
    public ResponseEntity<Boolean> eliminarGalerista(@RequestBody GaleristaEliminadoDTO galeristaeEliminado){
        System.out.println("enviado");
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
