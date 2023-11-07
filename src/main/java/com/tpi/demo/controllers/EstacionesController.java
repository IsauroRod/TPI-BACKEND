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
    @GetMapping("/buscar")
    public ResponseEntity<List<EstacionesEntity>> buscarEstacionesPorLongitudYLatitud(
            @RequestParam("latitud") Float latitud,
            @RequestParam("longitud") Float longitud) {
        List<EstacionesEntity> estaciones = esServ.findByLongitudAndLatitud(latitud, longitud);

        if (!estaciones.isEmpty()) {
            return ResponseEntity.ok(estaciones);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
