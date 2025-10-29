package Entidades;
import lombok.*;

// Clase simple para representar alumnos de un curso
// Uso @Builder para poder crear objetos con sintaxis fluida tipo Alumno.builder()...
@Builder
@Getter
@Setter
@ToString
public class Alumno {
    private String nombre;
    private int nota;
    private String curso;

    // Constructor con parámetros (lo pide el ejercicio)
    public Alumno(String nombre, int nota, String curso){
        this.nombre = nombre;
        this.curso = curso;
        this.nota = nota;
    }
}
