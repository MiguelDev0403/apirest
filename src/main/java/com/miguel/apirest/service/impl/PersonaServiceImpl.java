package com.miguel.apirest.service.impl;

import com.miguel.apirest.entity.Persona;
import com.miguel.apirest.persistence.IAutomovilDao;
import com.miguel.apirest.persistence.IPersonaDao;
import com.miguel.apirest.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PersonaServiceImpl implements PersonaService {
   @Autowired

   private IPersonaDao iPersonaDao;
    @Override
    public List<Persona> findAll() {
        return iPersonaDao.findAll();
    }

    @Override
    public Optional<Persona> findById(Long id) {
        return iPersonaDao.findById(id);
    }

    @Override
    public Persona save(Persona persona) {
        return iPersonaDao.save(persona);
    }

    @Override
    public void deleteById(Long id) {
        iPersonaDao.deleteById(id);

    }
}
