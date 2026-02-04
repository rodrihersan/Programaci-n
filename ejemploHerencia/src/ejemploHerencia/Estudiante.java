package ejemploHerencia;

public class Estudiante extends Persona{
	private int creditos;
	
	public Estudiante() {
		super();
		this.creditos = 60;
	}
	
	public Estudiante(String nombre, int edad) {
		super(nombre,edad);
		this.creditos = 60;
	}
	
	public int getCreditos() {
		String n=super.nombre;
		return this.creditos;	
	}
	
	public String toString() {
		return super.toString() + 	"Creditos: " + this.creditos;
	}
}
