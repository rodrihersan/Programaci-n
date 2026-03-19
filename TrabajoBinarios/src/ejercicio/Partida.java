package ejercicio;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Partida implements Serializable {
    private int id;
    private int idImpostor;
    private String mapa;
    private double duracion;
    private boolean victoriaImpostor;

    public int getId() { return id; }
    public int getIdImpostor() { return idImpostor; }
    public String getMapa() { return mapa; }
    public double getDuracion() { return duracion; }
    public boolean isVictoriaImpostor() { return victoriaImpostor; }

    public void pedirDatos() {
        this.id = generarSiguienteId();

        String[] mapasPermitidos = {"The Skeld", "Polus", "Airship"};
        this.mapa = Lecturas.leerOpcion("Introduce el mapa (The Skeld / Polus / Airship): ", mapasPermitidos);

        this.duracion = Lecturas.leerDoubleMayorQue("Introduce la duración en segundos: ", 0);

        boolean impostorValido = false;
        while (!impostorValido) {
            this.idImpostor = Lecturas.leerEntero("Introduce el ID del impostor: ");
            if (Jugador.existeId(this.idImpostor)) {
                impostorValido = true;
            } else {
                System.out.println("ERROR: No existe ningún jugador con ese ID.");
            }
        }

        this.victoriaImpostor = Lecturas.leerSiNo("¿Ha ganado el impostor?");
    }

    public void guardarPartida() {
        ArrayList<Partida> partidas = cargarPartidas();
        partidas.add(this);
        guardarTodas(partidas);
        System.out.println("Partida guardada correctamente.");
    }

    public static int generarSiguienteId() {
        return cargarPartidas().size() + 1;
    }

    public static ArrayList<Partida> cargarPartidas() {
        ArrayList<Partida> lista = new ArrayList<>();
        File f = new File("partidas.obj");
        if (!f.exists()) return lista;
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
                while (true) {
                    lista.add((Partida) ois.readObject());
                }
            } catch (EOFException | ClassNotFoundException e) {
                // Fin del fichero
            }
            ois.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("ERROR: No se pudo leer partidas.obj");
        }
        return lista;
    }

    public static void guardarTodas(ArrayList<Partida> partidas) {
        try {
            FileOutputStream fos = new FileOutputStream("partidas.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Partida p : partidas) {
                oos.writeObject(p);
            }
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("ERROR: No se pudo guardar partidas.obj");
        }
    }

    public String getDuracionFormateada() {
        int minutos = (int) (duracion / 60);
        int segundos = (int) (duracion % 60);
        return minutos + "m " + segundos + "s";
    }

    @Override
    public String toString() {
        return "Partida [id=" + id + ", mapa=" + mapa + ", impostor=" + idImpostor
                + ", duracion=" + getDuracionFormateada()
                + ", victoria impostor=" + (victoriaImpostor ? "Sí" : "No") + "]";
    }
}