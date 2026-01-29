package Ejemplo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
    static BufferedReader LEER = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<PokemonEntrenamiento> equipo = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        boolean salir = false;

        do {
            System.out.println("\n== POKÉMON MANAGEMENT SYSTEM ==");
            System.out.println("1. Registrar Pokémon");
            System.out.println("2. Añadir puntuación");
            System.out.println("3. Ver rendimiento");
            System.out.println("4. Calcular media");
            System.out.println("5. Pokémon Maestro");
            System.out.println("6. Alerta debilidad");
            System.out.println("7. Salir");
            
            int opcion = pedirInt("Seleccione opción: ");

            switch (opcion) {
                case 1: registrarPokemon(); break;
                case 2: añadirNota(); break;
                case 3: verRendimiento(); break;
                case 4: calcularMedia(); break;
                case 5: pokemonMaestro(); break;
                case 6: alertaDebilidad(); break;
                case 7: salir = true; break;
                default: System.out.println("Opción no válida.");
            }
        } while (!salir);
    }

    // Métodos estáticos para mantener el switch limpio
    private static void registrarPokemon() throws IOException {
        if (equipo.size() < 6) {
            PokemonEntrenamiento p = new PokemonEntrenamiento();
            p.pedirDatos(equipo);
            equipo.add(p);
        } else {
            System.out.println("No hay espacio en el equipo.");
        }
    }

    private static void añadirNota() {
        int id = pedirInt("ID del Pokémon: ");
        for (PokemonEntrenamiento p : equipo) {
            if (p.getId() == id) {
                p.añadirPuntuacion();
                return;
            }
        }
        System.out.println("Pokémon no encontrado.");
    }

    private static void verRendimiento() {
        int id = pedirInt("ID del Pokémon: ");
        for (PokemonEntrenamiento p : equipo) {
            if (p.getId() == id) {
                p.verCalificaciones();
                return;
            }
        }
        System.out.println("Pokémon no encontrado.");
    }

    private static void calcularMedia() {
        int id = pedirInt("ID del Pokémon: ");
        for (PokemonEntrenamiento p : equipo) {
            if (p.getId() == id) {
                System.out.println("La media de " + p.getNombre() + " es: " + p.devolverMedia());
                return;
            }
        }
        System.out.println("Pokémon no encontrado.");
    }

    private static void pokemonMaestro() {
    	if (equipo.isEmpty()) {
            System.out.println("No hay Pokémon registrados.");
            return;
        }

        // PASO 1: Encontrar cuál es la media más alta
        double maxMedia = -1;
        for (PokemonEntrenamiento p : equipo) {
            if (p.devolverMedia() > maxMedia) {
                maxMedia = p.devolverMedia();
            }
        }

        // PASO 2: Listar a todos los que tengan esa media máxima
        System.out.println("--- POKÉMON MAESTROS (Media: " + maxMedia + ") ---");
        for (PokemonEntrenamiento p : equipo) {
            if (p.devolverMedia() == maxMedia) {
                System.out.println(p.toString());
            }
        }
    }

    private static void alertaDebilidad() {
        System.out.println("--- POKÉMON CON DEBILIDADES (Notas < 5) ---");
        boolean hayDebilesGlobal = false;

        for (int i = 0; i < equipo.size(); i++) {
            // Obtenemos el array de notas del pokemon actual
            double[] notasActuales = equipo.get(i).getPuntuaciones();
            boolean tieneSuspenso = false;

            // Recorremos solo las notas que se han rellenado (numPuntuaciones)
            for (int j = 0; j < equipo.get(i).getNumPuntuaciones(); j++) {
                if (notasActuales[j] < 5) {
                    tieneSuspenso = true;
                    break; // Con una nota < 5 ya sabemos que es "débil"
                }
            }

            if (tieneSuspenso) {
                System.out.println("(!) Alerta: " + equipo.get(i).getNombre() + " necesita entrenar más.");
                hayDebilesGlobal = true;
            }
        }

        if (!hayDebilesGlobal) {
            System.out.println("Todo el equipo está en plena forma (sin notas < 5).");
        }
    }

    private static int pedirInt(String m) {
        try {
            System.out.print(m);
            return Integer.parseInt(LEER.readLine());
        } catch (Exception e) {
            return -1;
        }
    }
}