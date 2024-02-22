package com.galeria.galeria.Servicio;

import com.galeria.galeria.Modelo.Galerista;

import java.util.List;

public interface IServicioRegistro {

    public void guardarGalerista(Galerista galerista);

    public Galerista loguearGalerista(String username, String Password);

}
