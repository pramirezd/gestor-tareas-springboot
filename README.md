# 📝 Gestor de Tareas - API REST con Spring Boot

Este proyecto es una aplicación de ejemplo desarrollada con Spring Boot, que permite gestionar tareas a través de una API REST. Esta versión incorpora integración con Swagger UI para documentación automática de los endpoints.

---

## 🚀 Instalación y Ejecución

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/pramirezd/gestor-tareas.git
   cd gestor-tareas
   ```

2. Configurar la base de datos PostgreSQL:
   Asegúrate de tener una instancia de PostgreSQL corriendo y crea una base de datos llamada `gestortareas`.

3. Modificar las credenciales en `src/main/resources/application.properties` si es necesario:
   ```
   spring.datasource.username=gestoruser
   spring.datasource.password=gestorpass
   ```

4. Ejecutar la aplicación:
   ```bash
   mvn spring-boot:run
   ```

---

## 🧪 Uso de la API

Puedes probar los endpoints directamente desde Swagger UI:

- [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

Los endpoints disponibles permiten crear, leer, actualizar y eliminar tareas (`CRUD`), además de aplicar filtros por estado y fechas.

---

## 📘 Documentación Swagger / OpenAPI

Esta aplicación incluye Swagger UI habilitado mediante la dependencia:

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.2.0</version>
</dependency>
```

Compatible con `Spring Boot 3.3.5`.

---

## 🔧 Tecnologías Utilizadas

- Java 21
- Spring Boot 3.3.5
- Maven
- PostgreSQL
- Swagger UI (Springdoc OpenAPI)
- HikariCP (pool de conexiones)
- Hibernate / Spring Data JPA

---

## 🗂️ Estructura del Proyecto

```
gestor-tareas
├── controller
│   └── TareaController.java
├── model
│   └── Tarea.java
├── repository
│   └── TareaRepository.java
├── service
│   └── TareaService.java
├── resources
│   └── application.properties
├── GestorTareasApplication.java
```

---

## 👤 Autor

**Pablo Ramírez**

---

## 🚧 Próximos Pasos

- ✅ Filtros de búsqueda por estado o fecha
- ✅ Integración con Swagger/OpenAPI
- 🔒 Seguridad con Spring Security (JWT o Basic Auth)
- 🖥️ Interfaz web con React
- 📝 Deploy en entorno público (Render, Railway, etc.)

---

## 🗒️ Notas

- Se detectó una incompatibilidad con `springdoc-openapi` en versiones 3.5.x de Spring Boot. Se hizo downgrade a la versión `3.3.5` para asegurar compatibilidad con `springdoc 2.2.0`.
