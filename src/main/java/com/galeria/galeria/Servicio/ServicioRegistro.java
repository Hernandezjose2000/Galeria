package com.galeria.galeria.Servicio;

import com.galeria.galeria.Modelo.Galerista;
import com.galeria.galeria.Repositorio.RegistroGalerista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class ServicioRegistro implements IServicioRegistro {


    @Autowired
    private RegistroGalerista registrarGalerista;


    @Override
    public void guardarGalerista(Galerista galerista) {
        registrarGalerista.save(galerista);
    }

    @Override
    public Galerista loguearGalerista(String username, String password) {

       Galerista galeristaLogueado = registrarGalerista.findGaleristaByUsername(username);
       String passwordProporcionada = applyHash(password);
       if(Objects.equals(passwordProporcionada, galeristaLogueado.getPassword())){
           return galeristaLogueado;
       }
       return null;
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
