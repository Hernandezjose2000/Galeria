package com.galeria.galeria.Controlador;

import com.galeria.galeria.Modelo.Galerista;
import com.galeria.galeria.Servicio.IGaleristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GaleristaController {

    @Autowired
    private IGaleristaService servicioGalerista;

    @PostMapping("/crear/")
    public String crearGalerista(@RequestBody Galerista nuevoGalerista){

        servicioGalerista.guardarGalerista(nuevoGalerista);
        return "CREADO CON EXITO";
    }
}
