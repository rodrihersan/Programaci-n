package ejemplo;

public class Alumno {
	private String nombre;
	private int nacimiento;
	private double notaMedia;
	
		public Alumno(String nuevoNombre, int nuevoNacimiento, 
				double nuevaNota) {
			nombre = nuevoNombre;
			nacimiento = nuevoNacimiento;
			notaMedia = nuevaNota;
			
		}
		
		public Alumno(String nuevoNombre, int nuevoNacimiento) {
			nombre = nuevoNombre;
			nacimiento = nuevoNacimiento;
			
		}
		
		public Alumno() {
			
		}
		
		
		public int calcularEdadActual() {
			return 2026 - nacimiento;
		}
		
		public void hasAprobado() {
			if(notaMedia >= 5)
				System.out.println("Has aprobado");
			else
				System.out.println("Has suspendido");
		}
		
		public String getNombre() {
			return nombre;
		}
		
		public int getNacimiento() {
			return nacimiento;
		}
		
		public double getnotaMedia() {
			return notaMedia;
		}
		
		public String toString() {
			return nombre + "  " + nacimiento + " " + notaMedia;
			
		}

	}