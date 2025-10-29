package Entidades;
import lombok.*;

// Representa empleados dentro de una empresa o área
// No uso @Builder acá solo para variar la implementación
@Getter
@Setter
@ToString
public class Empleado {
    private String nombre;
    private String departamento;
    private double salario;
    private int edad;

    // Constructor obligatorio para inicializar todos los atributos
    public Empleado(String nombre, String departamento, double salario, int edad) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
        this.edad = edad;
    }
}
