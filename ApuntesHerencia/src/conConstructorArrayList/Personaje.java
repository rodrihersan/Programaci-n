package conConstructorArrayList;

public class Personaje {
    private int id;
    private String nombre;
    private int nivelPoder;
    private String bando;
    private boolean enEquipoActivo;

    public Personaje(int id, String nombre, int nivelPoder, String bando) {
        this.id = id;
        this.nombre = nombre;
        this.nivelPoder = nivelPoder;
        this.bando = bando;
        this.enEquipoActivo = false;
    }

    public void mostrarDatos() {
        System.out.println("ID: " + this.id);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Nivel de poder: " + this.nivelPoder);
        System.out.println("Bando: " + this.bando);
        if (enEquipoActivo) {
            System.out.println("En equipo activo: si");
        } else {
            System.out.println("En equipo activo: no");
        }
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getNivelPoder() { return nivelPoder; }
    public String getBando() { return bando; }
    public boolean isEnEquipoActivo() { return enEquipoActivo; }
    public void setEnEquipoActivo(boolean enEquipoActivo) { this.enEquipoActivo = enEquipoActivo; }
}