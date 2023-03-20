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
public class dtoMicrotrack {
    @NotBlank
    private int id;
    @NotBlank
    private String nombreE;
    @NotBlank
    private String serialM;
    @NotBlank
    private String serialLL;

    public dtoMicrotrack() {
    }

    public dtoMicrotrack(int id,String nombreE, String serialM, String serialLL) {
        this.id = id;
        this.nombreE = nombreE;
        this.serialM = serialM;
        this.serialLL = serialLL;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialM() {
        return serialM;
    }

    public void setSerialM(String serialM) {
        this.serialM = serialM;
    }

    public String getSerialLL() {
        return serialLL;
    }

    public void setSerialLL(String serialLL) {
        this.serialLL = serialLL;
    }
    
    
}
