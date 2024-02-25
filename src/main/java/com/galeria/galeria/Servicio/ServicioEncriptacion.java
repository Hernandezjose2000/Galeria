package com.galeria.galeria.Servicio;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ServicioEncriptacion {

    public static String encriptar(String cadenaAEncriptar){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(cadenaAEncriptar.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
