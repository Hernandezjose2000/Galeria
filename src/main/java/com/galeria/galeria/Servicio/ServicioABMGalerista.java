package com.galeria.galeria.Servicio;

import com.galeria.galeria.DTO.GaleristaEliminadoDTO;
import com.galeria.galeria.DTO.GaleristaNuevoDTO;
import com.galeria.galeria.DTO.NuevaPasswordGaleristaDTO;
import com.galeria.galeria.DTO.NuevoUsernameGaleristaDTO;
import com.galeria.galeria.Modelo.Galerista;
import com.galeria.galeria.Repositorio.ABMGalerista;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@Transactional //ver para que se usa esta notacion
public class ServicioABMGalerista implements IServicioABMGalerista {

    @Autowired
    private ABMGalerista abmGalerista;

    @Override
    public Galerista registrarGalerista(GaleristaNuevoDTO galeristaNuevo) {
        String passwordEncriptada = ServicioEncriptacion.encriptar(galeristaNuevo.getPassword());
        Galerista nuevoGalerista = new Galerista(galeristaNuevo.getNombre(), galeristaNuevo.getApellido(),
                galeristaNuevo.getEmail(), galeristaNuevo.getUsername(), passwordEncriptada);
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

    @Override
    public boolean cambiarPassword(NuevaPasswordGaleristaDTO datosGalerista) {
        Galerista galerista = abmGalerista.findGaleristaByUsername(datosGalerista.getUsername());
        String passwordEncriptada = ServicioEncriptacion.encriptar(datosGalerista.getNuevaPassword());
        galerista.setPassword(passwordEncriptada);
        abmGalerista.save(galerista);
        return true;
    }

    @Override
    public boolean eliminarGalerista(GaleristaEliminadoDTO galeristaEliminado) {
        abmGalerista.deleteGaleristaByUsername(galeristaEliminado.getUsername());
        return true;
    }



}
