package RodrigoHernandezSanchezHerencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;


public class Personaje {
	private String alias;
	private String nombre;
	private int nivelPoder;
	private LocalDate fechaRegistro;
	
	public void pedirDatos(ArrayList<Personaje> personajes) {
    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

	boolean datosOK = false;
    while (!datosOK) {
        try {
        	
            System.out.print("Introduce el alias: ");
            this.alias = leer.readLine();

            System.out.print("Introduce el nombre: ");
            this.nombre = leer.readLine();

            boolean poderOK = false;
            while (!poderOK) {
                try {
                	
                	do {
                		System.out.print("Introduce el nivel de poder (1-100): ");
                		this.nivelPoder = Integer.parseInt(leer.readLine());
                		if (nivelPoder < 1 || nivelPoder > 100) {
                			System.out.println("Tiene que ser entre 1 y 100");
                		}else {
                			poderOK = true;
                		}
                	}while(nivelPoder <1 || nivelPoder > 100);
                	
                	System.out.print("Introduce la fecha (dd/MM/yyyy): ");
					DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					String fechaTemp = leer.readLine();
					fechaRegistro = LocalDate.parse(fechaTemp, formato);
					datosOK = true; 
                } catch (IOException e) {
                	System.out.println("Has introducido mal algún dato, crack");
    				e.printStackTrace();
                }
            }
        }catch (IOException e) {
        	System.out.println("Has introducido mal algún dato, crack");
			e.printStackTrace();
    }
	}
	}
	
	private boolean estaRepetido(ArrayList<Personaje> personajes, String aliasDado) {
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i).getAlias() == aliasDado)
                return true;
        }
        return false;
    }
	
	
	public void mostrarDatos() {
        System.out.println("Alias: " + this.alias);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Nivel de poder: " + this.nivelPoder);
        System.out.println("fecha registro: " + this.fechaRegistro);
	}
        
    public String getAlias() { return alias; }

}
