package calendario;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Evento {
    private String ubicacion;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private boolean esAudioVisual;
    private boolean tieneCatering;
    private Set<Persona> personasInvitadas;


    public Evento(String ubicacion, String nombre, String descripcion, Date fecha, boolean esAudioVisual, boolean tieneCatering) {
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.esAudioVisual = esAudioVisual;
        this.tieneCatering = tieneCatering;
        this.personasInvitadas = new HashSet<>();
    }


    public Evento(Date fecha, String ubicacion, String descripcion) {
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.personasInvitadas = new HashSet<>();
    }

    // Getters y Setters
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isEsAudioVisual() {
        return esAudioVisual;
    }

    public void setEsAudioVisual(boolean esAudioVisual) {
        this.esAudioVisual = esAudioVisual;
    }

    public boolean isTieneCatering() {
        return tieneCatering;
    }

    public void setTieneCatering(boolean tieneCatering) {
        this.tieneCatering = tieneCatering;
    }

    public Set<Persona> getPersonasInvitadas() {
        return personasInvitadas;
    }

    public void setPersonasInvitadas(Set<Persona> personasInvitadas) {
        this.personasInvitadas = personasInvitadas;
    }

    public void crearEvento() {
        // Implementación para crear un evento
    }


    public void eliminarEvento() {
        // Implementación para eliminar un evento
    }


    public void editarEvento() {
        // Implementación para editar un evento
    }


    public void asignarPersonasInvitadas(Persona personaInvitada) {
        this.personasInvitadas.add(personaInvitada);
    }

    public void eliminarPersonas(Persona personaInvitada) {
        this.personasInvitadas.remove(personaInvitada);
    }

  
    public int cantidadDeInvitados() {
        return this.personasInvitadas.size();
    }

    public boolean esProximo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
