package com.example.gateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebFluxSecurity
public class GWConfig {

    @Bean
    public RouteLocator configurarRutas(RouteLocatorBuilder builder) {
        return builder.routes()
                // Ruteo al Microservicio de Personas
                .route(p -> p.path("/alquileres").uri("http://localhost:8080")) //tengo la opcion de utilizar .filters(f -> rewritePath("/servicio-alumnos/", "/alumnos/") //todo esto se hace antes del .uri y permite reescribir la ruta
                                                                                                                //.setRequestHeader("pepe" , "123456contra") ) //request header me permite agregar un header, segun un valor puntual que me haga falta, para que el servicio que esta detras lo reconozca y manejar por ejemplo los roles enviando el header con el rol que necesito
                .build();

    }
}
