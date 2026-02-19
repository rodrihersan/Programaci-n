package posiblesPreguntas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Villano extends Personaje {
    private String peligrosidad;
    private String arma;

    public void pedirDatos(ArrayList<Personaje> lista) {
        super.pedirDatos(lista);
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        boolean datosOK = false;
        while (!datosOK) {
            try {
                do {
                    System.out.print("Introduce la peligrosidad (bajo/medio/alto): ");
                    this.peligrosidad = leer.readLine();
                    if (!peligrosidad.equalsIgnoreCase("bajo") &&
                        !peligrosidad.equalsIgnoreCase("medio") &&
                        !peligrosidad.equalsIgnoreCase("alto"))
                        System.out.println("Tiene que ser bajo, medio o alto");
                } while (!peligrosidad.equalsIgnoreCase("bajo") &&
                         !peligrosidad.equalsIgnoreCase("medio") &&
                         !peligrosidad.equalsIgnoreCase("alto"));

                System.out.print("Introduce el arma principal: ");
                this.arma = leer.readLine();

                datosOK = true;
            } catch (IOException e) {
                System.out.println("Error leyendo datos");
            }
        }
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Peligrosidad: " + this.peligrosidad);
        System.out.println("Arma principal: " + this.arma);
        System.out.println("----------------------------");
    }

    public String getPeligrosidad() { return peligrosidad; }
    public String getArma() { return arma; }
}
