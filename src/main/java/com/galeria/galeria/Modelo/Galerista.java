package com.galeria.galeria.Modelo;

import jakarta.persistence.*;

@Entity
public class Galerista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGalerista;
    private String nombre;
    private String apellido;
    private String email;
    private String username;
    private String password;

    public Galerista(){

    }

    public Galerista(String nombre, String apellido, String email, String username, String password){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.username = username;
        this.password = password;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
