package com.tpi.demo.repositories;

import com.tpi.demo.dominio.AlquileresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlquileresRepository extends JpaRepository<AlquileresEntity, Integer>
{
}
