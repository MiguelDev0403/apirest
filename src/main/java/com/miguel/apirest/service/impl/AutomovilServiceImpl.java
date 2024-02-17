package com.miguel.apirest.service.impl;

import com.miguel.apirest.entity.Automovil;
import com.miguel.apirest.persistence.IAutomovilDao;
import com.miguel.apirest.service.AutomovilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
@Service
public class AutomovilServiceImpl implements AutomovilService {
    @Autowired
     private IAutomovilDao iAutomovilDao;
    @Override
    public List<Automovil> findAll() {
        return iAutomovilDao.findAll();
    }

    @Override
    public List<Automovil> findByPrecio(BigDecimal precio) {
        return iAutomovilDao.findByPrecio(precio);
    }

    @Override
    public Optional<Automovil> findById(Long id) {
        return iAutomovilDao.findById(id);
    }

    @Override
    public void save(Automovil automovil) {
        iAutomovilDao.save(automovil);

    }

    @Override
    public void deleteById(Long id) {
        iAutomovilDao.deleteById(id);

    }
}
