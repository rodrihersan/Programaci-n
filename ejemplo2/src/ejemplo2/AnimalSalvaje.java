package ejemplo2;

public class AnimalSalvaje extends Animal {
    private String habitat;

    public void pedirDatos() {
        super.pedirDatos();
        this.habitat = Lecturas.leerString("Introduce el habitat: ");
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Habitat: " + habitat);
    }

    public String getHabitat() { 
    	return habitat; 
    	}
}
