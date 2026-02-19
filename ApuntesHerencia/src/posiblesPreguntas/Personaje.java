package posiblesPreguntas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Personaje {
    private int id;
    private String nombre;
    private int nivelPoder;
    private String bando;
    private boolean enEquipoActivo;

    public void pedirDatos(ArrayList<Personaje> lista) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        Random rand = new Random();
        int idGenerado = -1;
        do {
            idGenerado = rand.nextInt(9000) + 1000;
        } while (estaRepetido(lista, idGenerado));
        this.id = idGenerado;
        System.out.println("ID asignado: " + this.id);

        boolean datosOK = false;
        while (!datosOK) {
            try {
                System.out.print("Introduce el nombre: ");
                this.nombre = leer.readLine();

                boolean poderOK = false;
                while (!poderOK) {
                    try {
                        System.out.print("Introduce el nivel de poder (1-10): ");
                        this.nivelPoder = Integer.parseInt(leer.readLine());
                        if (nivelPoder < 1 || nivelPoder > 10)
                            System.out.println("Tiene que ser entre 1 y 10");
                        else
                            poderOK = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Solo puedes introducir numeros");
                    }
                }

                do {
                    System.out.print("Introduce el bando (heroe/villano): ");
                    this.bando = leer.readLine();
                    if (!bando.equalsIgnoreCase("heroe") && !bando.equalsIgnoreCase("villano"))
                        System.out.println("Tiene que ser heroe o villano");
                } while (!bando.equalsIgnoreCase("heroe") && !bando.equalsIgnoreCase("villano"));

                this.enEquipoActivo = false;
                datosOK = true;
            } catch (IOException e) {
                System.out.println("Error leyendo datos");
            }
        }
    }

    private boolean estaRepetido(ArrayList<Personaje> lista, int idGenerado) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == idGenerado)
                return true;
        }
        return false;
    }

    public void mostrarDatos() {
        System.out.println("ID: " + this.id);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Nivel de poder: " + this.nivelPoder);
        System.out.println("Bando: " + this.bando);
        if (enEquipoActivo) {
            System.out.println("En equipo activo: si");
        } else {
            System.out.println("En equipo activo: no");
        }
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getNivelPoder() { return nivelPoder; }
    public String getBando() { return bando; }
    public boolean isEnEquipoActivo() { return enEquipoActivo; }
    public void setEnEquipoActivo(boolean enEquipoActivo) { this.enEquipoActivo = enEquipoActivo; }
    public void setNivelPoder(int nivelPoder) { this.nivelPoder = nivelPoder; }
    public void setBando(String bando) { this.bando = bando; }
}
