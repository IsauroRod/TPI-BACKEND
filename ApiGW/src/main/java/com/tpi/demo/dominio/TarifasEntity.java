package com.tpi.demo.dominio;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
@Table(name = "TARIFAS", schema = "main", catalog = "")
public class TarifasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = true)
    private Integer id;
    @Basic
    @Column(name = "TIPO_TARIFA", nullable = true)
    private Integer tipoTarifa;
    @Basic
    @Column(name = "DEFINICION", nullable = true, length = 1)
    private Object definicion;
    @Basic
    @Column(name = "DIA_SEMANA", nullable = true)
    private Integer diaSemana;
    @Basic
    @Column(name = "DIA_MES", nullable = true)
    private Integer diaMes;
    @Basic
    @Column(name = "MES", nullable = true)
    private Integer mes;
    @Basic
    @Column(name = "ANIO", nullable = true)
    private Integer anio;
    @Basic
    @Column(name = "MONTO_FIJO_ALQUILER", nullable = true, precision = 0)
    private Float montoFijoAlquiler;
    @Basic
    @Column(name = "MONTO_MINUTO_FRACCION", nullable = true, precision = 0)
    private Float montoMinutoFraccion;
    @Basic
    @Column(name = "MONTO_KM", nullable = true, precision = 0)
    private Float montoKm;
    @Basic
    @Column(name = "MONTO_HORA", nullable = true, precision = 0)
    private Float montoHora;
    @OneToMany(mappedBy = "tarifasByIdTarifa")
    private Collection<AlquileresEntity> alquileresById;
}
