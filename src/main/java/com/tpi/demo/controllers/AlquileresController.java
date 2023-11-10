package com.tpi.demo.controllers;

import com.tpi.demo.dominio.AlquileresEntity;
import com.tpi.demo.dominio.EstacionesEntity;
import com.tpi.demo.service.AlquileresServiceImpl;
import com.tpi.demo.service.EstacionesServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/alquileres")
public class AlquileresController {

    private AlquileresServiceImpl alServ;

    public AlquileresController(AlquileresServiceImpl alServ) {

        this.alServ = alServ;
    }


    @GetMapping
    public ResponseEntity<List<AlquileresEntity>> getAlquileres() {
        return ResponseEntity.ok(alServ.findAll());
    }


    @PostMapping
    private ResponseEntity<Void> addAlquileres(@RequestBody AlquileresEntity alquileres){
        alServ.add(alquileres);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
