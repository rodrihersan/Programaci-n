package ejemploHerencia;

public class Principal {

	public static void main(String[] args) {
		Estudiante e = new Estudiante("Adrian",27);
		Persona p = new Persona("Antonio", 20);
		System.out.println(p.getNombre());
		System.out.println(e.getNombre() + " : " + e.getCreditos() + " creditos.");
		
		Estudiante p1 = new Estudiante();
		System.out.println(p1.getNombre());
		
		System.out.println(e.toString());
		
		Profesor prof = new Profesor("Sonia", 22, "Informatica");
		System.out.println(prof.toString());

	}
}