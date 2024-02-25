package com.galeria.galeria.Servicio;

import com.galeria.galeria.DTO.GaleristaNuevoDTO;
import com.galeria.galeria.DTO.NuevaPasswordGaleristaDTO;
import com.galeria.galeria.DTO.NuevoUsernameGaleristaDTO;
import com.galeria.galeria.Modelo.Galerista;
import com.galeria.galeria.Repositorio.ABMGalerista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    @Override
    public boolean cambiarPassword(NuevaPasswordGaleristaDTO datosGalerista) {
        Galerista galerista = abmGalerista.findGaleristaByUsername(datosGalerista.getUsername());
        String passwordEncriptada = applyHash(datosGalerista.getNuevaPassword());
        galerista.setPassword(passwordEncriptada);
        abmGalerista.save(galerista);
        return true;
    }


    private String applyHash(String input) {
        try {
            // Create MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // Apply hash function
            byte[] hashedBytes = md.digest(input.getBytes());

            // Convert byte array to hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle NoSuchAlgorithmException
            e.printStackTrace();
            return null;
        }
    }


}
