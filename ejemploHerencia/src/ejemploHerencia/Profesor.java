package ejemploHerencia;

public class Profesor extends Persona{
	private String departamento;
	
	public Profesor(String nombre, int edad, String departamento) {
		super(nombre, edad);
		this.departamento = departamento;
	}
		
	public String toString() {
			return super.toString() + " DEP: " + this.departamento;
		}
	}
