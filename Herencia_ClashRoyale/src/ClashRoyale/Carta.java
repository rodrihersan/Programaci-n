package ClashRoyale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Carta {
    private int id;
    private String nombre;
    private int costeElixir;
    private String rareza;
    private int cantidadDisponible;
    private boolean usadaEnMazo;

    public void pedirDatos(ArrayList<Carta> lista) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        Random rand = new Random();
        int idGenerado = -1;
        do {
            idGenerado = rand.nextInt(9000) + 1000;
        } while (estaRepetido(lista, idGenerado));
        this.id = idGenerado;

        boolean datosOK = false;
        while (!datosOK) {
            try {
                System.out.print("Introduce el nombre de la carta: ");
                this.nombre = leer.readLine();

                boolean elixirOK = false;
                while (!elixirOK) {
                    try {
                        System.out.print("Introduce el coste de elixir de la carta (1-10): ");
                        this.costeElixir = Integer.parseInt(leer.readLine());
                        if (costeElixir < 1 || costeElixir > 10)
                            System.out.println("Tiene que ser entre 1 y 10");
                        else
                            elixirOK = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Solo puedes introducir numeros");
                    }
                }

                do {
                    System.out.print("Introduce la rareza de la carta (comun/especial/epica/legendaria): ");
                    this.rareza = leer.readLine();
                    if (!rareza.equalsIgnoreCase("comun") &&
                        !rareza.equalsIgnoreCase("especial") &&
                        !rareza.equalsIgnoreCase("epica") &&
                        !rareza.equalsIgnoreCase("legendaria"))
                        System.out.println("Introduce una opcion valida");
                } while (!rareza.equalsIgnoreCase("comun") &&
                         !rareza.equalsIgnoreCase("especial") &&
                         !rareza.equalsIgnoreCase("epica") &&
                         !rareza.equalsIgnoreCase("legendaria"));

                boolean cantidadOK = false;
                while (!cantidadOK) {
                    try {
                        System.out.print("Introduce el numero de copias que tienes de esa carta: ");
                        this.cantidadDisponible = Integer.parseInt(leer.readLine());
                        if (cantidadDisponible < 0)
                            System.out.println("No puede ser negativo");
                        else
                            cantidadOK = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Solo puedes introducir numeros");
                    }
                }

                this.usadaEnMazo = false;
                datosOK = true;
            } catch (IOException e) {
                System.out.println("Error leyendo datos");
            }
        }
    }

    private boolean estaRepetido(ArrayList<Carta> lista, int idGenerado) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == idGenerado)
                return true;
        }
        return false;
    }

    public void mostrarDatos() {
        System.out.println("ID CARTA: " + this.id);
        System.out.println("NOMBRE: " + this.nombre);
        System.out.println("ELIXIR: " + this.costeElixir);
        System.out.println("RAREZA: " + this.rareza);
        System.out.println("CANTIDAD: " + this.cantidadDisponible);
        if (usadaEnMazo) {
            System.out.println("MAZO ACTIVO: si");
        } else {
            System.out.println("MAZO ACTIVO: no");
        }
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getCosteElixir() { return costeElixir; }
    public String getRareza() { return rareza; }
    public boolean isUsadaEnMazo() { return usadaEnMazo; }
    public void setUsadaEnMazo(boolean usadaEnMazo) { this.usadaEnMazo = usadaEnMazo; }
}
