package RodrigoHernandezSanchezHerencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Villano extends Personaje{
	private String[] archienemigo = new String[5];
	private int crimenesCometidos;
	
	public void pedirDatos(ArrayList<Personaje> lista) {
        super.pedirDatos(lista);
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        boolean datosOK = false;
        while (!datosOK) {
            try {        
                System.out.print("Introduce los crimenes cometidos: ");
                this.crimenesCometidos =Integer.parseInt(leer.readLine());
                datosOK = true;
            } catch (IOException e) {
                System.out.println("Error leyendo datos");
            }
        }
    }
	
	 public void mostrarDatos() {
	        super.mostrarDatos();
	        System.out.println("Crimenes: " + this.crimenesCometidos);
	    }
}
