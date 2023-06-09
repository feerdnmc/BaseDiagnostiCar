package com.PortafolioWeb.mgb.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreE;
    private String numeroC;
    private String numeroP;
    private String ingreso;
    private String vidaU;
    private String finalizacion;

    public Vehiculo() {
    }

    public Vehiculo(String nombreE, String numeroC, String numeroP, String ingreso, String vidaU, String finalizacion) {
        this.nombreE = nombreE;
        this.numeroC = numeroC;
        this.numeroP = numeroP;
        this.ingreso = ingreso;
        this.vidaU = vidaU;
        this.finalizacion = finalizacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getNumeroC() {
        return numeroC;
    }

    public void setNumeroC(String numeroC) {
        this.numeroC = numeroC;
    }

    public String getNumeroP() {
        return numeroP;
    }

    public void setNumeroP(String numeroP) {
        this.numeroP = numeroP;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public String getVidaU() {
        return vidaU;
    }

    public void setVidaU(String vidaU) {
        this.vidaU = vidaU;
    }

    public String getFinalizacion() {
        return finalizacion;
    }

    public void setFinalizacion(String finalizacion) {
        this.finalizacion = finalizacion;
    }

}
