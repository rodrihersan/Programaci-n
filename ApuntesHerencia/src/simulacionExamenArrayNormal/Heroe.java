package simulacionExamenArrayNormal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Heroe extends Personaje {
    private String organizacion;
    private int misiones;

    public void pedirDatos(Personaje[] lista, int numPersonajes) {
        super.pedirDatos(lista, numPersonajes);
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        boolean datosOK = false;
        while (!datosOK) {
            try {
                do {
                    System.out.print("Introduce la organizacion (Avengers/XMen/JusticeLeague): ");
                    this.organizacion = leer.readLine();
                    if (!organizacion.equalsIgnoreCase("Avengers") &&
                        !organizacion.equalsIgnoreCase("XMen") &&
                        !organizacion.equalsIgnoreCase("JusticeLeague"))
                        System.out.println("Organizacion no valida");
                } while (!organizacion.equalsIgnoreCase("Avengers") &&
                         !organizacion.equalsIgnoreCase("XMen") &&
                         !organizacion.equalsIgnoreCase("JusticeLeague"));

                boolean misionesOK = false;
                while (!misionesOK) {
                    try {
                        System.out.print("Introduce el numero de misiones completadas: ");
                        this.misiones = Integer.parseInt(leer.readLine());
                        if (misiones < 0)
                            System.out.println("No puede ser negativo");
                        else
                            misionesOK = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Solo puedes introducir numeros");
                    }
                }

                datosOK = true;
            } catch (IOException e) {
                System.out.println("Error leyendo datos");
            }
        }
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Organizacion: " + this.organizacion);
        System.out.println("Misiones completadas: " + this.misiones);
        System.out.println("----------------------------");
    }
}