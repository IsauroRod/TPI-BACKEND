package com.tpi.demo.repositories;

import com.tpi.demo.dominio.EstacionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionesRepository extends JpaRepository<EstacionesEntity, Integer> {
}
