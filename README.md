# Gestor de Tareas - Spring Boot

Aplicación backend construida con Java 21 y Spring Boot 3.  
Permite gestionar tareas personales (CRUD completo) a través de una API REST.

---

## 🚀 Tecnologías usadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- H2 Database (modo memoria)
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
- Estructura por capas (Controller, Service, Repository, Model, Exception).

---

## 📬 Endpoints principales

| Método | Ruta                   | Descripción                        |
|--------|------------------------|------------------------------------|
| GET    | `/api/tareas`          | Listar todas las tareas            |
| GET    | `/api/tareas/{id}`     | Obtener una tarea por ID           |
| POST   | `/api/tareas`          | Crear una nueva tarea              |
| PUT    | `/api/tareas/{id}`     | Actualizar una tarea existente     |
| DELETE | `/api/tareas/{id}`     | Eliminar una tarea por su ID       |

---

## 🛠️ Cómo ejecutar el proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/pramirezd/gestor-tareas-springboot.git
   ```

2. Abre el proyecto en IntelliJ IDEA (Ultimate o Community).

3. Ejecuta la clase principal:
   ```
   com.pabloramirez.gestortareas.GestorTareasApplication
   ```

4. Accede a la API en:
   ```
   http://localhost:8080/api/tareas
   ```

5. Puedes probar los endpoints con herramientas como Postman o curl.

---

## 🔍 Ejemplos de validación

- Intentar crear una tarea sin título:
  ```json
  {
    "titulo": "",
    "descripcion": "Falta el título",
    "fechaVencimiento": "2025-12-31",
    "completada": false
  }
  ```
  Respuesta esperada:
  ```json
  {
    "titulo": "El título no puede estar vacío"
  }
  ```

- Intentar crear una tarea con descripción demasiado larga:
  ```json
  {
    "titulo": "Tarea",
    "descripcion": "Lorem ipsum dolor sit amet..." (más de 250 caracteres),
    "fechaVencimiento": "2025-12-31",
    "completada": false
  }
  ```
  Respuesta esperada:
  ```json
  {
    "descripcion": "La descripción no puede tener más de 250 caracteres"
  }
  ```

---

## 📌 Próximas mejoras

- Persistencia con PostgreSQL
- Filtros de búsqueda por estado o por fecha
- Documentación automática con Swagger/OpenAPI
- Seguridad con Spring Security (JWT o auth básica)
- Interfaz web con React o Angular

---

## 👤 Autor

**Pablo Ramírez Delgado**  
[GitHub: pramirezd](https://github.com/pramirezd)