import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Principal {
    private File archivo;

    public Principal(String nombreArchivo) {
        archivo = new File(nombreArchivo);
    }

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
