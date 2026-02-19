package ClashRoyale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Carta> cartas = new ArrayList<Carta>();

        boolean salir = false;
        do {
            System.out.println("\n=== CLASH ROYALE ===");
            System.out.println("1. Añadir carta");
            System.out.println("2. Mostrar cartas por rareza");
            System.out.println("3. Añadir carta al mazo activo");
            System.out.println("4. Estadisticas de la coleccion");
            System.out.println("5. Salir");
            System.out.print("Introduce una opcion: ");

            int opcion = -1;
            boolean datosOK = false;
            while (!datosOK) {
                try {
                    opcion = Integer.parseInt(leer.readLine());
                    datosOK = true;
                } catch (NumberFormatException | IOException e) {
                    System.out.println("Solo puedes introducir numeros");
                }
            }

            switch (opcion) {
                case 1:
                    añadirCarta(cartas);
                    break;
                case 2:
                    mostrarPorRareza(cartas);
                    break;
                case 3:
                    añadirAlMazo(cartas);
                    break;
                case 4:
                    estadisticas(cartas);
                    break;
                case 5:
                    salir = true;
                    System.out.println("¡Nos vemos en la arena!");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (!salir);
    }

    private static void añadirCarta(ArrayList<Carta> cartas) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        int cantidad = 0;
        boolean datosOK = false;
        while (!datosOK) {
            try {
                System.out.print("¿Cuantas cartas desea añadir?: ");
                cantidad = Integer.parseInt(leer.readLine());
                if (cantidad <= 0)
                    System.out.println("Tiene que ser mayor que 0");
                else
                    datosOK = true;
            } catch (NumberFormatException | IOException e) {
                System.out.println("Solo puedes introducir numeros");
            }
        }

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Añadiendo carta " + (i + 1) + " de " + cantidad);

            String tipo = "";
            do {
                try {
                    System.out.print("Tipo de carta (Tropa o Hechizo): ");
                    tipo = leer.readLine();
                    if (!tipo.equalsIgnoreCase("tropa") && !tipo.equalsIgnoreCase("hechizo"))
                        System.out.println("Tiene que ser Tropa o Hechizo");
                } catch (IOException e) {
                    System.out.println("Error leyendo datos");
                }
            } while (!tipo.equalsIgnoreCase("tropa") && !tipo.equalsIgnoreCase("hechizo"));

            System.out.println("Introduce los datos de la nueva carta: ");

            if (tipo.equalsIgnoreCase("tropa")) {
                Tropa t = new Tropa();
                t.pedirDatos(cartas);
                cartas.add(t);
            } else {
                Hechizo h = new Hechizo();
                h.pedirDatos(cartas);
                cartas.add(h);
            }
        }
    }

    private static void mostrarPorRareza(ArrayList<Carta> cartas) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        String rareza = "";

        System.out.println("--- Mostrar cartas por rareza ---");
        do {
            try {
                System.out.print("Introduce la rareza de la carta (comun/especial/epica/legendaria): ");
                rareza = leer.readLine();
                if (!rareza.equalsIgnoreCase("comun") &&
                    !rareza.equalsIgnoreCase("especial") &&
                    !rareza.equalsIgnoreCase("epica") &&
                    !rareza.equalsIgnoreCase("legendaria"))
                    System.out.println("Introduce una opcion valida");
            } catch (IOException e) {
                System.out.println("Error leyendo datos");
            }
        } while (!rareza.equalsIgnoreCase("comun") &&
                 !rareza.equalsIgnoreCase("especial") &&
                 !rareza.equalsIgnoreCase("epica") &&
                 !rareza.equalsIgnoreCase("legendaria"));

        boolean enc = false;
        int contador = 1;
        for (int i = 0; i < cartas.size(); i++) {
            if (cartas.get(i).getRareza().equalsIgnoreCase(rareza)) {
                System.out.println("Mostrando carta " + contador);
                cartas.get(i).mostrarDatos();
                enc = true;
                contador++;
            }
        }

        if (!enc)
            System.out.println("No hay cartas de esa rareza");
    }

    private static void añadirAlMazo(ArrayList<Carta> cartas) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        String nombre = "";

        System.out.println("--- Añadir carta al mazo ---");
        try {
            System.out.print("Introduce el nombre de la carta a añadir al mazo: ");
            nombre = leer.readLine();
        } catch (IOException e) {
            System.out.println("Error leyendo datos");
            return;
        }

        int posEncontrado = -1;
        for (int i = 0; i < cartas.size(); i++) {
            if (cartas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                posEncontrado = i;
                break;
            }
        }

        if (posEncontrado == -1) {
            System.out.println("No existe ninguna carta con ese nombre");
            return;
        }

        if (cartas.get(posEncontrado).isUsadaEnMazo()) {
            System.out.println("La carta ya esta en el mazo activo");
            return;
        }

        int cartasEnMazo = 0;
        for (int i = 0; i < cartas.size(); i++) {
            if (cartas.get(i).isUsadaEnMazo())
                cartasEnMazo++;
        }

        if (cartasEnMazo >= 8) {
            System.out.println("El mazo ya tiene 8 cartas, no se pueden añadir mas");
            return;
        }

        cartas.get(posEncontrado).setUsadaEnMazo(true);
        cartasEnMazo++;
        System.out.println("Carta añadida correctamente al mazo");
        System.out.println("Cartas en el mazo: " + cartasEnMazo);

        int totalElixir = 0;
        for (int i = 0; i < cartas.size(); i++) {
            if (cartas.get(i).isUsadaEnMazo())
                totalElixir += cartas.get(i).getCosteElixir();
        }
        System.out.println("Elixir promedio del mazo: " + ((double) totalElixir / cartasEnMazo));
    }

    private static void estadisticas(ArrayList<Carta> cartas) {
        System.out.println("=== ESTADISTICAS DE LA COLECCION ===");

        int numTropas = 0;
        int numHechizos = 0;
        for (int i = 0; i < cartas.size(); i++) {
            if (cartas.get(i) instanceof Tropa)
                numTropas++;
            else if (cartas.get(i) instanceof Hechizo)
                numHechizos++;
        }
        System.out.println("-- Por tipo --");
        System.out.println("Numero de tropas: " + numTropas);
        System.out.println("Numero de hechizos: " + numHechizos);

        int comun = 0;
        int especial = 0;
        int epica = 0;
        int legendaria = 0;
        for (int i = 0; i < cartas.size(); i++) {
            if (cartas.get(i).getRareza().equalsIgnoreCase("comun"))
                comun++;
            else if (cartas.get(i).getRareza().equalsIgnoreCase("especial"))
                especial++;
            else if (cartas.get(i).getRareza().equalsIgnoreCase("epica"))
                epica++;
            else if (cartas.get(i).getRareza().equalsIgnoreCase("legendaria"))
                legendaria++;
        }
        System.out.println("-- Por rareza --");
        System.out.println("Comun: " + comun);
        System.out.println("Especial: " + especial);
        System.out.println("Epica: " + epica);
        System.out.println("Legendaria: " + legendaria);

        System.out.println("-- Elixir --");
        if (cartas.size() == 0) {
            System.out.println("No hay cartas registradas");
        } else {
            int totalElixir = 0;
            for (int i = 0; i < cartas.size(); i++) {
                totalElixir += cartas.get(i).getCosteElixir();
            }
            System.out.println("Elixir promedio de todas las cartas: " + ((double) totalElixir / cartas.size()));
        }

        System.out.println("-- Mazo activo --");
        int cartasEnMazo = 0;
        int totalElixirMazo = 0;
        for (int i = 0; i < cartas.size(); i++) {
            if (cartas.get(i).isUsadaEnMazo()) {
                cartasEnMazo++;
                totalElixirMazo += cartas.get(i).getCosteElixir();
                cartas.get(i).mostrarDatos();
            }
        }
        System.out.println("Numero de cartas en el mazo: " + cartasEnMazo);
        if (cartasEnMazo > 0) {
            System.out.println("Elixir promedio del mazo: " + ((double) totalElixirMazo / cartasEnMazo));
        } else {
            System.out.println("No hay cartas en el mazo");
        }
    }
}
