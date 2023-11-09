package com.tpi.demo.service;

import com.tpi.demo.dominio.EstacionesEntity;

import java.util.List;

public interface EstacionesService extends Service<EstacionesEntity,Integer>{
    List<EstacionesEntity> findByLongitudAndLatitud(Float latitud, Float longitud);
}
