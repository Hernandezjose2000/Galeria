package com.galeria.galeria.Servicio;
import com.galeria.galeria.Modelo.Galerista;
import com.galeria.galeria.Repositorio.AutenticarGalerista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class ServicioLogging implements IServicioLogging {

    @Autowired
    private AutenticarGalerista autenticarGalerista;

    @Override
    public Galerista autenticarGalerista(String username, String passwordRecibida) {

        Galerista galeristaSolicitado = autenticarGalerista.findGaleristaByUsername(username);
        return validarPasswords(passwordRecibida, galeristaSolicitado);
    }
    private Galerista validarPasswords(String passwordRecibida, Galerista galeristaSolicitado){

        String passwordRecibidaHasheada = aplicarHash(passwordRecibida);
        if(Objects.equals(passwordRecibidaHasheada, galeristaSolicitado.getPassword())){
            return galeristaSolicitado;
        }
        return null;
    }

    private String aplicarHash(String input) {
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
