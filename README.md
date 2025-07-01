# 📋 Gestor de Tareas Spring Boot

Aplicación web desarrollada con **Spring Boot 3**, **Java 21**, **PostgreSQL** y **Swagger UI**, que permite gestionar tareas de forma eficiente. Incluye autenticación con **JWT**, protección de rutas, validaciones, filtros de búsqueda y un modelo listo para escalar.

---

## 🚀 Tecnologías utilizadas

- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Spring Security + JWT
- PostgreSQL
- Swagger / OpenAPI
- Maven

---

## 🛠️ Levantar el proyecto

1. Clona el repositorio:

```bash
git clone https://github.com/pramirezd/gestor-tareas-springboot.git
cd gestor-tareas-springboot
```

2. Crea una base de datos PostgreSQL con nombre `gestortareas`.

3. Configura tus credenciales en `src/main/resources/application.properties`:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/gestortareas
spring.datasource.username=gestoruser
spring.datasource.password=gestorpass
jwt.secret=esteEsUnSuperSecretoJWTconMasDe256BitsDeLongitud1234567890!
```

4. Levanta la app desde tu IDE o por terminal:

```bash
./mvnw spring-boot:run
```

---

## 🔐 Seguridad con JWT

El proyecto ahora cuenta con autenticación JWT:

- Endpoint público para login: `POST /auth/login`
- Endpoints protegidos bajo `/api/**`
- Roles definidos (`ADMIN`, `USER`) con control de acceso por anotaciones y configuración de rutas
- Filtro JWT para validar token en cada request

### 🧪 Probar en Postman

1. Realiza login:

```http
POST http://localhost:8080/auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "admin123"
}
```

2. Copia el token `accessToken` devuelto y úsalo en los siguientes requests:

```
Authorization: Bearer TU_TOKEN
```

---

## 📚 Documentación Swagger

Accede a la documentación generada automáticamente:

📄 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 🧩 Funcionalidades actuales

- CRUD de tareas
- Validación de datos
- Filtros de búsqueda por estado y fechas
- Documentación OpenAPI (Swagger)
- Autenticación y autorización JWT

---

## 🧠 Próximos pasos

- [ ] Crear interfaz web con React
- [ ] Implementar modelo de usuarios:
   - `ADMIN`: puede crear tareas propias y para otros usuarios
   - `USER`: puede ver las tareas asignadas y gestionar las propias
- [ ] Carga masiva de tareas por archivo CSV

---

## 👨‍💻 Autor

**Pablo Ramírez**

---

## 📄 Licencia

Este proyecto es de código abierto bajo licencia MIT.