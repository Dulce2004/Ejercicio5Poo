import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Torneo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Jugador> jugadores = new ArrayList<>();

        while (true) {
            System.out.println("Bienvenido al menú");
            System.out.println("1. Agregar Jugador");
            System.out.println("2. Mostrar todos los jugadores");
            System.out.println("3. Mostrar los 3 mejores Líberos");
            System.out.println("4. Cantidad de pasadores con más del 80% en efectividad");
            System.out.println("5. Salir");
            System.out.println("Elija la opción que desee: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("----------------------------------------------------");
                    System.out.println("INGRESE LOS DATOS QUE SE LE PIDE");
                    System.out.println("Nomrbe: ");
                    String nombre = scanner.nextLine();
                    System.out.println("País: ");
                    String pais = scanner.nextLine();
                    System.out.println("Errores");
                    int errores = scanner.nextInt();
                    System.out.println("Aces: ");
                    int aces = scanner.nextInt();
                    System.out.println("Total de servicios: ");
                    int total_servicios = scanner.nextInt();

                    Jugador jugador = new Jugador(nombre, pais, errores, aces, total_servicios);
                    jugadores.add(jugador);

                    System.out.println("Que tipo de jugador es: ");
                    System.out.println("1. Pasador");
                    System.out.println("2. Líbero");
                    System.out.println("3. Auxiliar u Opuesto");
                    System.out.println("4. Salir");
                    int opcion2 = scanner.nextInt();

                    if (jugadores.isEmpty()) {
                        System.out.println("No se han ingresado jugadores");
                    } else if (opcion2 == 1) {
                        System.out.println("Pases: ");
                        int pases = scanner.nextInt();
                        System.out.println("Jugadas: ");
                        int jugadas = scanner.nextInt();
                        Pasador pasador = new Pasador(nombre, pais, errores, aces, total_servicios, pases, jugadas);
                        jugadores.add(pasador);
                    } else if (opcion2 == 2) {
                        System.out.println("Recibos Efectivos: ");
                        int recibos_efectivos = scanner.nextInt();
                        Libero libero = new Libero(nombre, pais, errores, aces, total_servicios, recibos_efectivos);
                        jugadores.add(libero);
                    } else if (opcion2 == 3) {
                        System.out.println("Ataques: ");
                        int ataques = scanner.nextInt();
                        System.out.println("Bloques Efectivos: ");
                        int bloqueos_efectivos = scanner.nextInt();
                        System.out.println("Bloqueos Fallidos: ");
                        int bloqueos_fallidos = scanner.nextInt();
                        AuxiliaresOpuestos auxiliaresOpuestos = new AuxiliaresOpuestos(nombre, pais, errores, aces,
                                total_servicios, ataques, bloqueos_efectivos, bloqueos_fallidos);
                        jugadores.add(auxiliaresOpuestos);
                    } else if (opcion2 == 4) {
                        System.out.println("Dirigiendo al menú principal");
                        break;
                    }
                    break;
                case 2:
                    System.out.println("----------------------------------------------------");
                    System.out.println("Lista de jugadores:");
                    for (Jugador jugador2 : jugadores) {
                        System.out.println("Nombre: " + jugador2.getNombre());
                        System.out.println("País: " + jugador2.getPais());
                        System.out.println("Errores: " + jugador2.getErrores());
                        System.out.println("Aces: " + jugador2.getAces());
                        System.out.println("Total de servicios: " + jugador2.getTotal_servicios());

                        if (jugador2 instanceof Pasador) {
                            Pasador pasador = (Pasador) jugador2;
                            System.out.println("Tipo de jugador: Pasador");
                            System.out.println("Pases: " + pasador.getPases());
                            System.out.println("Jugadas: " + pasador.getJugadas());
                        } else if (jugador2 instanceof Libero) {
                            Libero libero = (Libero) jugador2;
                            System.out.println("Tipo de jugador: Líbero");
                            System.out.println("Recibos Efectivos: " + libero.getRecibos_efectivos());
                        } else if (jugador2 instanceof AuxiliaresOpuestos) {
                            AuxiliaresOpuestos auxiliaresOpuestos = (AuxiliaresOpuestos) jugador2;
                            System.out.println("Tipo de jugador: Auxiliar u Opuesto");
                            System.out.println("Ataques: " + auxiliaresOpuestos.getAtaques());
                            System.out.println("Bloques Efectivos: " + auxiliaresOpuestos.getBloqueos_efectivos());
                            System.out.println("Bloques Fallidos: " + auxiliaresOpuestos.getBloqueos_fallidos());
                        }
                    }
                    break;
                case 3:
                    System.out.println("----------------------------------------------------");
                    List<Libero> mejoresLiberos = new ArrayList<>();
                    if (jugadores.isEmpty()) {
                        System.out.println("Aún no hay Líberos ingresados");

                    } else {

                        for (Jugador jugador2 : jugadores) {
                            if (jugador2 instanceof Libero) {
                                mejoresLiberos.add((Libero) jugador2);
                            }
                        }
                        Collections.sort(mejoresLiberos, new Comparator<Libero>() {
                            @Override
                            public int compare(Libero libero1, Libero libero2) {
                                return Integer.compare(libero2.calcularEfectividad(), libero1.calcularEfectividad());
                            }
                        });
                        System.out.println("Los 3 mejores Líberos son:");
                        int contador = 0;
                        for (Libero libero : mejoresLiberos) {
                            System.out.println(libero);
                            contador++;
                            if (contador == 3) {
                                break; // Mostramos solo los 3 mejores
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("----------------------------------------------------");
                    if (jugadores.isEmpty()) {
                        System.out.println("No hay jugadores con más del 80% de efectividad");

                    } else {
                        int contadorPasadoresEfectivos = 0;
                        for (Jugador jugador2 : jugadores) {
                            if (jugador2 instanceof Pasador) {
                                Pasador pasador = (Pasador) jugador2;
                                if (pasador.calcularEfectividad() > 80) {
                                    contadorPasadoresEfectivos++;
                                }
                            }
                        }

                        System.out.println("Cantidad de pasadores con más del 80% de efectividad en su servicio: "
                                + contadorPasadoresEfectivos);
                    }
                    break;
                case 5:
                    System.out.println("----------------------------------------------------");
                    System.out.println("Cerrando Sistema...");
                    scanner.close();
                    Principal archivoJugadores = new Principal("jugadores.csv");
                    archivoJugadores.escribirJugadores(jugadores);
                    System.exit(0);
                    break;

            }
        }

    }
}