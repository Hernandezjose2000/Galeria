package com.galeria.galeria.Servicio;

import com.galeria.galeria.DTO.GaleristaNuevoDTO;
import com.galeria.galeria.DTO.NuevoUsernameGaleristaDTO;
import com.galeria.galeria.Modelo.Galerista;
import com.galeria.galeria.Repositorio.ABMGalerista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioABMGalerista implements IServicioABMGalerista {


    @Autowired
    private ABMGalerista abmGalerista;


    @Override
    public Galerista registrarGalerista(GaleristaNuevoDTO usuarioNuevoDTO) {
        Galerista nuevoGalerista = new Galerista(usuarioNuevoDTO.getNombre(), usuarioNuevoDTO.getApellido(),
                                        usuarioNuevoDTO.getEmail(), usuarioNuevoDTO.getUsername(), usuarioNuevoDTO.getPassword());
        abmGalerista.save(nuevoGalerista);
        return nuevoGalerista;
    }

    @Override
    public boolean cambiarUsernameGalerista(NuevoUsernameGaleristaDTO datosNuevosGalerista) {
        Galerista galerista = abmGalerista.findGaleristaByUsername(datosNuevosGalerista.getUsernameActual());
        galerista.setUsername(datosNuevosGalerista.getUsernameNuevo());
        abmGalerista.save(galerista);
        return true;

    }


}
