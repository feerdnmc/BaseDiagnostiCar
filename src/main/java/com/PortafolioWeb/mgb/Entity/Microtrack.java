package com.PortafolioWeb.mgb.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Microtrack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String serialM;
    private String serialLL;

    public Microtrack() {
    }

    public Microtrack(String nombreE,String serialM, String serialLL) {
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
