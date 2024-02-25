package com.galeria.galeria.Servicio;

import com.galeria.galeria.DTO.GaleristaEliminadoDTO;
import com.galeria.galeria.DTO.GaleristaNuevoDTO;
import com.galeria.galeria.DTO.NuevaPasswordGaleristaDTO;
import com.galeria.galeria.DTO.NuevoUsernameGaleristaDTO;
import com.galeria.galeria.Modelo.Galerista;

public interface IServicioABMGalerista {

    public Galerista registrarGalerista(GaleristaNuevoDTO galerista);

    public boolean cambiarUsernameGalerista(NuevoUsernameGaleristaDTO datosNuevosGalerista);

   public boolean cambiarPassword(NuevaPasswordGaleristaDTO datosGaleristta);

    public boolean eliminarGalerista(GaleristaEliminadoDTO galeristaEliminado);


}
