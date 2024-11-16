
package calendario;

import java.util.Date;

public class Calendario {

    private Date fecha;
    private Evento evento;

    public Calendario(Date fecha, Evento evento) {
        this.fecha = fecha;
        this.evento = evento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void mostrarDetallesEvento() {
        System.out.println("Fecha: " + fecha);
        System.out.println("Evento: " + evento.getNombre());
    }
}