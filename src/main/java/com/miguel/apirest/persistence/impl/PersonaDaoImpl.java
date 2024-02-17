package com.miguel.apirest.persistence.impl;

import com.miguel.apirest.entity.Persona;
import com.miguel.apirest.persistence.IPersonaDao;
import com.miguel.apirest.repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonaDaoImpl implements IPersonaDao {
    @Autowired
    private PersonaRepositorio pr;

    @Override
    public List<Persona> findAll() {
        return (List<Persona>)pr.findAll();
    }

    @Override
    public Optional<Persona> findById(Long id) {
        return pr.findById(id);
    }

    @Override
    public Persona save(Persona persona) {

        return pr.save(persona);
    }

    @Override
    public void deleteById(Long id) {
        pr.deleteById(id);

    }
}