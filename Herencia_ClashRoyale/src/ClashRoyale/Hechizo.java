package ClashRoyale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Hechizo extends Carta {
    private int danioArea;
    private double radioJuego;
    private int duracionEfecto;

    public void pedirDatos(ArrayList<Carta> lista) {
        super.pedirDatos(lista);
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        boolean datosOK = false;
        while (!datosOK) {
            try {
                boolean danioOK = false;
                while (!danioOK) {
                    try {
                        System.out.print("Introduce el daño de area del hechizo: ");
                        this.danioArea = Integer.parseInt(leer.readLine());
                        if (danioArea < 0)
                            System.out.println("No puede ser negativo");
                        else
                            danioOK = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Solo puedes introducir numeros");
                    }
                }

                boolean radioOK = false;
                while (!radioOK) {
                    try {
                        System.out.print("Introduce el radio de juego del hechizo: ");
                        this.radioJuego = Double.parseDouble(leer.readLine());
                        if (radioJuego < 0)
                            System.out.println("No puede ser negativo");
                        else
                            radioOK = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Solo puedes introducir numeros");
                    }
                }

                boolean duracionOK = false;
                while (!duracionOK) {
                    try {
                        System.out.print("Introduce la duracion del efecto en segundos: ");
                        this.duracionEfecto = Integer.parseInt(leer.readLine());
                        if (duracionEfecto < 0)
                            System.out.println("No puede ser negativo");
                        else
                            duracionOK = true;
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
        System.out.println("DAÑO AREA: " + this.danioArea);
        System.out.println("RADIO JUEGO: " + this.radioJuego);
        System.out.println("DURACION EFECTO: " + this.duracionEfecto);
        System.out.println("----------------");
    }
}
