
# 📘 Gestor de Tareas - Spring Boot

Aplicación web desarrollada en Java con Spring Boot para gestionar tareas. Esta aplicación permite crear, listar, actualizar, eliminar y filtrar tareas mediante una API REST. Ahora incluye documentación automática de endpoints usando Swagger/OpenAPI.

## 🚀 Características

- 📦 CRUD completo de tareas
- 🔍 Filtros por estado y fechas (`completada`, `fechaAntes`, `fechaDespues`)
- 🗃️ Persistencia con PostgreSQL y JPA (Hibernate)
- 🧵 Pool de conexiones con HikariCP
- 🌐 API REST documentada con Swagger UI (`springdoc-openapi`)
- ⚙️ Compatible con Spring Boot 3.3.5 y Java 21

## ✅ Requisitos

- Java 21
- Maven 3.8+
- PostgreSQL

## 🔧 Configuración

Edita el archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/gestortareas
spring.datasource.username=gestoruser
spring.datasource.password=gestorpass
spring.jpa.open-in-view=false
```

## 🧪 Endpoints y Filtros

Puedes probar la API desde Swagger:

👉 `http://localhost:8080/swagger-ui.html`  
📄 `http://localhost:8080/v3/api-docs`

Filtros disponibles en `/api/tareas`:

```
GET /api/tareas?completada=true&fechaAntes=2025-07-01&fechaDespues=2025-06-01
```

## 📝 Documentación

Generada automáticamente con `springdoc-openapi`. Swagger UI permite explorar y probar los endpoints REST de forma interactiva.

## 🐞 Notas Técnicas

- Spring Boot downgraded a `3.3.5` para compatibilidad estable con `springdoc-openapi 2.2.0`.
- Se eliminó el uso explícito de `hibernate.dialect` (detectado automáticamente).
- Se desactivó `spring.jpa.open-in-view` por buenas prácticas REST.
