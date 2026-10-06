# 📚 E-Commerce Bookstore API (Backend)

## 📖 Sobre el Proyecto
Este proyecto es el backend para una plataforma de comercio electrónico orientada a la venta de libros. Está construido con **Java y Spring Boot**, y diseñado bajo los principios de la **Arquitectura Hexagonal (Puertos y Adaptadores)** . 

El objetivo principal de esta arquitectura es mantener la lógica de negocio (Dominio) completamente aislada de las tecnologías externas (Bases de datos, Frameworks web, Seguridad), garantizando un código altamente escalable, testeable y mantenible.

## 🛠️ Stack Tecnológico
* **Lenguaje:** Java 21
* **Framework Principal:** Spring Boot 3
* **Arquitectura:** Hexagonal / Clean Architecture
* **Base de Datos:** MySQL
* **Infraestructura:** Docker (para la virtualización de la base de datos)
* **Seguridad:** Spring Security (Autenticación básica y Control de Acceso por Roles)
* **Testing:** JUnit 5 y Mockito (Pruebas Unitarias de Casos de Uso)

## 🚀 Estado Actual del Proyecto (Fase 1 Completada)
Actualmente, el sistema cuenta con el flujo vertical completo (Dominio -> Aplicación -> Infraestructura) para la gestión del catálogo base, incluyendo la persistencia en base de datos y la protección de endpoints:

* **Gestión de Autores (`Author`)**: Operaciones de Creación, Lectura (Listar todos y Buscar por ID) y Eliminación. *(Actualización pendiente)*.
* **Gestión de Categorías (`CategoryBook`)**: Operaciones de Creación, Lectura (Listar todas y Buscar por ID) y Eliminación. *(Actualización pendiente)*.
* **Gestión de Editoriales (`BookPublisher`)**: Operaciones de Creación, Lectura (Listar todas y Buscar por ID) y Eliminación. *(Actualización pendiente)*.
* **Seguridad Implementada**: 
  * Endpoints de lectura (GET) públicos para visualizar el catálogo.
  * Endpoints de escritura y eliminación (POST, DELETE) protegidos y restringidos exclusivamente para administradores (`ROLE_ADMIN`).
* **Manejo de Excepciones**: Respuestas HTTP estructuradas (404 Not Found) mediante un `GlobalExceptionHandler` personalizado.

## 📋 Próximos Pasos (Backlog / Roadmap)
El proyecto está en desarrollo continuo. Las siguientes fases incluyen:
* Implementar los endpoints de actualización (PUT/PATCH) para Autores, Categorías y Editoriales.
* **Fase 2: Integración del Modelo Principal**
  * Implementación de la entidad `Book` con relaciones complejas (Autores múltiples, Categorías, Editorial).
  * Filtros de búsqueda avanzados (por título, autor, categoría, etc.).
* **Fase 3: Gestión de Clientes y Ventas**
  * Registro de nuevos usuarios (`Customer`).
  * Implementación del Carrito de Compras, Generación de Pedidos (`Order`) y Detalles de Pedido (`OrderItem`).
* **Fase 4: Funcionalidades Extra**
  * Creación y gestión de "Lista de Deseos" (Wishlist).

## ⚙️ Requisitos Previos
Para ejecutar este proyecto localmente, necesitas tener instalado:
* [Java JDK 21](https://jdk.java.net/21/)
* [Maven](https://maven.apache.org/)
* [Docker Desktop](https://www.docker.com/products/docker-desktop/) 

## 🏃‍♀️ Cómo ejecutar el proyecto localmente

**1. Levantar la Base de Datos:**
El proyecto incluye un archivo de configuración para Docker. Abre tu terminal en la raíz del proyecto y ejecuta:
```bash
docker-compose up -d
