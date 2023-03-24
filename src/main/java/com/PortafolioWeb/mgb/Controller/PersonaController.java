package com.PortafolioWeb.mgb.Controller;

import org.apache.commons.lang3.StringUtils;
import com.PortafolioWeb.mgb.Entity.Persona;
import com.PortafolioWeb.mgb.S.Controller.Mensaje;
import com.PortafolioWeb.mgb.Service.IPersonaService;
import com.PortafolioWeb.mgb.Security.dto.dtoPersona;
import java.util.List;
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

@RestController
@RequestMapping("/Persona")
@CrossOrigin(origins = {"https://basediagnostico.onrender.com", "https://localhost:4200"})

public class PersonaController {

    @Autowired
    IPersonaService ipersonaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = ipersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!ipersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe la Persona"), HttpStatus.NOT_FOUND);
        }
        ipersonaService.delete(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona) {
        
        if (ipersonaService.existsByNombre(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (!StringUtils.isBlank(dtopersona.getNombre())) {
        } else {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopersona.getApellido())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (ipersonaService.existsByNombre(dtopersona.getApellido())) {
            return new ResponseEntity(new Mensaje("Esa nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopersona.getDocumento())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (ipersonaService.existsByNombre(dtopersona.getDocumento())) {
            return new ResponseEntity(new Mensaje("Esa nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopersona.getImg())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (ipersonaService.existsByNombre(dtopersona.getImg())) {
            return new ResponseEntity(new Mensaje("Esa nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = new Persona(dtopersona.getNombre(), dtopersona.getApellido(), dtopersona.getDocumento(), dtopersona.getImg());

        return new ResponseEntity(new Mensaje("Persona Creada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona) {
        if (!ipersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if (ipersonaService.existsByNombre(dtopersona.getNombre()) && ipersonaService.getByNombre(dtopersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (ipersonaService.existsByNombre(dtopersona.getApellido()) && ipersonaService.getByNombre(dtopersona.getApellido()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El apellido ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (ipersonaService.existsByNombre(dtopersona.getDocumento()) && ipersonaService.getByNombre(dtopersona.getDocumento()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El documento ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (ipersonaService.existsByNombre(dtopersona.getImg()) && ipersonaService.getByNombre(dtopersona.getImg()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El documento ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopersona.getNombre() + dtopersona.getApellido() + dtopersona.getDocumento() + dtopersona.getImg())) {
            return new ResponseEntity(new Mensaje("Los campos no pueden estar vacíos"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = ipersonaService.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDocumento((dtopersona.getDocumento()));
        persona.setImg(dtopersona.getImg());

        ipersonaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!ipersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe existe el ID"), HttpStatus.NOT_FOUND);
        }
        Persona persona = ipersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

}
