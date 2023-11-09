package com.tpi.demo.repositories;

import com.tpi.demo.dominio.TarifasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarifasRepository extends JpaRepository<TarifasEntity, Integer> {
}
