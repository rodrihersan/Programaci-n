package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Introduce Nº de expediente: ");
		int expediente = Integer.parseInt(leer.readLine());
        
		System.out.print("Introduce tu nombre: ");
        String nombre = leer.readLine();
        
        boolean encontrado = false;
        int notas ;
        do {
        	System.out.println("Escribe las notas: ");
        	notas = Integer.parseInt(leer.readLine());
        	encontrado = true;
        }while (notas < 0 || notas > 10 && !encontrado);	
        
        
        File f1 = new File("C:\\Users\\alumnofp\\Desktop\\programacion .txt\\alumnos.txt");
        FileWriter fw = new FileWriter(f1);
        PrintWriter pw = new PrintWriter(fw);
        
        pw.print(expediente+" - "+ nombre + " - " + notas);
        
        pw.flush();
        pw.close();
        fw.close();
	}
}