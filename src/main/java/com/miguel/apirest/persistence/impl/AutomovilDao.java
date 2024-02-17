package com.miguel.apirest.persistence.impl;

import com.miguel.apirest.entity.Automovil;
import com.miguel.apirest.persistence.IAutomovilDao;
import com.miguel.apirest.repositorio.AutomovilRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
@Component
public class AutomovilDao implements IAutomovilDao {
    @Autowired
private AutomovilRepositorio ar;
    @Override
    public List<Automovil> findAll() {
        return (List<Automovil>)ar.findAll();
    }

    @Override
    public List<Automovil> findByPrecio(BigDecimal precio) {
        return ar.findAutomovilByPrecioBetween(precio.min(BigDecimal.valueOf(25000)),precio.max(BigDecimal.valueOf(25000)));
    }


    @Override
    public Optional<Automovil> findById(Long id) {
        return ar.findById(id);
    }

    @Override
    public void save(Automovil automovil) {
    ar.save(automovil);
    }

    @Override
    public void deleteById(Long id) {
ar.deleteById(id);
    }
}
