package ejercicio6;

public class estudiante {
	 private int id;
	    private String nombre;
	    private int edad;
	    private int curso;
	    private double notaMedia;

	    public estudiante(int id, String nombre, int edad, int curso, double notaMedia) {

	        if (edad <= 18)
	            throw new IllegalArgumentException("Edad incorrecta");
	        if (curso < 1 || curso > 2)
	            throw new IllegalArgumentException("Curso incorrecto");
	        if (notaMedia < 0 || notaMedia > 10)
	            throw new IllegalArgumentException("Nota incorrecta");

	        this.id = id;
	        this.nombre = nombre;
	        this.edad = edad;
	        this.curso = curso;
	        this.notaMedia = notaMedia;
	    }

	    public boolean estaAprobado() {
	        return notaMedia >= 5;
	    }

	    public String clasificacionNota() {
	        if (notaMedia >= 9)
	            return "Sobresaliente";
	        else if (notaMedia >= 7)
	            return "Notable";
	        else if (notaMedia >= 6)
	            return "Bien";
	        else if (notaMedia >= 5)
	            return "Suficiente";
	        else
	            return "Insuficiente";
	    }

	    public boolean puedePasarCurso() {
	        return estaAprobado();
	    }

	    public int getId() {
	        return id;
	    }

	    @Override
	    public String toString() {
	        return "ID: " + id + " | " + nombre + " | Curso: " + curso +
	               " | Nota: " + notaMedia + " (" + clasificacionNota() + ")";
	    }
	}
