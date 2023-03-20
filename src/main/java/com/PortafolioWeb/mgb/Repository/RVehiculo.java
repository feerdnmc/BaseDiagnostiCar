/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PortafolioWeb.mgb.Repository;

import com.PortafolioWeb.mgb.Entity.Vehiculo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 @Repository

public interface RVehiculo extends JpaRepository<Vehiculo, Integer>{
    public Optional<Vehiculo> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
    
}
