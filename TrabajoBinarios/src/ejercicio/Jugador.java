package ejercicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Jugador {
    private int id;
    private String nombre;
    private int puntos;
    private int partidas;

    public void pedirDatos() {
        boolean idValido = false;
        while (!idValido) {
            this.id = Lecturas.leerEntero("Introduce el ID del jugador: ");
            if (this.id < 0) {
                System.out.println("ERROR: El ID no puede ser negativo.");
            } else if (existeId(this.id)) {
                System.out.println("ERROR: Ya existe un jugador con ese ID.");
            } else {
                idValido = true;
            }
        }
        this.nombre = Lecturas.leerString("Introduce el nombre del jugador: ");
        this.puntos = Lecturas.leerEntero("Introduce los puntos iniciales: ");
        while (this.puntos < 0) {
            System.out.println("ERROR: Los puntos no pueden ser negativos.");
            this.puntos = Lecturas.leerEntero("Introduce los puntos iniciales: ");
        }
        this.partidas = Lecturas.leerEntero("Introduce las partidas jugadas: ");
        while (this.partidas < 0) {
            System.out.println("ERROR: Las partidas no pueden ser negativas.");
            this.partidas = Lecturas.leerEntero("Introduce las partidas jugadas: ");
        }
    }
    
    public static ArrayList<Jugador> cargarTodos() {
        ArrayList<Jugador> lista = new ArrayList<>();
        File f = new File("jugadores.txt");
        if (!f.exists()) return lista;
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 4) {
                    Jugador j = new Jugador();
                    j.id = Integer.parseInt(partes[0]);
                    j.nombre = partes[1];
                    j.puntos = Integer.parseInt(partes[2]);
                    j.partidas = Integer.parseInt(partes[3]);
                    lista.add(j);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("ERROR: No se pudo leer jugadores.txt");
        }
        return lista;
    }

    public static boolean existeId(int id) {
        ArrayList<Jugador> lista = cargarTodos();
        for (Jugador j : lista) {
            if (j.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static Jugador buscarPorId(int id) {
        ArrayList<Jugador> lista = cargarTodos();
        for (Jugador j : lista) {
            if (j.getId() == id) {
                return j;
            }
        }
        return null;
    }
    
    public int getId() { 
    	return id; 
    	}
    
    public String getNombre() { 
    	return nombre; 
    	}
    
    public int getPuntos() { 
    	return puntos; 
    	}
    
    public int getPartidas() { 
    	return partidas; 
    	}

    @Override
    public String toString() {
        return "Jugador [id=" + id + ", nombre=" + nombre + ", puntos=" + puntos + ", partidas=" + partidas + "]";
    }
}