package com.galeria.galeria.Servicio;

import com.galeria.galeria.DTO.GaleristaNuevoDTO;
import com.galeria.galeria.DTO.NuevoUsernameGaleristaDTO;
import com.galeria.galeria.Modelo.Galerista;

public interface IServicioABMGalerista {

    public Galerista registrarGalerista(GaleristaNuevoDTO galerista);

    public boolean cambiarUsernameGalerista(NuevoUsernameGaleristaDTO datosNuevosGalerista);

    //public boolean cambiarUsername(NuevoUsernameGaleristaDTO nuevosDatosGalerista);

   // public boolean cambiarPassword(String passwordActual, String passwordNueva);

    //public boolean eliminarGalerista(String username);


}
