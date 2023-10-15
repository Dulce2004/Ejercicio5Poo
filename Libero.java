/**
 * Esta clase es donde se crean los otros atributos del Líbero
 * 
 * @author: Dulce Ambrosio
 * @version: 14/10/2023
 */
public class Libero extends Jugador {

    private int recibos_efectivos;

    /*
     * Class constructor
     */
    public Libero(String nombre, String pais, int errores, int aces, int total_servicios, int recibos_efectivos) {
        super(nombre, pais, errores, aces, total_servicios);
        this.recibos_efectivos = recibos_efectivos;
    }

    /*
     * setters y getters
     */
    public int getRecibos_efectivos() {
        return recibos_efectivos;
    }

    public void setRecibos_efectivos(int recibos_efectivos) {
        this.recibos_efectivos = recibos_efectivos;
    }

    /**
     * Método para calcular la efectividad del Líbero, haciendo uso del polimorfismo
     * 
     * @param param1 los valores son de tipo int
     * @return devuelve un entero
     */
    @Override
    public int calcularEfectividad() {
        return (((recibos_efectivos - errores) * 100 / (recibos_efectivos + errores)) + aces * 100 / total_servicios);
    }

    /**
     * Método para mostrar los datos del líbero, haciendo uso del polimorfismo
     * 
     * @param param1 los valores son de tipo string
     * @return devuelve un string
     */
    @Override
    public String toString() {
        return "Líbero: " + super.toString() + "Recibos Efectivos: " + getRecibos_efectivos();
    }

}