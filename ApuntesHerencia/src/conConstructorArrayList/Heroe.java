package conConstructorArrayList;

public class Heroe extends Personaje {
    private String organizacion;
    private int misiones;

    public Heroe(int id, String nombre, int nivelPoder, String bando, String organizacion, int misiones) {
        super(id, nombre, nivelPoder, bando);
        this.organizacion = organizacion;
        this.misiones = misiones;
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Organizacion: " + this.organizacion);
        System.out.println("Misiones completadas: " + this.misiones);
        System.out.println("----------------------------");
    }
}