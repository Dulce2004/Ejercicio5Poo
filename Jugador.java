/**
 * Esta clase es donde se crean los atributos que heredaran
 * las clases hijas
 * 
 * @author: Dulce Ambrosio
 * @version: 14/10/2023
 */
public class Jugador {

    protected String nombre;
    protected String pais;
    protected int errores;
    protected int aces;
    protected int total_servicios;

    /*
     * Class constructor
     */
    public Jugador(String nombre, String pais, int errores, int aces, int total_servicios) {
        this.nombre = nombre;
        this.pais = pais;
        this.errores = errores;
        this.aces = aces;
        this.total_servicios = total_servicios;
    }

    /*
     * setters y getters
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

    public int getAces() {
        return aces;
    }

    public void setAces(int aces) {
        this.aces = aces;
    }

    public int getTotal_servicios() {
        return total_servicios;
    }

    public void setTotal_servicios(int total_servicios) {
        this.total_servicios = total_servicios;
    }

    /**
     * Método para calcular la efectividad del jugador
     * 
     * @param param1 los valores son de tipo int
     * @return devuelve un entero
     */
    public int calcularEfectividad() {
        return (((-errores) * 100 / (+errores)) + aces * 100 / total_servicios);
    }

    /**
     * Método para mostrar los datos del jugador
     * 
     * @param param1 los valores son de tipo String
     * @return devuelve valores String
     */
    public String toString() {
        return "Nomrbe: " + getNombre() + "País: " + getPais() + "Errores: " + getErrores() + "Aces : " + getAces()
                + "Total de Servicios: " + getTotal_servicios();
    }

    /**
     * Método para calcular crear el archivo .csv
     * 
     * @param param1 los valores son de tipo string
     * @return devuelve un valor string
     */
    public String toCSVString() {
        // Construye la cadena CSV con los datos del jugador
        String tipo = this instanceof Pasador ? "Pasador"
                : this instanceof Libero ? "Libero"
                        : this instanceof AuxiliaresOpuestos ? "AuxiliarOpuesto" : "Desconocido";
        return String.format("%s,%s,%d,%d,%d,%s,%d,%d,%d,%d,%d,%d,%d",
                nombre, pais, errores, aces, total_servicios, tipo,
                this instanceof Pasador ? ((Pasador) this).getPases() : 0,
                this instanceof Pasador ? ((Pasador) this).getJugadas() : 0,
                this instanceof Libero ? ((Libero) this).getRecibos_efectivos() : 0,
                this instanceof AuxiliaresOpuestos ? ((AuxiliaresOpuestos) this).getAtaques() : 0,
                this instanceof AuxiliaresOpuestos ? ((AuxiliaresOpuestos) this).getBloqueos_efectivos() : 0,
                this instanceof AuxiliaresOpuestos ? ((AuxiliaresOpuestos) this).getBloqueos_fallidos() : 0,
                calcularEfectividad());
    }

}