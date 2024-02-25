package com.galeria.galeria.DTO;

public class NuevaPasswordGaleristaDTO {

    private String username;
    private String nuevaPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNuevaPassword() {
        return nuevaPassword;
    }

    public void setNuevaPassword(String nuevaPassword) {
        this.nuevaPassword = nuevaPassword;
    }

    public NuevaPasswordGaleristaDTO(String username, String nuevaPassword) {
        this.username = username;
        this.nuevaPassword = nuevaPassword;
    }
}
