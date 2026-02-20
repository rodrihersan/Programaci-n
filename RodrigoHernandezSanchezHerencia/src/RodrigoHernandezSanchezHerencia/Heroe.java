package RodrigoHernandezSanchezHerencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Heroe extends Personaje{
	private String organizacion;
	private boolean identidadSecreta;
	private String[] misiones = new String[3];
	
	public void pedirDatos(ArrayList<Personaje> personajes) {
        super.pedirDatos(personajes);
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        
        boolean datosOK = false;
        do {
            try {
                do {
                    System.out.println("--- DATOS DE HÉROE ---");
                    System.out.print("Introduce la organizacion (Avengers/XMen): ");
                    this.organizacion = leer.readLine();
                    if (!organizacion.equalsIgnoreCase("Avengers") &&
                        !organizacion.equalsIgnoreCase("XMen"))
                        System.out.println("Organizacion no valida");
                } while (!organizacion.equalsIgnoreCase("Avengers") &&
                         !organizacion.equalsIgnoreCase("XMen")); 
                
                System.out.println("Tiene identidad secreta? (S/N)");
                String identidadSecreta = leer.readLine();
                char respuesta = identidadSecreta.charAt(0);
                datosOK = true;
            } catch (IOException e) {
                System.out.println("Error leyendo datos");
            }
        }while (!datosOK);
    }
	
	public boolean getIdentidadSecreta() {
		return false;
	}
	
	public void mostrarDatos() {
		super.mostrarDatos();
        System.out.println("identidad secreta: " + this.identidadSecreta);
        if (identidadSecreta) {
            System.out.println("En equipo activo: si");
        } else {
            System.out.println("En equipo activo: no");
        }
    }
}
