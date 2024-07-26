# AgendaPro Project

Este proyecto es una API REST para gestionar productos utilizando Java Spring Boot, MySQL como base de datos y RabbitMQ para la mensajería.

## Tecnologías Usadas

- Java 21
- Spring Boot
- MySQL 8.0
- RabbitMQ 3.8
- Docker
- Docker Compose

## Prerrequisitos

Asegúrate de tener Docker y Docker Compose instalados en tu máquina.

## Cómo Ejecutar el Proyecto

Sigue los pasos a continuación para ejecutar el proyecto en contenedores Docker:

1. **Construir el Proyecto**

   Primero, construye el proyecto Java y genera el archivo JAR. Puedes hacer esto con Maven:

   ```sh
   mvn clean install
   mvn clean package

2. **Construir los servicios con docker compose**

   ```sh
   docker-compose up --build

## Pruebas 

Dentro del proyecto en el path: src/test/prueba/prueba.rest encuentra la documentacion de los endpoint y ejemplo de como ejecurtarlos
ademas de eso puede también con un complemente ejecutarlos en ese mismo archivo. En el mismo documento encuentra información para ejecucion con es 
claves, usuarios y url

## Información adicional:

Acceder a la Aplicación

La aplicación estará disponible en http://localhost:8080.

RabbitMQ Management estará disponible en http://localhost:15672 (Usuario: guest, Contraseña: guest).

## RabbitMQ
RabbitMQ se utiliza como sistema de mensajería para manejar la comunicación asincrónica en la aplicación. La configuración de RabbitMQ en Docker Compose es la siguiente:


- Imagen Docker: rabbitmq:3-management
- Puertos Expuestos: 5672 (para conexiones AMQP) y 15672 (para la interfaz de gestión web)
- Usuario: guest
- Contraseña: guest
