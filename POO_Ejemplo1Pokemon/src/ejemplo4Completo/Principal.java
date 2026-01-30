package ejemplo4Completo;

import java.io.*;
import java.util.ArrayList;

public class Principal {
    static BufferedReader LEER = new BufferedReader(new InputStreamReader(System.in));
    // ARRAYLIST PARA LA POKEDEX
    static ArrayList<Pokemon> pokedex = new ArrayList<Pokemon>();

    public static void main(String[] args) throws IOException {
        boolean salir = false;
        do {
            System.out.println(" ______________________________________________________________ ");
            System.out.println("|                        MENU POKÉMON                          |");
            System.out.println("|______________________________________________________________|");
            System.out.println("|  1. Registrar Pokémon       |  13. Salir                     |");
            System.out.println("|  2. Mostrar todos           |  14. Filtrar por Tipo          |");
            System.out.println("|  3. Eliminar Pokémon        |  15. Modificar Pokémon         |");
            System.out.println("|  4. Añadir Ataque           |  16. Contar Nivel > 50         |");
            System.out.println("|  5. Eliminar Ataque         |  17. Buscar Duplicado Nombre   |");
            System.out.println("|  6. Dar XP                  |  18. Calcular Media Nivel      |");
            System.out.println("|  7. Mas Nivel               |  19. Buscar por Letra Inicial  |");
            System.out.println("|  8. Menos Nivel             |  20. Resetear Ataques          |");
            System.out.println("|  9. Orden Mayor a Menor     |  21. Mostrar Ticket            |");
            System.out.println("| 10. Orden Menor a Mayor     |  22. Intercambiar Posiciones   |");
            System.out.println("| 11. Ver Detalle             |  23. Evolucionar Pokémon       |");
            System.out.println("| 12. Buscar por Ataque       |                                |");
            System.out.println("|_____________________________|________________________________|");
            System.out.print(" Elige una opción: ");
            
            int opc = leerIntPositivo();

            switch (opc) {
                case 1: registrar(); break;
                case 2: mostrarTodos(); break;
                case 3: eliminarPokemon(); break;
                case 4: gestionarAtaque(true); break;
                case 5: gestionarAtaque(false); break;
                case 6: subirXP(); break;
                case 7: extremo(true); break;
                case 8: extremo(false); break;
                case 9: ordenar(true); break;
                case 10: ordenar(false); break;
                case 11: verDetalle(); break;
                case 12: buscarGlobalAtaque(); break;
                case 13: salir = true; break;
                case 14: filtrarPorTipo(); break;
                case 15: modificarPokemon(); break;
                case 16: contarNivelAltos(); break;
                case 17: buscarDuplicadoNombre(); break;
                case 18: calcularMediaNivel(); break;
                case 19: buscarPorLetra(); break;
                case 20: resetearAtaques(); break;
                case 21: mostrarTicket(); break;
                case 22: intercambiar(); break;
                case 23: evolucionarPokemon(); break;
            }
        } while (!salir);
    }

    private static void registrar() {
        Pokemon p = new Pokemon();
        p.pedirDatos(pokedex);
        pokedex.add(p);
    }

    private static void mostrarTodos() {
        if (pokedex.isEmpty()) System.out.println("Pokedex vacía.");
        for (Pokemon p : pokedex) p.mostrarResumen();
    }

    private static void eliminarPokemon() throws IOException {
        System.out.print("ID a borrar: ");
        int id = leerIntPositivo();
        for (int i = 0; i < pokedex.size(); i++) {
            if (pokedex.get(i).getId() == id) {
                pokedex.remove(i);
                System.out.println("Eliminado.");
                return;
            }
        }
        System.out.println("No encontrado.");
    }

    private static void gestionarAtaque(boolean añadir) throws IOException {
        System.out.print("ID: ");
        int id = leerIntPositivo();
        for (Pokemon p : pokedex) {
            if (p.getId() == id) {
                if (añadir) p.añadirAtaque();
                else p.eliminarAtaque();
                return;
            }
        }
    }

    private static void subirXP() throws IOException {
        System.out.print("ID: ");
        int id = leerIntPositivo();
        for (Pokemon p : pokedex) {
            if (p.getId() == id) {
                p.darXP();
                return;
            }
        }
    }

    private static void extremo(boolean max) {
        if (pokedex.isEmpty()) return;
        Pokemon aux = pokedex.get(0);
        for (Pokemon p : pokedex) {
            if (max && p.getNivel() > aux.getNivel()) aux = p;
            if (!max && p.getNivel() < aux.getNivel()) aux = p;
        }
        aux.mostrarDetalle();
    }

