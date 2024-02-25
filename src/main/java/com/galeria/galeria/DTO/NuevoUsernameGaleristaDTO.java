package com.galeria.galeria.DTO;

public class NuevoUsernameGaleristaDTO {


    private String usernameActual;

    private String usernameNuevo;

    public NuevoUsernameGaleristaDTO(String usernameActual, String usernameNuevo) {
        this.usernameActual = usernameActual;
        this.usernameNuevo = usernameNuevo;
    }

    public String getUsernameActual() {
        return usernameActual;
    }

    public void setUsernameActual(String usernameActual) {
        this.usernameActual = usernameActual;
    }

    public String getUsernameNuevo() {
        return usernameNuevo;
    }

    public void setUsernameNuevo(String usernameNuevo) {
        this.usernameNuevo = usernameNuevo;
    }
}
