package com.tpi.demo.repositories;

import com.tpi.demo.dominio.EstacionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstacionesRepository extends JpaRepository<EstacionesEntity, Integer> {
    @Query("SELECT e FROM ESTACIONES e WHERE e.LATITUD = :latitud AND e.LONGITUD= :longitud")
    static List<EstacionesEntity> findByLongitudAndLatitud(Float latitud, Float longitud) {
        return null;
    }
}
