package com.galeria.galeria.Controlador;

import com.galeria.galeria.DTO.LoggingGaleristaDTO;
import com.galeria.galeria.DTO.UsuarioRegistradoDTO;
import com.galeria.galeria.Modelo.Galerista;
import com.galeria.galeria.Servicio.IServicioRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistroController {

    @Autowired
    private IServicioRegistro servicioGalerista;

    @PostMapping("/crearGalerista/")
    public boolean crearGalerista(@RequestBody UsuarioRegistradoDTO usuarioNuevoDTO){
        Galerista nuevoGalerista = new Galerista(usuarioNuevoDTO.getNombre(), usuarioNuevoDTO.getApellido(), usuarioNuevoDTO.getEmail(), usuarioNuevoDTO.getUsername(), usuarioNuevoDTO.getPassword());
        servicioGalerista.guardarGalerista(nuevoGalerista);
        return true;
    }

    /*@GetMapping("/autenticarUsuario/{username}")
    public String autenticarUsuario(@PathVariable String username){  //dejo esta forma solo para poder intentar hackear el username
        return servicioGalerista.loguearGalerista(username).getApellido();
    }*/


}
