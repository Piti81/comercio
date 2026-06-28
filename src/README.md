# Mueblería Online - Backend con Spring Boot

## Descripción

Este proyecto consiste en el desarrollo del backend de una mueblería online utilizando Spring Boot, Spring Data JPA y MySQL. Además, se creó un frontend sencillo con HTML, Bootstrap y JavaScript para poder consumir la API y realizar pruebas.

---

# Tecnologías utilizadas

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Lombok
* Jakarta Validation
* HTML
* Bootstrap
* JavaScript
* Thunder Client
* Visual Studio Code

---

# Desarrollo del proyecto

## 1. Creación del proyecto

Se creó el proyecto utilizando Spring Boot con Maven.

Se agregaron las siguientes dependencias:

* Spring Web
* Spring Data JPA
* MySQL Driver
* Validation
* Lombok

---

## 2. Configuración de la base de datos

Se creó la base de datos **comercio** en MySQL.

Luego se configuró el archivo `application.properties` con la conexión:

* URL de MySQL
* Usuario
* Contraseña
* Hibernate
* Mostrar consultas SQL

---

## 3. Modelo de datos

Se desarrollaron las entidades principales.

### Producto

Contiene:

* id
* nombre
* precio
* stock
* color

Se agregó la validación correspondiente utilizando Bean Validation.

---

### Categoría

Cada categoría puede contener varios productos y un producto puede pertenecer a varias categorías.

Se implementó una relación:

ManyToMany

---

### Pedido

Representa una compra realizada por un cliente.

Contiene:

* cliente
* fecha
* tipo de entrega
* líneas del pedido

---

### LíneaPedido

Representa cada producto incluido en un pedido.

Contiene:

* producto
* cantidad

---

## 4. Relaciones entre entidades

Se implementaron las siguientes relaciones:

* Producto ↔ Categoría (ManyToMany)
* Pedido → LíneaPedido (OneToMany)
* LíneaPedido → Producto (ManyToOne)

---

## 5. Repositorios

Se creó un repositorio para cada entidad utilizando Spring Data JPA.

De esta forma se pudieron utilizar directamente los métodos:

* save()
* findAll()
* findById()
* deleteById()

---

## 6. Servicios

Se desarrolló un Service para cada entidad.

En los servicios se implementó la lógica del negocio.

Por ejemplo:

* buscar productos
* actualizar productos
* eliminar productos
* crear pedidos
* descontar stock

Cuando se registra un pedido:

* se verifica que exista el producto
* se valida el stock disponible
* se descuenta automáticamente la cantidad comprada

---

## 7. Controladores

Se desarrollaron controladores REST para:

* Productos
* Categorías
* Pedidos

Los endpoints permiten realizar operaciones CRUD mediante:

* GET
* POST
* PUT
* DELETE

---

## 8. Validaciones

Se utilizaron anotaciones como:

* @NotBlank
* @NotNull
* @Min
* @Valid

para evitar datos incorrectos.

---

## 9. Manejo de excepciones

Se implementó un manejador global de excepciones utilizando:

@RestControllerAdvice

Se crearon excepciones personalizadas para:

* Producto inexistente
* Stock insuficiente

---

## 10. Pruebas con Thunder Client

Antes de desarrollar el frontend se probaron todos los endpoints utilizando Thunder Client.

Se verificó:

* alta de productos
* modificación
* eliminación
* alta de categorías
* creación de pedidos
* actualización automática del stock

---

## 11. Desarrollo del frontend

Se desarrolló una interfaz sencilla utilizando:

* HTML
* Bootstrap
* JavaScript

Se crearon tres pantallas:

* Productos
* Categorías
* Pedidos

Desde cada una es posible consumir la API mediante Fetch.

---

## 12. Integración

Finalmente se integró el frontend con el backend.

Las operaciones realizadas desde la página web se comunican con Spring Boot mediante peticiones HTTP y los datos se almacenan en MySQL.

---

# Funcionalidades

* Alta de productos
* Modificación de productos
* Eliminación de productos
* Alta de categorías
* Asociación de productos y categorías
* Creación de pedidos
* Control de stock
* Validaciones
* Manejo de excepciones
* Persistencia en MySQL

---

# Conclusión

Este proyecto permitió aplicar los conceptos principales de Spring Boot y desarrollo backend, integrando una base de datos relacional con JPA y creando una API REST funcional. Como complemento, se desarrolló un frontend simple para consumir los servicios y verificar el funcionamiento completo de la aplicación.
