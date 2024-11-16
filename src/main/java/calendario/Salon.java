package calendario;

public class Salon {
    private String nombre;
    private int capacidad;
    private boolean esAudiovisual;
    private boolean tieneCatering;

    public Salon(String nombre, int capacidad, boolean esAudiovisual, boolean tieneCatering) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.esAudiovisual = esAudiovisual;
        this.tieneCatering = tieneCatering;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean EsAudiovisual() {
        return esAudiovisual;
    }

    public void setEsAudiovisual(boolean esAudiovisual) {
        this.esAudiovisual = esAudiovisual;
    }

    public boolean TieneCatering() {
        return tieneCatering;
    }

    public void setTieneCatering(boolean tieneCatering) {
        this.tieneCatering = tieneCatering;
    }
}
