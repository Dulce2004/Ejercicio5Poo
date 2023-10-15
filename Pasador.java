public class Pasador extends Jugador {
    private int pases;
    private int jugadas;

    // Constructor
    public Pasador(String nombre, String pais, int errores, int aces, int total_servicios, int pases, int jugadas) {
        super(nombre, pais, errores, aces, total_servicios);
        this.pases = pases;
        this.jugadas = jugadas;
    }

    // Getters y Setters
    public int getPases() {
        return pases;
    }

    public void setPases(int pases) {
        this.pases = pases;
    }

    public int getJugadas() {
        return jugadas;
    }

    public void setJugadas(int jugadas) {
        this.jugadas = jugadas;
    }

    @Override
    public int calcularEfectividad() {
        return (((pases + jugadas - errores) * 100 / (pases + jugadas + errores)) + aces * 100 / total_servicios);
    }

    @Override
    public String toString() {
        return "Pasador: " + super.toString() + ", Pases: " + getPases() + "Jugadas: " + getJugadas() + "Efectividad: "
                + calcularEfectividad();
    }

}