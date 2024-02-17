package com.miguel.apirest.repositorio;

import com.miguel.apirest.entity.Automovil;
import com.miguel.apirest.entity.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AutomovilRepositorio extends CrudRepository<Automovil,Long> {

List<Automovil>findAutomovilByPrecioBetween(BigDecimal min, BigDecimal max);



}

