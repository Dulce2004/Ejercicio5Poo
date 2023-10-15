/**
 * Esta clase es donde se crean los otros atributos del Pasador
 * 
 * @author: Dulce Ambrosio
 * @version: 14/10/2023
 */
public class Pasador extends Jugador {
    private int pases;
    private int jugadas;

    /*
     * Class constructor
     */
    public Pasador(String nombre, String pais, int errores, int aces, int total_servicios, int pases, int jugadas) {
        super(nombre, pais, errores, aces, total_servicios);
        this.pases = pases;
        this.jugadas = jugadas;
    }

    /*
     * setters y getters
     */
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

    /**
     * Método para calcular la efectividad del pasador, haciendo uso del
     * polimorfismo
     * 
     * @param param1 los valores son de tipo int
     * @return devuelve un entero
     */
    @Override
    public int calcularEfectividad() {
        return (((pases + jugadas - errores) * 100 / (pases + jugadas + errores)) + aces * 100 / total_servicios);
    }

    /**
     * Método para mostrar los datos del pasador, haciendo uso del polimorfismo
     * 
     * @param param1 los valores son de tipo string
     * @return devuelve un string
     */
    @Override
    public String toString() {
        return "Pasador: " + super.toString() + ", Pases: " + getPases() + "Jugadas: " + getJugadas() + "Efectividad: "
                + calcularEfectividad();
    }

}