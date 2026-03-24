package ejemplo3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Lecturas {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String leerString(String mensaje) {
        String valor = "";
        while (valor.isEmpty()) {
            System.out.print(mensaje);
            try {
                valor = br.readLine().trim();
                if (valor.isEmpty()) {
                    System.out.println("ERROR: El campo no puede estar vacío.");
                }
            } catch (IOException e) {
                System.out.println("ERROR: Problema al leer la entrada.");
            }
        }
        return valor;
    }

    public static int leerEntero(String mensaje) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            try {
                valor = Integer.parseInt(br.readLine().trim());
                valido = true;
            } catch (IOException e) {
                System.out.println("ERROR: Problema al leer la entrada.");
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Introduce un número entero válido.");
            }
        }
        return valor;
    }

    public static double leerDouble(String mensaje) {
        double valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            try {
                valor = Double.parseDouble(br.readLine().trim().replace(",", "."));
                valido = true;
            } catch (IOException e) {
                System.out.println("ERROR: Problema al leer la entrada.");
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Introduce un número decimal válido.");
            }
        }
        return valor;
    }

    public static int leerEnteroEnRango(String mensaje, int min, int max) {
        int valor;
        do {
            valor = leerEntero(mensaje);
            if (valor < min || valor > max) {
                System.out.println("ERROR: El valor debe estar entre " + min + " y " + max + ".");
            }
        } while (valor < min || valor > max);
        return valor;
    }

    public static double leerDoubleMayorQue(String mensaje, double minExclusivo) {
        double valor;
        do {
            valor = leerDouble(mensaje);
            if (valor <= minExclusivo) {
                System.out.println("ERROR: El valor debe ser mayor que " + minExclusivo + ".");
            }
        } while (valor <= minExclusivo);
        return valor;
    }

    public static int leerEnteroMayorQue(String mensaje, int minExclusivo) {
        int valor;
        do {
            valor = leerEntero(mensaje);
            if (valor <= minExclusivo) {
                System.out.println("ERROR: El valor debe ser mayor que " + minExclusivo + ".");
            }
        } while (valor <= minExclusivo);
        return valor;
    }

    public static String leerOpcion(String mensaje, String[] opciones) {
        String valor = "";
        boolean valido = false;
        while (!valido) {
            valor = leerString(mensaje);
            for (String opcion : opciones) {
                if (opcion.equalsIgnoreCase(valor)) {
                    valor = opcion;
                    valido = true;
                    break;
                }
            }
            if (!valido) {
                System.out.print("ERROR: Opción no válida. Las opciones son: ");
                for (int i = 0; i < opciones.length; i++) {
                    System.out.print(opciones[i]);
                    if (i < opciones.length - 1) System.out.print(", ");
                }
                System.out.println(".");
            }
        }
        return valor;
    }

    public static boolean leerSiNo(String mensaje) {
        String valor;
        do {
            valor = leerString(mensaje + " (s/n): ").toLowerCase();
            if (!valor.equals("s") && !valor.equals("n")) {
                System.out.println("ERROR: Introduce 's' o 'n'.");
            }
        } while (!valor.equals("s") && !valor.equals("n"));
        return valor.equals("s");
    }
}
