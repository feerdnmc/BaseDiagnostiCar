
package com.PortafolioWeb.mgb.Controller;

import com.PortafolioWeb.mgb.Dto.dtoMicrotrack;
import com.PortafolioWeb.mgb.Entity.Microtrack;
import com.PortafolioWeb.mgb.S.Controller.Mensaje;
import com.PortafolioWeb.mgb.Service.SMicrotrack;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Microtrack")
@RestController
@CrossOrigin(origins = {"https://basediagnostico.onrender.com", "https://localhost:4200"})

public class MicrotrackController {

    @Autowired
    SMicrotrack sMicrotrack;

    @GetMapping("/lista")
    public ResponseEntity<List<Microtrack>> list() {
        List<Microtrack> list = sMicrotrack.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sMicrotrack.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sMicrotrack.delete(id);
        return new ResponseEntity(new Mensaje("Microtrack eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoMicrotrack Dtomicrotrack) {
        if (StringUtils.isBlank(Dtomicrotrack.getSerialM())) {
            return new ResponseEntity(new Mensaje("El N° de Id es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (sMicrotrack.existsByNombreE(Dtomicrotrack.getSerialM())) {
            return new ResponseEntity(new Mensaje("El N° de Id ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(Dtomicrotrack.getSerialLL())) {
            return new ResponseEntity(new Mensaje("El N° de llave es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sMicrotrack.existsByNombreE(Dtomicrotrack.getSerialLL())) {
            return new ResponseEntity(new Mensaje("N° de llave ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(Dtomicrotrack.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sMicrotrack.existsByNombreE(Dtomicrotrack.getNombreE())) {
            return new ResponseEntity(new Mensaje("Esa nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        Microtrack microtrack = new Microtrack(Dtomicrotrack.getNombreE(),Dtomicrotrack.getSerialM(), Dtomicrotrack.getSerialLL());
        sMicrotrack.save(microtrack);

        return new ResponseEntity(new Mensaje("Microtrack creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoMicrotrack Dtomicrotrack) {
    Optional<Microtrack> microtrackOptional = (Optional<Microtrack>) sMicrotrack.findById(id);
    if (!microtrackOptional.isPresent()) {
        throw new IllegalArgumentException("El ID no existe");
    }
    Microtrack microtrack = microtrackOptional.get();

    if (sMicrotrack.existsByNombreE(Dtomicrotrack.getSerialM()) && sMicrotrack.getByNombreE(Dtomicrotrack.getSerialM()).get().getId() != id) {
        return new ResponseEntity(new Mensaje("Microtrack ya existe"), HttpStatus.BAD_REQUEST);
    }
    if (sMicrotrack.existsByNombreE(Dtomicrotrack.getSerialLL()) && sMicrotrack.getByNombreE(Dtomicrotrack.getSerialLL()).get().getId() != id) {
        return new ResponseEntity(new Mensaje("Llave magnetica ya existe"), HttpStatus.BAD_REQUEST);
    }
    if (StringUtils.isAnyBlank(Dtomicrotrack.getSerialM(), Dtomicrotrack.getSerialLL())) {
        return new ResponseEntity(new Mensaje("Los campos no pueden estar vacíos"), HttpStatus.BAD_REQUEST);
    }

    microtrack.setSerialM(Dtomicrotrack.getSerialM());
    microtrack.setSerialLL(Dtomicrotrack.getSerialLL());

    sMicrotrack.save(microtrack);
    return new ResponseEntity(new Mensaje("Microtrack actualizado"), HttpStatus.OK);
}


   /* @GetMapping("/detail/{id}")
    public ResponseEntity<Vehiculo> getById(@PathVariable("id") int id) {
        if (!sMicrotrack.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe existe el ID"), HttpStatus.NOT_FOUND);
        }
        Microtrack microtrack = sMicrotrack.getOne(id).get();
        return new ResponseEntity(microtrack, HttpStatus.OK);
    }*/
    
}
