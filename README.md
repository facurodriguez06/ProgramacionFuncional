# Proyecto de Práctica con Streams en Java

Este proyecto fue desarrollado como ejercicio para practicar el uso de Streams y colecciones en Java.  
Incluye varias clases (`Alumno`, `Producto`, `Libro` y `Empleado`) y un programa principal que realiza diferentes operaciones con listas de objetos.

## Contenido

- **Paquete `Entidades`**: contiene las clases modelo con sus atributos, constructores y anotaciones de Lombok para simplificar el código.
- **Clase `Main`**: ejecuta ejemplos de filtrado, agrupamiento, ordenamiento y cálculos con Streams.

## Temas aplicados

- Uso de **Streams** para manipular colecciones.
- Métodos intermedios (`filter`, `map`, `sorted`) y terminales (`collect`, `average`, `sum`, `max`).
- Agrupamiento con `Collectors.groupingBy()`.
- Uso de `Optional` y `Comparator`.
- Anotaciones de **Lombok** (`@Getter`, `@Setter`, `@ToString`, `@Builder`) para reducir código repetitivo.

## Requisitos

- **Java 17** o superior.
- **Lombok** configurado en el IDE.

## Ejecución

Clonar el repositorio y ejecutar la clase `Main`.  
El programa muestra por consola los resultados de las operaciones realizadas sobre las distintas listas de objetos.
