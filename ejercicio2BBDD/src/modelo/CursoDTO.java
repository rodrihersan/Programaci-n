package modelo;

public class CursoDTO {
    private int id;
    private String nombre;
    private int duracionHoras;
    private double precio;

    public CursoDTO(int id, String nombre, int duracionHoras, double precio) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
        this.precio = precio;
    }

    public CursoDTO(String nombre, int duracionHoras, double precio) {
        super();
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
        this.precio = precio;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getDuracionHoras() { return duracionHoras; }
    public void setDuracionHoras(int duracionHoras) { this.duracionHoras = duracionHoras; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}