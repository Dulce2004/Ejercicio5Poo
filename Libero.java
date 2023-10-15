public class Libero extends Jugador {

    private int recibos_efectivos;

    // Constructor
    public Libero(String nombre, String pais, int errores, int aces, int total_servicios, int recibos_efectivos) {
        super(nombre, pais, errores, aces, total_servicios);
        this.recibos_efectivos = recibos_efectivos;
    }

    // Getters y Setter
    public int getRecibos_efectivos() {
        return recibos_efectivos;
    }

    public void setRecibos_efectivos(int recibos_efectivos) {
        this.recibos_efectivos = recibos_efectivos;
    }

    @Override
    public int calcularEfectividad() {
        return (((recibos_efectivos - errores) * 100 / (recibos_efectivos + errores)) + aces * 100 / total_servicios);
    }

    @Override
    public String toString() {
        return "Líbero: " + super.toString() + "Recibos Efectivos: " + getRecibos_efectivos();
    }

}