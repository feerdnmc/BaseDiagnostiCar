/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortafolioWeb.mgb.Security.dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Feer Dinamarca
 */
public class dtoPersona {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String documento;
   @NotBlank
    private String img;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String documento, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.img = img;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
   
   
}
