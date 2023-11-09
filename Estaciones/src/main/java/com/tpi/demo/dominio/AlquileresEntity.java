package com.tpi.demo.dominio;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ALQUILERES", schema = "main", catalog = "")
public class AlquileresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = true)
    private Integer id;
    @Basic
    @Column(name = "ID_CLIENTE", nullable = true, length = 50)
    private Object idCliente;
    @Basic
    @Column(name = "ESTADO", nullable = true)
    private Integer estado;
    @Basic
    @Column(name = "ESTACION_RETIRO", nullable = true, insertable=false, updatable=false)
    private Integer estacionRetiro;
    @Basic
    @Column(name = "ESTACION_DEVOLUCION", nullable = true, insertable=false, updatable=false)
    private Integer estacionDevolucion;
    @Basic
    @Column(name = "FECHA_HORA_RETIRO", nullable = true)
    private Object fechaHoraRetiro;
    @Basic
    @Column(name = "FECHA_HORA_DEVOLUCION", nullable = true)
    private Object fechaHoraDevolucion;
    @Basic
    @Column(name = "MONTO", nullable = true, precision = 0)
    private Float monto;
    @Basic
    @Column(name = "ID_TARIFA", nullable = true, insertable=false, updatable=false)
    private Integer idTarifa;
    @ManyToOne
    @JoinColumn(name = "ESTACION_RETIRO", referencedColumnName = "ID")
    private EstacionesEntity estacionesByEstacionRetiro;
    @ManyToOne
    @JoinColumn(name = "ESTACION_DEVOLUCION", referencedColumnName = "ID")
    private EstacionesEntity estacionesByEstacionDevolucion;
    @ManyToOne
    @JoinColumn(name = "ID_TARIFA", referencedColumnName = "ID")
    private TarifasEntity tarifasByIdTarifa;
}
