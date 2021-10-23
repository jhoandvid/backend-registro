package com.hotel.registro.service;

import com.hotel.registro.model.Persona;

import java.util.List;

public interface IPersonaService {
    public List<Persona> findAll();
    public Persona guardar(Persona persona);
    public Persona find(Long id);



}
