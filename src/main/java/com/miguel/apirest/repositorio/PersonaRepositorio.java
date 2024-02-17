package com.miguel.apirest.repositorio;

import com.miguel.apirest.entity.Persona;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositorio extends CrudRepository<Persona,Long> {

}
