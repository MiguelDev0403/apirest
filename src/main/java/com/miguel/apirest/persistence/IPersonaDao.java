package com.miguel.apirest.persistence;

import com.miguel.apirest.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaDao {
    List<Persona> findAll();

    Optional<Persona> findById(Long id);

    Persona save (Persona persona);

    void deleteById(Long id);
}

