# Gestor de Tareas - Spring Boot

Aplicación backend construida con Java 21 y Spring Boot 3.  
Permite gestionar tareas personales (CRUD completo) a través de una API REST.

---

## 🚀 Tecnologías usadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Spring Boot Starter Validation
- Maven

---

## 🧩 Funcionalidades

- Crear, leer, actualizar y eliminar tareas.
- Validaciones automáticas con mensajes personalizados:
    - Título obligatorio, máximo 100 caracteres.
    - Descripción obligatoria, máximo 250 caracteres.
    - Fecha de vencimiento debe ser futura.
- Manejo global de errores con respuestas formateadas en JSON.
- Conexión a base de datos real PostgreSQL.
- Estructura por capas (Controller, Service, Repository, Model, Exception).
- 🆕 Filtros de búsqueda por estado (`completada`) y fecha (`fechaAntes`, `fechaDespues`).

---

## 📬 Endpoints principales

| Método | Ruta               | Descripción                               |
|--------|--------------------|-------------------------------------------|
| GET    | `/api/tareas`      | Listar todas las tareas o aplicar filtros |
| GET    | `/api/tareas/{id}` | Obtener una tarea por ID                  |
| POST   | `/api/tareas`      | Crear una nueva tarea                     |
| PUT    | `/api/tareas/{id}` | Actualizar una tarea existente            |
| DELETE | `/api/tareas/{id}` | Eliminar una tarea por su ID              |

---

## 🔍 Uso de filtros (GET `/api/tareas`)

Puedes usar los siguientes parámetros opcionales en tus peticiones:

- `completada`: `true` o `false`
- `fechaAntes`: filtra tareas con vencimiento **antes o igual a** la fecha dada (formato `YYYY-MM-DD`)
- `fechaDespues`: filtra tareas con vencimiento **después o igual a** la fecha dada

Ejemplos:
```
/api/tareas?completada=true
/api/tareas?fechaAntes=2025-12-31
/api/tareas?completada=false&fechaDespues=2025-07-01
```

---

## 🛠️ Cómo ejecutar el proyecto

1. Asegúrate de tener PostgreSQL instalado y ejecutándose.
2. Crea una base de datos y usuario con acceso:

   ```sql
   CREATE USER gestoruser WITH PASSWORD 'gestorpass';
   CREATE DATABASE gestortareas OWNER gestoruser;
   ```

3. Abre el proyecto en IntelliJ IDEA.

4. Ejecuta la clase principal:
   ```
   com.pabloramirez.gestortareas.GestorTareasApplication
   ```

5. Accede a la API en:
   ```
   http://localhost:8080/api/tareas
   ```

6. Puedes probar los endpoints con herramientas como Postman o DBeaver.

---

## 🔧 Configuración de `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/gestortareas
spring.datasource.username=gestoruser
spring.datasource.password=gestorpass

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## 📌 Próximas mejoras

- Documentación automática con Swagger/OpenAPI
- Seguridad con Spring Security (JWT o auth básica)
- Interfaz web con React o Angular

---

## 👤 Autor

**Pablo Ramírez**  
[GitHub: pramirezd](https://github.com/pramirezd)