package com.tpi.demo.service;

import com.tpi.demo.dominio.AlquileresEntity;
import com.tpi.demo.repositories.AlquileresRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AlquileresServiceImpl implements AlquileresService{
    private AlquileresRepository alRep;
    @Autowired
    public AlquileresServiceImpl(AlquileresRepository alRep){
        this.alRep = alRep;
    }


    @Override
    public List<AlquileresEntity> findAll() {
        return alRep.findAll();
    }


    @Override
    public Optional<AlquileresEntity> findById(Integer id) {
        return alRep.findById(id);
    }

    @Override

    public boolean delete(Integer id) {
            if (!alRep.existsById(id)) {
                return false;
            }
            alRep.deleteById(id);
            return true;}


    @Override
    public void add(AlquileresEntity entity) {
        alRep.save(entity);
    }
}
