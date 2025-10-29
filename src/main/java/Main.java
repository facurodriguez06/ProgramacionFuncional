import Entidades.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // ==========================
        // SECCIÓN ALUMNOS
        // ==========================
        // Nota mental: estoy simulando actas de parcial de distintos cursos
        Alumno facu = new Alumno("Facundo", 9, "3k10");
        Alumno alma = new Alumno("Alma", 10, "3k10");
        Alumno lautaro = new Alumno("Lautaro", 10, "3k10");
        Alumno nico = new Alumno("Nicolas", 8, "3k09");

        List<Alumno> alumnos = List.of(facu, alma, lautaro, nico);

        // Aprobados = nota >=7, me guardo solo el nombre en MAYÚSCULA y ordenado alfabéticamente
        List<String> aprobados = alumnos.stream()
                .filter(a -> a.getNota() >= 7)
                .map(a -> a.getNombre().toUpperCase())
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Aprobados del parcial: " + aprobados);
        System.out.println();

        // promedio general de notas (double porque average() devuelve double)
        double promedioNotas = alumnos.stream()
                .mapToDouble(Alumno::getNota)
                .average()
                .orElse(0.0);

        System.out.println("Promedio general de notas: " + promedioNotas);
        System.out.println();

        // Agrupar alumnos por curso (4A, 4B, etc.)
        Map<String, List<Alumno>> alumnosPorCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));

        System.out.println("Listado por curso:");
        alumnosPorCurso.forEach((curso, listaAlumnos) -> {
            System.out.println("Curso " + curso + ":");
            listaAlumnos.forEach(System.out::println);
        });

        System.out.println("--------------------------------------------------");
        System.out.println();

        // ==========================
        // SECCIÓN PRODUCTOS
        // ==========================
        // Mini inventario tipo kiosco/deposito
        Producto pr1 = new Producto("Cable USB-C", "Tecnologia", 2999.99, 15);
        Producto pr2 = new Producto("Mouse Gamer", "Tecnologia", 18999.50, 7);
        Producto pr3 = new Producto("Yerba Orgánica", "Alimentos", 5400.00, 42);
        Producto pr4 = new Producto("Chocolatada 1L", "Alimentos", 2500.00, 10);

        List<Producto> productos = List.of(pr1, pr2, pr3, pr4);

        // Productos que salen más de $5000, ordenados de más caro a más barato
        List<Producto> premium = productos.stream()
                .filter(p -> p.getPrecio() > 5000.00)
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .collect(Collectors.toUnmodifiableList());

        System.out.println("Productos de ticket alto (> $5000): " + premium);
        System.out.println();

        // Agrupar por categoría (Tecnologia, Alimentos, etc.)
        Map<String, List<Producto>> productosPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria));

        System.out.println("Inventario agrupado por categoría:");
        productosPorCategoria.forEach((cat, listaCat) -> {
            System.out.println("Categoría: " + cat);
            listaCat.forEach(System.out::println);
        });

        System.out.println();

        // Calcular stock total disponible (sumo los stocks)
        double stockTotal = productos.stream()
                .mapToDouble(Producto::getStock)
                .sum();
        System.out.println("Stock total en depósito: " + stockTotal);

        System.out.println();

        // Armar un string tipo "Cable USB-C $2999.99; Mouse Gamer $18999.5; ..."
        // Esto sirve tipo para mostrar en una vista rápida en un menú
        String resumenCatalogo = productos.stream()
                .map(p -> p.getNombre() + " $" + p.getPrecio())
                .collect(Collectors.joining("; "));
        System.out.println("Catálogo resumido: " + resumenCatalogo);

        // Precio promedio de los productos
        double precioPromedio = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0.0);
        System.out.println("Precio promedio de venta: $" + precioPromedio);

        System.out.println();

        // Precio promedio POR categoría
        Map<String, Double> promedioPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)
                ));

        System.out.println("Precio promedio por categoría:");
        promedioPorCategoria.forEach((cat, prom) ->
                System.out.println(" - " + cat + " => $" + prom)
        );

        System.out.println("--------------------------------------------------");
        System.out.println();

        // ==========================
        // SECCIÓN LIBROS
        // ==========================
        // Acá me hice una mini base como si fuera una librería
        Libro lb1 = new Libro("Arquitectura Limpia", "Martín Pérez", 410, 52000.0);
        Libro lb2 = new Libro("Introducción a Redes", "Laura Gómez", 255, 31000.0);
        Libro lb3 = new Libro("Patrones de Diseño", "Martín Pérez", 370, 61000.0);
        Libro lb4 = new Libro("Fundamentos de Java", "Carla Ruiz", 180, 27999.99);

        List<Libro> libros = List.of(lb1, lb2, lb3, lb4);

        // Títulos con +300 páginas
        List<String> librosLargos = libros.stream()
                .filter(l -> l.getPaginas() >= 300)
                .map(Libro::getTitulo)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Libros de lectura larga (+300 págs): " + librosLargos);
        System.out.println();

        // Promedio de páginas
        double promedioPaginas = libros.stream()
                .mapToInt(Libro::getPaginas)
                .average()
                .orElse(0.0);
        System.out.println("Promedio de páginas por libro: " + promedioPaginas);
        System.out.println();

        // Agrupar libros por autor
        Map<String, List<Libro>> librosPorAutor = libros.stream()
                .collect(Collectors.groupingBy(Libro::getAutor));

        System.out.println("Catálogo agrupado por autor:");
        librosPorAutor.forEach((autor, listaLibros) -> {
            System.out.println("Autor: " + autor);
            listaLibros.forEach(System.out::println);
        });

        System.out.println();

        // Buscar el libro más caro
        Optional<Libro> masCaro = libros.stream()
                .max(Comparator.comparingDouble(Libro::getPrecio));

        masCaro.ifPresent(l ->
                System.out.println("Libro más caro del catálogo: " + l.getTitulo() +
                        " ($" + l.getPrecio() + ")")
        );

        System.out.println("--------------------------------------------------");
        System.out.println();

        // ==========================
        // SECCIÓN EMPLEADOS
        // ==========================
        // Acá simulo como dos áreas distintas y sus sueldos
        Empleado e1 = new Empleado("Franco", "Soporte", 750_000.0, 28);
        Empleado e2 = new Empleado("Juan", "Soporte", 730_000.0, 24);
        Empleado e3 = new Empleado("Sofía", "Desarrollo", 1_150_000.0, 31);
        Empleado e4 = new Empleado("Rafael", "Desarrollo", 1_250_000.0, 29);

        List<Empleado> empleados = List.of(e1, e2, e3, e4);

        // Empleados con salario >= 1 millón, ordenados de mayor a menor
        List<Empleado> topPagos = empleados.stream()
                .filter(emp -> emp.getSalario() >= 1_000_000.0)
                .sorted(Comparator.comparingDouble(Empleado::getSalario).reversed())
                .collect(Collectors.toList());

        System.out.println("Personal mejor pago (>= $1.000.000): " + topPagos);
        System.out.println();

        // Salario promedio general
        double salarioPromedio = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average()
                .orElse(0.0);
        System.out.println("Salario promedio general: $" + salarioPromedio);
        System.out.println();

        // Agrupar empleados por departamento
        Map<String, List<Empleado>> empleadosPorDepto = empleados.stream()
                .collect(Collectors.groupingBy(Empleado::getDepartamento));

        System.out.println("Empleados agrupados por área:");
        empleadosPorDepto.forEach((depto, listaEmp) -> {
            System.out.println("Departamento: " + depto);
            listaEmp.forEach(System.out::println);
        });
        System.out.println();

        // Suma total de lo que paga la empresa en sueldos
        double nominaTotal = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .sum();
        System.out.println("Costo total de nómina: $" + nominaTotal);
        System.out.println();

        // Gasto salarial por departamento
        Map<String, Double> gastoPorDepto = empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::getDepartamento,
                        Collectors.summingDouble(Empleado::getSalario)
                ));

        System.out.println("Sueldos por departamento:");
        gastoPorDepto.forEach((depto, totalDepto) ->
                System.out.println(" - " + depto + " => $" + totalDepto)
        );

        System.out.println();

        // Los 2 empleados más jóvenes de toda la lista
        List<Empleado> juniorTalent = empleados.stream()
                .sorted(Comparator.comparingInt(Empleado::getEdad))
                .limit(2)
                .collect(Collectors.toList());

        System.out.println("Talento más joven (top 2): " + juniorTalent);
        System.out.println();
    }
}
