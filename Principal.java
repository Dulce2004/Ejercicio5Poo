
/**
 * Esta clase es donde se crean el archivo .csv
 * 
 * @author: Dulce Ambrosio
 * @version: 14/10/2023
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Principal {
    private File archivo;

    /*
     * Class constructor
     */
    public Principal(String nombreArchivo) {
        archivo = new File(nombreArchivo);
    }

    /**
     * Método crear el archivo .csv
     * 
     * @param param1 la lista de los jugadores
     * @return devuelve un archivo de texto
     */
    public void escribirJugadores(List<Jugador> jugadores) {
        try (FileWriter escritor = new FileWriter(archivo)) {
            // Escribir encabezados
            escritor.write(
                    "Nombre,Pais,Errores,Aces,TotalServicios,Tipo,Pases,Jugadas,RecibosEfectivos,Ataques,BloqueosEfectivos,BloqueosFallidos,Efectividad\n");

            for (Jugador jugador : jugadores) {
                escritor.write(jugador.toCSVString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
