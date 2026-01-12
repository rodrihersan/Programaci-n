package ejercicio2;

public class empleado {
	private String nombre;
	private int permanencia;
	private double salario;
	
	public empleado(String nombre, int permanencia, double salario) {
		/*nombre = nuevoNombre;
		permanencia = nuevaPermanencia;
		salario = nuevoSalario;*/
		this.nombre = nombre;
		this.permanencia = permanencia;
		this.salario = salario;
	}

	public String clasificacion(){
		String clasificacion;
		
		if(permanencia <= 3) {
			clasificacion = "Principiante";
		}else if (permanencia >3 && permanencia <= 18) {
			clasificacion = "Intermedio";
		}else {
			clasificacion = "Senior";
		}
		return clasificacion;
		}
	
	/*OPCION 1*/
	
	public String getNombre() {
		return nombre;
	}
	
	public int getPermanencia() {
		return permanencia;
	}
	
	public double getSalario() {
		return salario;
	}
	
	/*OPCION 2*/
	public String toString() {
		return nombre + "  " + permanencia + " " + salario;
		}
	
	public double calcularNuevoSalario(double porcentaje) {
		salario = salario * (porcentaje/100);
		return salario;
		}
	}
