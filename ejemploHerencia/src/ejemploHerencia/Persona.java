package ejemploHerencia;

public class Persona {
	protected String nombre;
	private int edad;
	
	public Persona(String nombre, int edad) {
		this.nombre=nombre;
		this.edad=edad;
	}
	
	public Persona() {
		
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String toString() {
		return "nombre: "+ this.nombre + "Edad: "+this.edad;
	}

}
