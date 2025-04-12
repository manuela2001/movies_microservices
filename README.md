# 🎬 Microservicio CRUD de Películas - Spring Boot + Docker

## 📌 Descripción del Proyecto

Este proyecto consiste en el desarrollo de un microservicio utilizando **Spring Boot**, que implementa un CRUD completo sobre una entidad de películas. La aplicación permite registrar, consultar, actualizar y eliminar películas, y está diseñada con una arquitectura en capas para facilitar el mantenimiento y escalabilidad.

Incluye:

- CRUD de películas.
- Arquitectura en capas (Controladores, Servicios, DAO).
- Persistencia con MariaDB usando Spring Data JPA.
- Pruebas unitarias e integración.
- Contenerización con Docker y orquestación con Docker Compose.
- Documentación y pruebas en Postman.
- Publicación de la imagen del microservicio en Docker Hub.

---

## 🎯 Objetivo

Crear un microservicio funcional y contenerizado que permita gestionar películas mediante operaciones básicas (crear, leer, actualizar, eliminar), probado y documentado correctamente.

---

## ⚙️ Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MariaDB
- Maven
- Docker + Docker Compose
- JUnit + Mockito
- JaCoCo
- Postman

---

## 🏗️ Arquitectura del Proyecto
📁 src
 ┣ 📁 main
 ┃ ┣ 📁 java
 ┃ ┃ ┗ 📁 com.example.peliculas
 ┃ ┃    ┣ 📁 controller        → Maneja las peticiones HTTP (endpoints REST).
 ┃ ┃    ┣ 📁 service           → Contiene la lógica de negocio relacionada con películas.
 ┃ ┃    ┣ 📁 repository        → Interacción con la base de datos utilizando Spring Data JPA.
 ┃ ┃    ┗ 📁 model             → Define la entidad `Pelicula`.
 ┃ ┗ 📁 resources
 ┃    ┣ application.properties → Configuración de la conexión con la base de datos MariaDB.
 ┃    ┗ data.sql               → (Opcional) Datos de prueba para inicializar la base de datos.
 ┣ 📁 test
 ┃ ┗ 📁 java
 ┃    ┗ 📁 com.example.peliculas
 ┃       ┣ 📁 unit             → Pruebas unitarias con JUnit y Mockito.
 ┃       ┗ 📁 integration      → Pruebas de integración para verificar el flujo completo.
📄 Dockerfile                   → Construcción de la imagen del microservicio.
📄 docker-compose.yml           → Orquestación del microservicio y la base de datos.
📄 .dockerignore                → Exclusión de archivos innecesarios para la imagen.
📄 README.md                    → Documentación del proyecto.


