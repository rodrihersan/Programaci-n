package ejemplo5Completo;

import java.io.*;

public class Principal {
    static BufferedReader LEER = new BufferedReader(new InputStreamReader(System.in));
    // POKEDEX COMO ARRAY NORMAL
    static Pokemon[] pokedex = new Pokemon[20];
    static int cont = 0;

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
        if (cont < pokedex.length) {
            Pokemon p = new Pokemon();
            p.pedirDatos(pokedex, cont);
            pokedex[cont] = p;
            cont++;
        } else { System.out.println("Pokedex llena."); }
    }

    private static void mostrarTodos() {
        if (cont == 0) System.out.println("Vacío.");
        for (int i = 0; i < cont; i++) pokedex[i].mostrarResumen();
    }

    private static void eliminarPokemon() throws IOException {
        System.out.print("ID a borrar: ");
        int id = leerIntPositivo();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getId() == id) {
                for (int j = i; j < cont - 1; j++) pokedex[j] = pokedex[j + 1];
                cont--;
                System.out.println("Borrado.");
                return;
            }
        }
    }

    private static void gestionarAtaque(boolean añadir) throws IOException {
        System.out.print("ID: ");
        int id = leerIntPositivo();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getId() == id) {
                if (añadir) pokedex[i].añadirAtaque();
                else pokedex[i].eliminarAtaque();
                return;
            }
        }
    }

    private static void subirXP() throws IOException {
        System.out.print("ID: ");
        int id = leerIntPositivo();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getId() == id) { pokedex[i].darXP(); return; }
        }
    }

    private static void extremo(boolean max) {
        if (cont == 0) return;
        Pokemon aux = pokedex[0];
        for (int i = 0; i < cont; i++) {
            if (max && pokedex[i].getNivel() > aux.getNivel()) aux = pokedex[i];
            if (!max && pokedex[i].getNivel() < aux.getNivel()) aux = pokedex[i];
        }
        aux.mostrarDetalle();
    }

    private static void ordenar(boolean desc) {
        for (int i = 0; i < cont - 1; i++) {
            for (int j = 0; j < cont - i - 1; j++) {
                boolean c = desc ? (pokedex[j].getNivel() < pokedex[j+1].getNivel()) : (pokedex[j].getNivel() > pokedex[j+1].getNivel());
                if (c) {
                    Pokemon t = pokedex[j];
                    pokedex[j] = pokedex[j+1];
                    pokedex[j+1] = t;
                }
            }
        }
        mostrarTodos();
    }

    private static void verDetalle() throws IOException {
        System.out.print("ID: ");
        int id = leerIntPositivo();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getId() == id) { pokedex[i].mostrarDetalle(); return; }
        }
    }

    private static void buscarGlobalAtaque() throws IOException {
        System.out.print("Ataque: ");
        String a = leerLinea();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].conoceAtaque(a)) System.out.println("- " + pokedex[i].getNombre());
        }
    }

    private static void filtrarPorTipo() throws IOException {
        System.out.print("Tipo: ");
        String t = leerLinea();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getTipo().equalsIgnoreCase(t)) pokedex[i].mostrarResumen();
        }
    }

    private static void modificarPokemon() throws IOException {
        System.out.print("ID: ");
        int id = leerIntPositivo();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getId() == id) { pokedex[i].pedirDatos(pokedex, cont); return; }
        }
    }

    private static void contarNivelAltos() {
        int c = 0;
        for (int i = 0; i < cont; i++) if (pokedex[i].getNivel() > 50) c++;
        System.out.println("Total > 50: " + c);
    }

    private static void buscarDuplicadoNombre() throws IOException {
        System.out.print("Nombre: ");
        String n = leerLinea();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getNombre().equalsIgnoreCase(n)) { System.out.println("Existe."); return; }
        }
        System.out.println("Libre.");
    }

    private static void calcularMediaNivel() {
        if (cont == 0) return;
        double s = 0;
        for (int i = 0; i < cont; i++) s += pokedex[i].getNivel();
        System.out.println("Media: " + (s / cont));
    }

    private static void buscarPorLetra() throws IOException {
        System.out.print("Letra: ");
        String l = leerLinea();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getNombre().toLowerCase().startsWith(l.toLowerCase())) pokedex[i].mostrarResumen();
        }
    }

    private static void resetearAtaques() throws IOException {
        System.out.print("ID: ");
        int id = leerIntPositivo();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getId() == id) { pokedex[i].limpiarAtaques(); return; }
        }
    }

    private static void mostrarTicket() throws IOException {
        System.out.print("ID: ");
        int id = leerIntPositivo();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getId() == id) { pokedex[i].mostrarResumen(); return; }
        }
    }

    private static void intercambiar() throws IOException {
        System.out.print("Pos A: ");
        int a = leerIntPositivo();
        System.out.print("Pos B: ");
        int b = leerIntPositivo();
        if (a < cont && b < cont) {
            Pokemon t = pokedex[a];
            pokedex[a] = pokedex[b];
            pokedex[b] = t;
        }
    }

    private static void evolucionarPokemon() throws IOException {
        System.out.print("ID: ");
        int id = leerIntPositivo();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getId() == id) { pokedex[i].evolucionar(); return; }
        }
    }

    public static int leerInt() throws IOException {
        int num = 0;
        boolean v = false;
        while (!v) {
            try {
                num = Integer.parseInt(LEER.readLine());
                v = true;
            } catch (Exception e) { System.err.print("Error: "); }
        }
        return num;
    }

    public static int leerIntPositivo() throws IOException {
        int n = leerInt();
        while (n < 0) { System.err.print("Positivo: "); n = leerInt(); }
        return n;
    }

    public static String leerLinea() throws IOException {
        String t;
        do {
            t = LEER.readLine().trim();
            if (t.length() > 0 && esTextoValido(t)) break;
            System.err.print("Invalido: ");
        } while (true);
        return t;
    }

    public static boolean esTextoValido(String t) {
        for (char c : t.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') return false;
        }
        return true;
    }
}