/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PortafolioWeb.mgb.Repository;

import com.PortafolioWeb.mgb.Entity.Microtrack;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RMicrotrack extends JpaRepository<Microtrack, Integer>{
    public Optional<Microtrack> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
    
}