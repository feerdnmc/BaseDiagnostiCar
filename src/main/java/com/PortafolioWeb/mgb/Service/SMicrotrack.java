/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortafolioWeb.mgb.Service;

import com.PortafolioWeb.mgb.Entity.Microtrack;
import com.PortafolioWeb.mgb.Repository.RMicrotrack;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Feer Dinamarca
 */

@Service
@Transactional
public class SMicrotrack {
    @Autowired RMicrotrack rMicrotrack;
        public List<Microtrack> list(){
        return rMicrotrack.findAll();
    }
    public Optional<Microtrack> getOne(int id) {
        return rMicrotrack.findById(id);
    }

    public Optional<Microtrack> getByNombreE(String nombreE) {
        return rMicrotrack.findByNombreE(nombreE);
    }
    public void save(Microtrack microtrack){
        rMicrotrack.save(microtrack);
    }
    
    public void delete(int id){
        rMicrotrack.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rMicrotrack.existsById(id);
    }
    public boolean existsByNombreE(String nombreE){
        return rMicrotrack.existsByNombreE(nombreE);
    }

    public Object findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
