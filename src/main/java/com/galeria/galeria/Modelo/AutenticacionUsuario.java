package com.galeria.galeria.Modelo;

import jakarta.persistence.*;

@Entity
public class AutenticacionUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "idGalerista")
    private Galerista galeristaAsociado;

    private String username;

    private String password;
}
