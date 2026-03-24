package ejemplo2;

public class AnimalDomestico extends Animal {
    private String dueño;

    public void pedirDatos() {
        super.pedirDatos();
        this.dueño = Lecturas.leerString("Introduce el nombre del dueño: ");
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Dueño: " + dueño);
    }

    public String getDueño() { 
    	return dueño; 
    	}
}
