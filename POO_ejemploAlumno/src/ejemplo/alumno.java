package ejemplo;

public class alumno {
	private String nombre;
	private int nacimiento;
	private double notaMedia;
	
	public Alumno (String nuevoNombre, int nuevoNacimiento, double nuevaNota) {
		nombre= nuevoNombre;
		nacimiento = nuevoNacimiento;
		notaMedia = nuevaNota;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public int getNacimiento() {
		return nacimiento;
	}
	
	public double getnotaMedia() {
		return notaMedia;
	}
	
	public String toString () {
		return nombre + " "+  nacimiento + " "+ notaMedia;
	}
}

