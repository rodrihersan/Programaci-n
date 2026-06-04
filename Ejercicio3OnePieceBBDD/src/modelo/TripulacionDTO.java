package modelo;

public class TripulacionDTO {
    private long id;
    private String nombre;
    private String barco;
    private boolean estaActiva;

    public TripulacionDTO(long id, String nombre, String barco, boolean estaActiva) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.barco = barco;
        this.estaActiva = estaActiva;
    }

    public TripulacionDTO(String nombre, String barco, boolean estaActiva) {
        super();
        this.nombre = nombre;
        this.barco = barco;
        this.estaActiva = estaActiva;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getBarco() { return barco; }
    public void setBarco(String barco) { this.barco = barco; }
    public boolean isEstaActiva() { return estaActiva; }
    public void setEstaActiva(boolean estaActiva) { this.estaActiva = estaActiva; }
}
