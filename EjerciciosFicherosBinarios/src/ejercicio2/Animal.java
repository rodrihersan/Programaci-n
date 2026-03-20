package ejercicio2;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Animal implements Serializable {
    private int id;
    private String nombre;
    private String especie;
    private int edad;
    private double peso;

    public void pedirDatos() {
        this.id = Lecturas.leerEntero("Introduce el id: ");
        this.nombre = Lecturas.leerString("Introduce el nombre: ");
        this.especie = Lecturas.leerString("Introduce la especie: ");
        this.edad = Lecturas.leerEntero("Introduce la edad: ");
        this.peso = Lecturas.leerDouble("Introduce el peso: ");
    }
    
    public void escribir(ArrayList<Animal> animales) {
    	try {
    		FileOutputStream fis = new FileOutputStream("animales.obj");
    		ObjectOutputStream oos = new ObjectOutputStream(fis);
    		
    		for(Animal a : animales) {
    			oos.writeObject
    		}
    	}
    	
    }

    public int getId() { 
    	return id; 
    	}
    
    public String getNombre() { 
    	return nombre; 
    	}
    
    public String getEspecie() { 
    	return especie; 
    	}
    
    public int getEdad() { 
    	return edad; 
    	}
    
    public double getPeso() { 
    	return peso; 
    	}
    
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Especie: " + especie
             + " | Edad: " + edad + " | Peso: " + peso + "kg";
    }
}