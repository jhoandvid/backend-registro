package com.hotel.registro.rest;
import com.hotel.registro.model.Persona;
import com.hotel.registro.repository.PersonaRepository;
import com.hotel.registro.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.StartElement;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/hotel/registro")
public class PersonaRest {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private PersonaRepository personaRepository;
//listar usuarios ->pendiente
    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> getPersona() {
        return ResponseEntity.ok().body(personaService.findAll());
    }
//agregar usuario
    @PostMapping ("/agregar")
   Persona create(@RequestBody Persona persona){
        return personaService.guardar(persona);
    }

    //modificar usuario
    @PutMapping("/modificar/{id_persona}")
    Persona update(@PathVariable("id_persona") Long id_persona, @RequestBody Persona persona){
        Persona personaedit=personaService.find(id_persona);
        if(personaedit==null){
            return  null;
        }
        personaedit.setPri_nombre(persona.getPri_nombre());
        personaedit.setSeg_nombre(persona.getSeg_nombre());
        personaedit.setPri_apellido(persona.getPri_apellido());
        personaedit.setSeg_apellido(persona.getSeg_apellido());
        personaedit.setDireccion(persona.getDireccion());
        personaedit.setCorreo(persona.getCorreo());
        personaedit.setUsername(persona.getUsername());
        personaedit.setRazon_social(persona.getRazon_social());
        personaedit.setTelefono(persona.getTelefono());
        personaedit.setIdentificacion(persona.getIdentificacion());
        personaedit.setGenero(persona.getGenero());

        personaedit.setCorreo(persona.getCorreo());
        return personaService.guardar(personaedit);

    }
//Elmininar usuario
    @DeleteMapping ("/eliminar/{id_persona}")
    void delete(@PathVariable Long id_persona) {
        Persona personaElimi = personaRepository.findById(id_persona).orElseThrow(RuntimeException::new);
        personaRepository.delete(personaElimi);
    }



}
