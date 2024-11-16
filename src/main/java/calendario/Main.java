package calendario;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Crear una fecha
        @SuppressWarnings("deprecation")
		Date date = new Date("15/11/2024");

        // Crear eventos
        Evento evento1 = new Evento(date, "CABA", "Evento de testeo 01");
        Evento evento2 = new Evento(date, "GBA", "Evento de testeo 02");

        // Crear calendario
        Calendario calendario1 = new Calendario(date, evento1);

        // Mostrar detalles de los eventos
        
        
    }
}