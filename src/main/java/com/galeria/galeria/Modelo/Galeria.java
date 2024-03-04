package com.galeria.galeria.Modelo;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(
        indexes = {@Index(name = "UnicidadNombreGaleria", columnList = "nombreGaleria", unique = true),
        @Index(name = "UnicidadRutaDeImagenes", columnList = "rutaDeImagenes", unique = true)}
)
public class Galeria {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGaleria;
    @ManyToOne
    @JoinColumn(name = "idGalerista", referencedColumnName = "idGalerista")
    private Galerista galeristaCreador;
    @Column(nullable = false)
    private String nombreGaleria;
    private Date fechaExposicion;
    private String descripcion;
    @Column(nullable = false)
    private String rutaDeImagenes;

}
