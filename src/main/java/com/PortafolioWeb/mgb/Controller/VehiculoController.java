/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PortafolioWeb.mgb.Controller;

import com.PortafolioWeb.mgb.Dto.dtoVehiculo;
import com.PortafolioWeb.mgb.Entity.Vehiculo;
import com.PortafolioWeb.mgb.S.Controller.Mensaje;
import com.PortafolioWeb.mgb.Service.SVehiculo;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Vehiculo")

public class VehiculoController {
    @Autowired SVehiculo sVehiculo;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Vehiculo>> list(){
        List<Vehiculo>list =sVehiculo.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!sVehiculo.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }  
        sVehiculo.delete(id);
        return new ResponseEntity(new Mensaje("Vehiculo eliminado"), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoVehiculo Dtovehiculo){
        if (StringUtils.isBlank(Dtovehiculo.getNombreE())) {
            return new ResponseEntity(new Mensaje("La marca es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (sVehiculo.existsByNombreE(Dtovehiculo.getNombreE())) {
            return new ResponseEntity(new Mensaje("Esa marca ya existe"), HttpStatus.BAD_REQUEST);
            
        }if (StringUtils.isBlank(Dtovehiculo.getNumeroC())) {
            return new ResponseEntity(new Mensaje("El N° de chasis es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sVehiculo.existsByNombreE(Dtovehiculo.getNumeroC())) {
            return new ResponseEntity(new Mensaje("Ese N° ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(Dtovehiculo.getNumeroP())) {
            return new ResponseEntity(new Mensaje("El N° de patente es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sVehiculo.existsByNombreE(Dtovehiculo.getNumeroP())) {
            return new ResponseEntity(new Mensaje("Esa patente ya existe"), HttpStatus.BAD_REQUEST);
            
        }if (StringUtils.isBlank(Dtovehiculo.getIngreso())) {
            return new ResponseEntity(new Mensaje("La fecha de ingreso es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (sVehiculo.existsByNombreE(Dtovehiculo.getIngreso())) {
            return new ResponseEntity(new Mensaje("Fecha de ingreso ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(Dtovehiculo.getVidaU())) {
            return new ResponseEntity(new Mensaje("Fecha de vida util es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (sVehiculo.existsByNombreE(Dtovehiculo.getVidaU())) {
            return new ResponseEntity(new Mensaje("Esa fecha ya existe"), HttpStatus.BAD_REQUEST);
            
        }if (StringUtils.isBlank(Dtovehiculo.getFinalizacion())) {
            return new ResponseEntity(new Mensaje("Fecha de finalizacion obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (sVehiculo.existsByNombreE(Dtovehiculo.getFinalizacion())) {
            return new ResponseEntity(new Mensaje("fecha de finalizacion ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Vehiculo vehiculo = new Vehiculo(Dtovehiculo.getNombreE(),Dtovehiculo.getNumeroC(),Dtovehiculo.getNumeroP(),
        Dtovehiculo.getIngreso(),Dtovehiculo.getVidaU(),Dtovehiculo.getFinalizacion());
        sVehiculo.save(vehiculo);

        return new ResponseEntity(new Mensaje("vehiculo creado"), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoVehiculo Dtovehiculo) {
        if (!sVehiculo.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if (sVehiculo.existsByNombreE(Dtovehiculo.getNombreE()) && sVehiculo.getByNombreE(Dtovehiculo.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("La marca ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (sVehiculo.existsByNombreE(Dtovehiculo.getNumeroC()) && sVehiculo.getByNombreE(Dtovehiculo.getNumeroC()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese N° ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (sVehiculo.existsByNombreE(Dtovehiculo.getNumeroP()) && sVehiculo.getByNombreE(Dtovehiculo.getNumeroP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese N° ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (sVehiculo.existsByNombreE(Dtovehiculo.getIngreso()) && sVehiculo.getByNombreE(Dtovehiculo.getIngreso()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Fecha de Ingreso ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (sVehiculo.existsByNombreE(Dtovehiculo.getVidaU()) && sVehiculo.getByNombreE(Dtovehiculo.getVidaU()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Fecha de vida util ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (sVehiculo.existsByNombreE(Dtovehiculo.getFinalizacion()) && sVehiculo.getByNombreE(Dtovehiculo.getFinalizacion()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Fecha de finalizacion ya existe"), HttpStatus.BAD_REQUEST);
        }
         if (StringUtils.isBlank(Dtovehiculo.getNombreE() + Dtovehiculo.getNumeroC() + Dtovehiculo.getNumeroP() + Dtovehiculo.getIngreso() + Dtovehiculo.getVidaU() + Dtovehiculo.getFinalizacion())) {
    return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
}

         Vehiculo vehiculo = sVehiculo.getOne(id).get();
         vehiculo.setNombreE(Dtovehiculo.getNombreE());
         vehiculo.setNumeroC(Dtovehiculo.getNumeroC());
         vehiculo.setNumeroP(Dtovehiculo.getNumeroP());
         vehiculo.setIngreso(Dtovehiculo.getIngreso());
         vehiculo.setVidaU(Dtovehiculo.getVidaU());
         vehiculo.setFinalizacion(Dtovehiculo.getFinalizacion());

         
         sVehiculo.save(vehiculo);
         return new ResponseEntity(new Mensaje("Vehiculo actualizado"), HttpStatus.OK);

    }
   
    /*@GetMapping("/detail/{id}")
    public ResponseEntity<Vehiculo> getById(@PathVariable("id") int id){
        if(!sVehiculo.existsById(id))
            return new ResponseEntity(new Mensaje("no existe existe el ID"), HttpStatus.NOT_FOUND);
        Vehiculo vehiculo = sVehiculo.getOne(id).get();
        return new ResponseEntity(vehiculo, HttpStatus.OK);
    }*/
}
