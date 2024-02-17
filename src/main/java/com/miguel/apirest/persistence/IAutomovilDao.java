package com.miguel.apirest.persistence;

import com.miguel.apirest.entity.Automovil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IAutomovilDao {

    List<Automovil> findAll();

    List<Automovil>findByPrecio(BigDecimal precio);


    Optional<Automovil> findById(Long id);

    void save (Automovil automovil);

    void deleteById(Long id);
}

