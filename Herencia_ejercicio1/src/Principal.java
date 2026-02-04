import java.io.IOException;
import java.util.ArrayList;

public class Principal{

	public static void main(String[] args) throws IOException {
		ArrayList<Coche> coches = new ArrayList<Coche>();
		ArrayList<Moto> motos = new ArrayList<Moto>();
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		
		//sin menu para simplificar
		//creamos los coches
		
		//case 1
		for(int i= 0; i<5; i++) {
			System.out.println("Introduce los datos del coche " + (i+1));
			Coche c = new Coche();
			c.pedirDatos(i+1);
			coches.add(c);
		}
		
		//case 2
		for(int i = 0; i<5; i++) {
			System.out.println("Introduce los datos del moto " + (i+1));
			Moto m = new Moto();
			m.pedirDatos(i+1);
			motos.add(m);
		}
		
		//case3
		for(Coche c:coches) {
			c.mostrarDatos();
		}
		
		//case4
		for(Moto m:motos) {
			m.mostrarDatos();
		}
	}
}