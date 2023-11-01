# Sistema de Alquiler de Bicicletas - Backend de Aplicaciones 2023

## Descripción
Este proyecto se enfoca en la implementación de un sistema de alquiler de bicicletas para una ciudad en particular. A continuación, se detallan los supuestos y funcionalidades que guían el desarrollo del backend de la aplicación.

## Supuestos

- **Clientes:** Solo los clientes registrados en el sistema pueden alquilar bicicletas.

- **Retiro y Devolución de Bicicletas:** Cada bicicleta se retira de una estación y se devuelve en otra.

- **Disponibilidad de Bicicletas:** Se asume que siempre hay una bicicleta disponible en cada estación y que cada estación tiene espacio para la devolución de bicicletas.

- **Cálculo de Costo de Alquiler:** El precio del alquiler se calcula al momento de la devolución y se basa en un costo fijo por realizar el alquiler y un costo por hora completa. Se considera una tabla en la base de datos que contiene estos costos para cada día de la semana. Además, se cobra un monto adicional por cada kilómetro que separa la estación de retiro de la estación de devolución. Se aplican descuentos en días promocionales configurados en el sistema.

- **Moneda de Pago:** Al momento de la devolución, el cliente puede elegir en qué moneda se le muestra el monto adeudado, siendo el Peso Argentino la moneda por defecto.

## Funcionalidades del Backend

El backend se compone de microservicios y expone un API REST con representación en JSON que brinda las siguientes funcionalidades:

1. **Consultar Estaciones:** Consultar el listado de todas las estaciones disponibles en la ciudad.

2. **Estación más Cercana:** Consultar los datos de la estación más cercana a una ubicación proporcionada por el cliente.

3. **Iniciar Alquiler:** Iniciar el alquiler de una bicicleta desde una estación específica.

4. **Finalizar Alquiler:** Finalizar un alquiler en curso, proporcionando los datos del mismo y el costo expresado en la moneda que el cliente elija.

5. **Agregar Estación:** Agregar una nueva estación al sistema.

6. **Consultar Alquileres:** Obtener un listado de los alquileres realizados, aplicando al menos un filtro.

## Consideraciones Importantes

- El backend debe presentar un único punto de entrada y debe implementar un API Gateway que exponga todos los endpoints en el mismo puerto.

- Todas las llamadas a los distintos endpoints solo deben ser permitidas para clientes autenticados, considerando dos roles: Administrador y Cliente.

   - Administrador:
      - Puede agregar nuevas estaciones.
      - Puede obtener listados de alquileres realizados.

   - Cliente:
      - Puede realizar consultas sobre las estaciones.
      - Puede realizar alquileres y devoluciones.

- Se requiere investigar el manejo de Fecha/Hora en Java, utilizando las clases del paquete java.time.

- Se debe utilizar códigos de respuesta HTTP de manera correcta.

- Todos los endpoints deben estar documentados utilizando Swagger.

- Para calcular la distancia entre dos estaciones, se utilizará la distancia euclidiana, considerando que cada grado corresponde a 110,000 metros.

## Base de Datos

La base de datos proporcionada para este proyecto consta de tres tablas:

1. **Estaciones:** Almacena información sobre las estaciones disponibles en el sistema, con columnas como ID, NOMBRE, FECHA_HORA_CREACION, LATITUD y LONGITUD.

2. **Tarifas:** Configura las tarifas utilizadas para calcular el monto del alquiler, con detalles como ID, TIPO_TARIFA, DEFINICIÓN, DIA_SEMANA, DIA_MES, MES, ANIO, MONTO_FIJO_ALQUILER, MONTO_MINUTO_FRACCION, MONTO_HORA y MONTO_KM.

3. **Alquileres:** Registra los alquileres realizados, con columnas que incluyen ID, ID_CLIENTE, ESTADO, ESTACION_RETIRO, ESTACION_DEVOLUCION, FECHA_HORA_RETIRO, FECHA_HORA_DEVOLUCION, MONTO y ID_TARIFA.

Este README proporciona una visión general del proyecto, los supuestos, las funcionalidades y la estructura de la base de datos. Para obtener información detallada sobre cómo implementar estas funcionalidades, consulte la documentación y el código fuente del proyecto.
