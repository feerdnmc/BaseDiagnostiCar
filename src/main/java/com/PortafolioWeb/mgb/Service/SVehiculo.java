/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortafolioWeb.mgb.Service;

import com.PortafolioWeb.mgb.Entity.Vehiculo;
import com.PortafolioWeb.mgb.Repository.RVehiculo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SVehiculo {
        @Autowired RVehiculo rVehiculo;
        public List<Vehiculo> list(){
        return rVehiculo.findAll();
    }
    public Optional<Vehiculo> getOne(int id) {
        return rVehiculo.findById(id);
    }

    public Optional<Vehiculo> getByNombreE(String nombreE) {
        return rVehiculo.findByNombreE(nombreE);
    }
    public void save(Vehiculo vehiculo){
        rVehiculo.save(vehiculo);
    }
    
    public void delete(int id){
        rVehiculo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rVehiculo.existsById(id);
    }
    public boolean existsByNombreE(String nombreE){
        return rVehiculo.existsByNombreE(nombreE);
    }
}
