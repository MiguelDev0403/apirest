package com.miguel.apirest.service;

import com.miguel.apirest.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    List<Persona> findAll();

    Optional<Persona> findById(Long id);

    Persona save (Persona persona);

    void deleteById(Long id);

}
