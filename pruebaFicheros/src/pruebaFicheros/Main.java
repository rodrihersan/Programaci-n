package pruebaFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Introduce tu nombre: ");
        String nombre = leer.readLine();
        
        System.out.print("Introduce tu edad: ");
        int edad = Integer.parseInt(leer.readLine());
        
        System.out.print("Introduce tu ciudad: ");
        String ciudad = leer.readLine();
        
            File f1 = new File("C:\\Users\\alumnofp\\Desktop\\datos.txt");
            FileWriter fw = new FileWriter(f1);
            PrintWriter pw = new PrintWriter(fw);
            
            pw.print(nombre+" - "+ edad + " - " + ciudad);
            
            pw.flush();
            pw.close();
            fw.close();
            
	}
}
		 
		 