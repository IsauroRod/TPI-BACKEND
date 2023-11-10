package com.tpi.demo.controllers;


import com.tpi.demo.dominio.EstacionesEntity;
import com.tpi.demo.service.EstacionesServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estaciones")
public class EstacionesController {


    private EstacionesServiceImpl esServ;

    public EstacionesController(EstacionesServiceImpl esServ) {

        this.esServ = esServ;
    }


    @GetMapping
    public ResponseEntity<List<EstacionesEntity>> getEstaciones() {
        return ResponseEntity.ok(esServ.findAll());
    }


    @PostMapping
    private ResponseEntity<Void> addEstaciones(@RequestBody EstacionesEntity estaciones){
        esServ.add(estaciones);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @GetMapping("/ubi")
    public ResponseEntity<EstacionesEntity> getEstacionMasCercana(
            @RequestParam("latitud") double latitudCliente,
            @RequestParam("longitud") double longitudCliente) {

        List<EstacionesEntity> estaciones = esServ.findAll();

        if (estaciones.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        EstacionesEntity estacionMasCercana = null;
        double distanciaMinima = Double.MAX_VALUE;

        for (EstacionesEntity estacion : estaciones) {
            double distancia = calcularDistancia(latitudCliente, longitudCliente, estacion.getLatitud(), estacion.getLongitud());

            if (distancia < distanciaMinima) {
                distanciaMinima = distancia;
                estacionMasCercana = estacion;
            }
        }

        return ResponseEntity.ok(estacionMasCercana);
    }

    private double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
        // Fórmula de distancia euclidiana
        double dx = lat2 - lat1;
        double dy = lon2 - lon1;
        return Math.sqrt(dx * dx + dy * dy);
    }


}
