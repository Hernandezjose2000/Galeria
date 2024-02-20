package com.galeria.galeria.Modelo;

import jakarta.persistence.*;

@Entity
public class Galerista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGalerista;

    @OneToOne(mappedBy = "galeristaAsociado")
    private AutenticacionUsuario UsuarioAutenticado;

    private String nombre;

    private String apellido;

    private String email;

    public Integer getIdGalerista() {
        return idGalerista;
    }

    public void setIdGalerista(Integer idGalerista) {
        this.idGalerista = idGalerista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
