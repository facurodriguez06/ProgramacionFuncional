package Entidades;
import lombok.*;

// Entidad genérica para manejar productos en stock o inventario
@Builder
@Getter
@Setter
@ToString
public class Producto {
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;

    // Constructor tradicional (por si no se usa el builder)
    public Producto(String nombre, String categoria, double precio, int stock){
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }
}
