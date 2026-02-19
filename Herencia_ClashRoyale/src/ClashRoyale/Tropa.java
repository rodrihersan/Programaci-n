package ClashRoyale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Tropa extends Carta {
    private int puntosVida;
    private int danio;
    private String velocidad;

    public void pedirDatos(ArrayList<Carta> lista) {
        super.pedirDatos(lista);
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        boolean datosOK = false;
        while (!datosOK) {
            try {
                boolean vidaOK = false;
                while (!vidaOK) {
                    try {
                        System.out.print("Introduce los puntos de vida de la tropa: ");
                        this.puntosVida = Integer.parseInt(leer.readLine());
                        if (puntosVida < 0)
                            System.out.println("No puede ser negativo");
                        else
                            vidaOK = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Solo puedes introducir numeros");
                    }
                }

                boolean danioOK = false;
                while (!danioOK) {
                    try {
                        System.out.print("Introduce el daño de la tropa: ");
                        this.danio = Integer.parseInt(leer.readLine());
                        if (danio < 0)
                            System.out.println("No puede ser negativo");
                        else
                            danioOK = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Solo puedes introducir numeros");
                    }
                }

                do {
                    System.out.print("Introduce la velocidad de la tropa (lenta/media/rapida): ");
                    this.velocidad = leer.readLine();
                    if (!velocidad.equalsIgnoreCase("lenta") &&
                        !velocidad.equalsIgnoreCase("media") &&
                        !velocidad.equalsIgnoreCase("rapida"))
                        System.out.println("Introduce una opcion valida");
                } while (!velocidad.equalsIgnoreCase("lenta") &&
                         !velocidad.equalsIgnoreCase("media") &&
                         !velocidad.equalsIgnoreCase("rapida"));

                datosOK = true;
            } catch (IOException e) {
                System.out.println("Error leyendo datos");
            }
        }
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("PUNTOS VIDA: " + this.puntosVida);
        System.out.println("DAÑO: " + this.danio);
        System.out.println("VELOCIDAD: " + this.velocidad);
        System.out.println("----------------");
    }
}