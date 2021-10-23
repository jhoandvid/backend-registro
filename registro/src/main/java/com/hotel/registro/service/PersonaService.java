package com.hotel.registro.service;

import com.hotel.registro.model.Persona;
import com.hotel.registro.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public Persona guardar(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona find(Long id_persona) {
        return personaRepository.findById(id_persona).orElse(null);
    }


}
