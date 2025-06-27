# Gestor de Tareas - Spring Boot

Aplicación backend construida con Java 21 y Spring Boot 3.  
Permite gestionar tareas personales (CRUD completo) a través de una API REST.

## Tecnologías usadas
- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

## Endpoints principales

- `GET /api/tareas` - Listar todas las tareas
- `GET /api/tareas/{id}` - Obtener tarea por ID
- `POST /api/tareas` - Crear nueva tarea
- `PUT /api/tareas/{id}` - Actualizar tarea existente
- `DELETE /api/tareas/{id}` - Eliminar tarea

## Cómo ejecutar

1. Clona el repositorio
2. Abre el proyecto en IntelliJ IDEA
3. Ejecuta la clase `GestorTareasApplication`
4. Accede a la API en `http://localhost:8080`

## Próximas mejoras

- Validaciones de datos
- Conexión con PostgreSQL
- Filtros y ordenamiento
- Autenticación con Spring Security
- Documentación Swagger