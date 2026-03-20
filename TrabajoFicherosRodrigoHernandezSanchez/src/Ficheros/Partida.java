package Ficheros;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Partida implements Serializable{
	private int id;
	private String nombreMapa;
	private double duracion;
	private boolean vitoriaImpostor;
	private int idImpostor;
	
	public void pedirDatos() {
		//this.id = 
				
		do {
			this.nombreMapa = Lecturas.leerString("Selecciona uno de los siguientes mapas: Skeld / Polus / Airship");
			if (this.nombreMapa.equalsIgnoreCase("Skeld") || this.nombreMapa.equalsIgnoreCase("Polus") || this.nombreMapa.equalsIgnoreCase("Airship")) {
				System.err.println("El nombre del mapa debe de ser Skeld / Polus / Airship.");
				}
		} while (this.nombreMapa.equalsIgnoreCase("Skeld") || this.nombreMapa.equalsIgnoreCase("Polus") || this.nombreMapa.equalsIgnoreCase("Airship"));
		
		
		}
	
	public void escribir(ArrayList<Partida> partidas) {
		try {
			FileOutputStream fis = new FileOutputStream("partidas.obj");
			ObjectOutputStream oos = new ObjectOutputStream(fis);
			
			for(Partida partida: partidas) {
				oos.writeObject(partida);
			}
			oos.close();
			fis.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
