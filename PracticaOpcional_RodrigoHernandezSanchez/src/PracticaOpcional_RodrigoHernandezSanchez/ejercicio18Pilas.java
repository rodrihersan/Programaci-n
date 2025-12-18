package PracticaOpcional_RodrigoHernandezSanchez;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ejercicio18Pilas {

    public static String leerLinea() throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        String texto;

        do {
            texto = leer.readLine().trim();
            if (texto.length() == 0) {
                System.err.print("No puede estar vacío. Inténtalo de nuevo: ");
            }
        } while (texto.length() == 0);

        return texto;
    }

    public static void main(String[] args) throws IOException {

        Stack<String> historial = new Stack<>();
        boolean salir = false;

        do {
            System.out.println("\n=== HISTORIAL DE NAVEGACIÓN ===");
            System.out.println("1. Visitar nueva página");
            System.out.println("2. Volver a página anterior");
            System.out.println("3. Ver página actual");
            System.out.println("4. Mostrar todo el historial");
            System.out.println("5. Ir a página inicial");
            System.out.println("6. Contar páginas en el historial");
            System.out.println("7. Buscar una URL");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");

            int opcion = Integer.parseInt(leerLinea());

            switch (opcion) {
                case 1: opcion1(historial); break;
                case 2: opcion2(historial); break;
                case 3: opcion3(historial); break;
                case 4: opcion4(historial); break;
                case 5: opcion5(historial); break;
                case 6: opcion6(historial); break;
                case 7: opcion7(historial); break;
                case 8: salir = true; System.out.println("¡Hasta luego!"); break;
                default: System.err.println("Opción no válida");
            }

        } while (!salir);
    }

    //case1
    public static void opcion1(Stack<String> historial) throws IOException {
        System.out.print("Introduce la URL: ");
        String url = leerLinea();
        historial.push(url);
        System.out.println("Página visitada: " + url);
    }

    //case2
    public static void opcion2(Stack<String> historial) {
        System.out.println("-- Volver a página anterior --");

        if (historial.isEmpty()) {
            System.out.println("No hay páginas en el historial");
            return;
        }

        String pagina = historial.pop();
        System.out.println("Has vuelto desde: " + pagina);
    }

    //case3
    public static void opcion3(Stack<String> historial) {
        System.out.println("-- Página actual --");

        if (historial.isEmpty()) {
            System.out.println("No hay página actual");
            return;
        }

        System.out.println("Página actual: " + historial.peek());
    }

    //case4
    public static void opcion4(Stack<String> historial) {
        System.out.println("-- Historial completo --");

        if (historial.isEmpty()) {
            System.out.println("Historial vacío");
            return;
        }

        for (int i = historial.size() - 1; i >= 0; i--) {
            System.out.println(historial.get(i));
        }
    }

    //case5
    public static void opcion5(Stack<String> historial) {
        historial.clear();
        System.out.println("Has vuelto a la página inicial");
    }

    //case6
    public static void opcion6(Stack<String> historial) {
        System.out.println("Total de páginas visitadas: " + historial.size());
    }

    //case7
    public static void opcion7(Stack<String> historial) throws IOException {
        System.out.print("Introduce la URL a buscar: ");
        String url = leerLinea();

        boolean encontrada = false;

        for (String pagina : historial) {
            if (pagina.equalsIgnoreCase(url)) {
                encontrada = true;
                break;
            }
        }

        if (encontrada) {
            System.out.println("La URL ha sido visitada");
        } else {
            System.out.println("La URL NO ha sido visitada");
        }
    }
}