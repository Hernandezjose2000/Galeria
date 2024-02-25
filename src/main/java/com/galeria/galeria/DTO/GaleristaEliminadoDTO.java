package com.galeria.galeria.DTO;

public class GaleristaEliminadoDTO {

    private String username;

    public GaleristaEliminadoDTO(String username) {
        this.username = username;
    }

    public GaleristaEliminadoDTO(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
