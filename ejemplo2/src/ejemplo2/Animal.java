package ejemplo2;

public class Animal {
    protected String nombre;
    protected String especie;
    protected double peso;

    protected void pedirDatos() {
    }

    protected void mostrarDatos() {
        System.out.println("----------------");
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Peso: " + peso);
    }

    public double getPeso() { return peso; }
    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
}