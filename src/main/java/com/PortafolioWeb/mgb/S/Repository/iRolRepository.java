/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortafolioWeb.mgb.S.Repository;

import com.PortafolioWeb.mgb.S.Entity.Rol;
import com.PortafolioWeb.mgb.S.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
     Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
