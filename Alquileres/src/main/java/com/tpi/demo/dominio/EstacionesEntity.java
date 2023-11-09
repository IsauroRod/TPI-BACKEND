package com.tpi.demo.dominio;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;



@Data
@Entity
@Table(name = "ESTACIONES", schema = "main", catalog = "")
public class EstacionesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = true)
    private Integer id;
    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 100)
    private Object nombre;
    @Basic
    @Column(name = "FECHA_HORA_CREACION", nullable = true)
    private Object fechaHoraCreacion;
    @Basic
    @Column(name = "LATITUD", nullable = true, precision = 0)
    private Float latitud;
    @Basic
    @Column(name = "LONGITUD", nullable = true, precision = 0)
    private Float longitud;
    @OneToMany(mappedBy = "estacionesByEstacionRetiro")
    private Collection<AlquileresEntity> alquileresById;
    @OneToMany(mappedBy = "estacionesByEstacionDevolucion")
    private Collection<AlquileresEntity> alquileresById_0;
}
