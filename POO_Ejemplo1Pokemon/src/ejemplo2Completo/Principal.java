package ejemplo2Completo;

import java.io.*;

public class Principal {
    static BufferedReader LEER = new BufferedReader(new InputStreamReader(System.in));
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
            System.out.print("Elige una opción: ");
            
            // USAMOS TU MÉTODO SEGURO PARA EL MENÚ
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
        if (cont == 0) System.out.println("No hay pokemons.");
        for (int i = 0; i < cont; i++) pokedex[i].mostrarResumen();
    }

    private static void eliminarPokemon() throws IOException {
        System.out.print("ID a eliminar: ");
        int id = leerIntPositivo();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getId() == id) {
                for (int j = i; j < cont - 1; j++) pokedex[j] = pokedex[j+1];
                cont--;
                System.out.println("Pokemon liberado.");
                return;
            }
        }
        System.out.println("No encontrado.");
    }

    private static void gestionarAtaque(boolean añadir) throws IOException {
        System.out.print("ID Pokemon: ");
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
        System.out.print("ID Pokemon: ");
        int id = leerIntPositivo();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getId() == id) {
                pokedex[i].darXP();
                return;
            }
        }
    }

    private static void extremo(boolean buscarMax) {
        if (cont == 0) return;
        Pokemon aux = pokedex[0];
        for (int i = 1; i < cont; i++) {
            if (buscarMax && pokedex[i].getNivel() > aux.getNivel()) aux = pokedex[i];
            if (!buscarMax && pokedex[i].getNivel() < aux.getNivel()) aux = pokedex[i];
        }
        aux.mostrarDetalle();
    }

    private static void ordenar(boolean descendente) {
        for (int i = 0; i < cont - 1; i++) {
            for (int j = 0; j < cont - i - 1; j++) {
                boolean condicion = descendente ? 
                    (pokedex[j].getNivel() < pokedex[j+1].getNivel()) : 
                    (pokedex[j].getNivel() > pokedex[j+1].getNivel());
                
                if (condicion) {
                    Pokemon temp = pokedex[j];
                    pokedex[j] = pokedex[j+1];
                    pokedex[j+1] = temp;
                }
            }
        }
        mostrarTodos();
    }

    private static void verDetalle() throws IOException {
        System.out.print("ID Pokemon: ");
        int id = leerIntPositivo();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getId() == id) {
                pokedex[i].mostrarDetalle();
                return;
            }
        }
    }

    private static void buscarGlobalAtaque() throws IOException {
        System.out.print("Nombre del ataque: ");
        String a = leerLinea();
        boolean hallado = false;
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].conoceAtaque(a)) {
                System.out.println("- " + pokedex[i].getNombre());
                hallado = true;
            }
        }
        if (!hallado) System.out.println("Ninguno conoce ese ataque.");
    }

    private static void filtrarPorTipo() throws IOException {
        System.out.print("Tipo a buscar: ");
        String t = leerLinea();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getTipo().equalsIgnoreCase(t)) pokedex[i].mostrarResumen();
        }
    }

    private static void modificarPokemon() throws IOException {
        System.out.print("ID a modificar: ");
        int id = leerIntPositivo();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getId() == id) {
                pokedex[i].pedirDatos(pokedex, i); 
                return;
            }
        }
    }

    private static void contarNivelAltos() {
        int c = 0;
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getNivel() > 50) c++;
        }
        System.out.println("Pokémon con nivel > 50: " + c);
    }

    private static void buscarDuplicadoNombre() throws IOException {
        System.out.print("Nombre a comprobar: ");
        String n = leerLinea();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getNombre().equalsIgnoreCase(n)) {
                System.out.println("El nombre ya existe.");
                return;
            }
        }
        System.out.println("Nombre libre.");
    }

    private static void calcularMediaNivel() {
        if (cont == 0) return;
        double suma = 0;
        for (int i = 0; i < cont; i++) suma += pokedex[i].getNivel();
        System.out.println("Media de nivel: " + (suma / cont));
    }

    private static void buscarPorLetra() throws IOException {
        System.out.print("Letra inicial: ");
        String l = leerLinea();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getNombre().toLowerCase().startsWith(l.toLowerCase())) {
                pokedex[i].mostrarResumen();
            }
        }
    }

    private static void resetearAtaques() throws IOException {
        System.out.print("ID: ");
        int id = leerIntPositivo();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getId() == id) {
                pokedex[i].limpiarAtaques();
                return;
            }
        }
    }

    private static void mostrarTicket() throws IOException {
        System.out.print("ID: ");
        int id = leerIntPositivo();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getId() == id) {
                System.out.println("====================");
                pokedex[i].mostrarResumen();
                System.out.println("====================");
            }
        }
    }

    private static void intercambiar() throws IOException {
        System.out.print("Posición A: ");
        int a = leerIntPositivo();
        System.out.print("Posición B: ");
        int b = leerIntPositivo();
        if (a < cont && b < cont) {
            Pokemon temp = pokedex[a];
            pokedex[a] = pokedex[b];
            pokedex[b] = temp;
        }
    }

    private static void evolucionarPokemon() throws IOException {
        System.out.print("ID: ");
        int id = leerIntPositivo();
        for (int i = 0; i < cont; i++) {
            if (pokedex[i].getId() == id) {
                pokedex[i].evolucionar();
                return;
            }
        }
    }

    // --- TUS MÉTODOS DE VALIDACIÓN ---

    public static int leerInt() throws IOException {
        int num = 0;
        boolean valido = false;
        while (!valido) {
            try {
                num = Integer.parseInt(LEER.readLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.err.print("ERROR. ");
                System.out.print("Introduce un número válido: ");
            }
        }
        return num;
    }

    public static int leerIntPositivo() throws IOException {
        int numero = leerInt();
        while (numero < 0) {
            System.err.print("ERROR. ");
            System.out.print("El número no puede ser negativo. Inténtalo de nuevo: ");
            numero = leerInt();
        }
        return numero;
    }

    public static String leerLinea() throws IOException {
        String texto;
        do {
            texto = LEER.readLine().trim();
            if (texto.length() == 0) {
                System.err.print("Debes escribir algo: ");
                continue;
            }
            if (!esTextoValido(texto)) {
                System.err.print("Solo letras, sin números ni símbolos: ");
                continue;
            }
            break;
        } while (true);
        return texto;
    }

    public static boolean esTextoValido(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                return false;
            }
        }
        return true;
    }
}