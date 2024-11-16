/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo13.trabajopractico;

/**
 *
 * @author sofi
 */
public class Evento {
    private String nombre;
    private String fecha;
    private String ubicacion;
    private String descripcion;

    public Evento(String nombre, String fecha, String ubicacion, String descripcion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }

    public String getNombre() { return nombre; }
    public String getFecha() { return fecha; }
    public String getUbicacion() { return ubicacion; }
    public String getDescripcion() { return descripcion; }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setFecha(String fecha){
        this.fecha=nombre;
    }
    public void setUbicacion(String ubicacion){
        this.ubicacion=nombre;
    }
    public void setDescripcion(String descripcion){
        this.descripcion=nombre;
    }

    public boolean esProximo() {
        // Implementar lógica que verifique si la fecha del evento es futura
        return true; // Simplificado para este ejemplo
    }
}
