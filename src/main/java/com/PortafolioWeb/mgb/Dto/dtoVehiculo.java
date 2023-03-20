/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortafolioWeb.mgb.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Feer Dinamarca
 */
public class dtoVehiculo {
    @NotBlank
    private Long id;
    @NotBlank
    private String nombreE;
    @NotBlank
    private String numeroC;
    @NotBlank
    private String numeroP;
    @NotBlank
    private String ingreso;
    @NotBlank
    private String vidaU;
    @NotBlank
    private String finalizacion;

    public dtoVehiculo() {
    }

    public dtoVehiculo(Long id, String nombreE, String numeroC, String numeroP, String ingreso, String vidaU, String finalizacion) {
        this.id = id;
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
