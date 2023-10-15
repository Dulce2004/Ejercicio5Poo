/**
 * Esta clase es donde se crean los otros atributos del Auxiliar u Opuesto
 * 
 * @author: Dulce Ambrosio
 * @version: 14/10/2023
 */
public class AuxiliaresOpuestos extends Jugador {

    private int ataques;
    private int bloqueos_efectivos;
    private int bloqueos_fallidos;

    /*
     * Class constructor
     */
    public AuxiliaresOpuestos(String nombre, String pais, int errores, int aces, int total_servicios, int ataques,
            int bloqueos_efectivos, int bloqueos_fallidos) {
        super(nombre, pais, errores, aces, total_servicios);
        this.ataques = ataques;
        this.bloqueos_efectivos = bloqueos_efectivos;
        this.bloqueos_fallidos = bloqueos_fallidos;
    }

    /*
     * setters y getters
     */
    public int getAtaques() {
        return ataques;
    }

    public void setAtaques(int ataques) {
        this.ataques = ataques;
    }

    public int getBloqueos_efectivos() {
        return bloqueos_efectivos;
    }

    public void setBloqueos_efectivos(int bloqueos_efectivos) {
        this.bloqueos_efectivos = bloqueos_efectivos;
    }

    public int getBloqueos_fallidos() {
        return bloqueos_fallidos;
    }

    public void setBloqueos_fallidos(int bloques_fallidos) {
        this.bloqueos_fallidos = bloques_fallidos;
    }

    /**
     * Método para calcular la efectividad del auxiliar y opuesto, haciendo uso del
     * polimorfismo
     * 
     * @param param1 los valores son de tipo int
     * @return devuelve un entero
     */
    @Override
    public int calcularEfectividad() {
        return (((ataques + bloqueos_efectivos - bloqueos_fallidos - errores) * 100
                / (ataques + bloqueos_efectivos + bloqueos_fallidos + errores)) + aces * 100 / total_servicios);
    }

    /**
     * Método para mostrar los datos del auxiliar u opuesto, haciendo uso del
     * polimorfismo
     * 
     * @param param1 los valores son de tipo string
     * @return devuelve un string
     */
    @Override
    public String toString() {
        return "Auxiliares y Opuestos: " + super.toString() + "Ataques: " + getAtaques() + "Bloqueos Efectivos: "
                + getBloqueos_efectivos() + "Bloqueos Fallidos: " + getBloqueos_fallidos();
    }

}