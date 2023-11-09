package com.tpi.demo.service;

import com.tpi.demo.dominio.EstacionesEntity;
import com.tpi.demo.repositories.EstacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EstacionesServiceImpl implements EstacionesService{

    private EstacionesRepository esRep;
    @Autowired
    public EstacionesServiceImpl(EstacionesRepository esRep){
        this.esRep = esRep;
    }

    @Override
    public List<EstacionesEntity> findAll() {
       return esRep.findAll();
    }

    @Override
    public Optional<EstacionesEntity> findById(Integer id) {
        return esRep.findById(id);
    }

    @Override
    public boolean delete(Integer integer) {

        return false;
    }

    @Override
    public void add(EstacionesEntity entity) {
        esRep.save(entity);
    }

    public List<EstacionesEntity> findByLongitudAndLatitud(Float latitud, Float longitud) {
     return EstacionesRepository.findByLongitudAndLatitud(latitud, longitud);
  }
}
