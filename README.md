# SimulacroPOO

Este repositorio contiene la resolución del simulacro de final de Programación Orientada a Objetos (POO) para un sistema de librerías que venden con cuenta corriente.

## Enunciado

> Usted forma parte de un equipo de desarrollo que toma control de un proyecto abandonado para la construcción de un sistema para librerías que venden con cuenta corriente.  
> Se dispone del código fuente de la aplicación y la documentación de clases en un proyecto de StarUML.  
> El código fuente recibido está desordenado por lo que se decide adoptar el patrón MVC para continuar el desarrollo.

### Se solicita:

1. Ordenar el código (2 ptos)
    - El código debe estar ordenado según el patrón MVC
    - Se deben completar las clases faltantes según el diagrama de clases recibido
    - Todos los controladores deben adoptar el patrón Singleton.
2. Teniendo en cuenta el código recibido, regenerar el diagrama de secuencia del método `getCilenteConFacturasAdeudadas(cantFacturas)` de `ClienteController`. (2 ptos)
3. Teniendo en cuenta el diagrama de secuencia recibido, implementar el método `getClientesPorListaPrecio(lpID: int)` de `ClienteController`. (2 ptos)
4. Utilizar los métodos constructores de los controladores para insertar datos sintéticos (datos inventados) que permitan implementar un test unitario que pase correctamente. (2 ptos)
5. Implementar una pantalla con Swing que permita consultar todos los precios de un producto en las distintas listas de precios administradas. (2 ptos)

---

## Resolución

### 1. Orden y patrón MVC
- El proyecto está organizado en carpetas: `model`, `controller`, `dto`, `view`, siguiendo el patrón MVC.
- Se completaron las clases principales y auxiliares según el diagrama de StarUML.
- Todos los controladores implementan el patrón Singleton.

### 2. Diagrama de secuencia
- Se generó el diagrama de secuencia del método `getCilenteConFacturasAdeudadas` y se incluyó en el proyecto.

### 3. Implementación de métodos
- Se implementó el método `getClientesPorListaPrecio(lpID: int)` en `ClienteController`, retornando correctamente los clientes según la lista de precios.

### 4. Datos sintéticos y test unitario
- Los constructores de los controladores cargan datos ficticios para permitir la ejecución de tests unitarios.

### 5. Pantalla Swing
- Se desarrolló una pantalla con Swing (`ConsultaPreciosView`) que permite consultar los precios de un producto en todas las listas de precios.

---

## Estado

El proyecto cumple con todos los puntos del enunciado y está listo para revisión.

## actualización
11 de Julio de 2024 agregué detalles en el diagrama de secuencia y
actualicé la implementación del método `getClientesPorListaPrecio` para que retorne una lista de clientes con sus precios correspondientes.
sólo responsabilizando a los controllers de la lógica de negocio DTOS y no a los modelos.

---
## Luis Emilio
## Tecnicatura de Desarrollo Software
## UADE Buenos Aires Argentina