    private static void ordenar(boolean desc) {
        for (int i = 0; i < pokedex.size() - 1; i++) {
            for (int j = 0; j < pokedex.size() - i - 1; j++) {
                boolean cond = desc ? (pokedex.get(j).getNivel() < pokedex.get(j+1).getNivel()) : (pokedex.get(j).getNivel() > pokedex.get(j+1).getNivel());
                if (cond) {
                    Pokemon temp = pokedex.get(j);
                    pokedex.set(j, pokedex.get(j+1));
                    pokedex.set(j+1, temp);
                }
            }
        }
        mostrarTodos();
    }

    private static void verDetalle() throws IOException {
        System.out.print("ID: ");
        int id = leerIntPositivo();
        for (Pokemon p : pokedex) {
            if (p.getId() == id) { p.mostrarDetalle(); return; }
        }
    }

    private static void buscarGlobalAtaque() throws IOException {
        System.out.print("Ataque: ");
        String a = leerLinea();
        for (Pokemon p : pokedex) {
            if (p.conoceAtaque(a)) System.out.println("- " + p.getNombre());
        }
    }

    private static void filtrarPorTipo() throws IOException {
        System.out.print("Tipo: ");
        String t = leerLinea();
        for (Pokemon p : pokedex) {
            if (p.getTipo().equalsIgnoreCase(t)) p.mostrarResumen();
        }
    }

    private static void modificarPokemon() throws IOException {
        System.out.print("ID: ");
        int id = leerIntPositivo();
        for (Pokemon p : pokedex) {
            if (p.getId() == id) { p.pedirDatos(pokedex); return; }
        }
    }

    private static void contarNivelAltos() {
        int c = 0;
        for (Pokemon p : pokedex) if (p.getNivel() > 50) c++;
        System.out.println("Total > 50: " + c);
    }

    private static void buscarDuplicadoNombre() throws IOException {
        System.out.print("Nombre: ");
        String n = leerLinea();
        for (Pokemon p : pokedex) {
            if (p.getNombre().equalsIgnoreCase(n)) { System.out.println("Ya existe."); return; }
        }
        System.out.println("Libre.");
    }

    private static void calcularMediaNivel() {
        if (pokedex.isEmpty()) return;
        double s = 0;
        for (Pokemon p : pokedex) s += p.getNivel();
        System.out.println("Media: " + (s / pokedex.size()));
    }

    private static void buscarPorLetra() throws IOException {
        System.out.print("Letra: ");
        String l = leerLinea();
        for (Pokemon p : pokedex) {
            if (p.getNombre().toLowerCase().startsWith(l.toLowerCase())) p.mostrarResumen();
        }
    }

    private static void resetearAtaques() throws IOException {
        System.out.print("ID: ");
        int id = leerIntPositivo();
        for (Pokemon p : pokedex) {
            if (p.getId() == id) { p.limpiarAtaques(); return; }
        }
    }

    private static void mostrarTicket() throws IOException {
        System.out.print("ID: ");
        int id = leerIntPositivo();
        for (Pokemon p : pokedex) {
            if (p.getId() == id) { p.mostrarResumen(); return; }
        }
    }

    private static void intercambiar() throws IOException {
        System.out.print("Pos A: ");
        int a = leerIntPositivo();
        System.out.print("Pos B: ");
        int b = leerIntPositivo();
        if (a < pokedex.size() && b < pokedex.size()) {
            Pokemon temp = pokedex.get(a);
            pokedex.set(a, pokedex.get(b));
            pokedex.set(b, temp);
        }
    }

    private static void evolucionarPokemon() throws IOException {
        System.out.print("ID: ");
        int id = leerIntPositivo();
        for (Pokemon p : pokedex) {
            if (p.getId() == id) { p.evolucionar(); return; }
        }
    }

    public static int leerInt() throws IOException {
        int num = 0;
        boolean valido = false;
        while (!valido) {
            try {
                num = Integer.parseInt(LEER.readLine());
                valido = true;
            } catch (Exception e) { System.err.print("Número inválido: "); }
        }
        return num;
    }

    public static int leerIntPositivo() throws IOException {
        int num = leerInt();
        while (num < 0) { System.err.print("Positivo: "); num = leerInt(); }
        return num;
    }

    public static String leerLinea() throws IOException {
        String texto;
        do {
            texto = LEER.readLine().trim();
            if (texto.length() > 0 && esTextoValido(texto)) break;
            System.err.print("Invalido: ");
        } while (true);
        return texto;
    }

    public static boolean esTextoValido(String t) {
        for (char c : t.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') return false;
        }
        return true;
    }
}