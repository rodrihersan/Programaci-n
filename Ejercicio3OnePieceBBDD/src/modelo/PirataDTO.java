package modelo;

public class PirataDTO {
    private int id;
    private String nombre;
    private String frutaDelDiablo;
    private String fechaNacimiento;
    private boolean estaActivo;
    private int islaId;

    public PirataDTO(int id, String nombre, String frutaDelDiablo, String fechaNacimiento, boolean estaActivo, int islaId) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.frutaDelDiablo = frutaDelDiablo;
        this.fechaNacimiento = fechaNacimiento;
        this.estaActivo = estaActivo;
        this.islaId = islaId;
    }

    public PirataDTO(String nombre, String frutaDelDiablo, String fechaNacimiento, boolean estaActivo, int islaId) {
        super();
        this.nombre = nombre;
        this.frutaDelDiablo = frutaDelDiablo;
        this.fechaNacimiento = fechaNacimiento;
        this.estaActivo = estaActivo;
        this.islaId = islaId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getFrutaDelDiablo() { return frutaDelDiablo; }
    public void setFrutaDelDiablo(String frutaDelDiablo) { this.frutaDelDiablo = frutaDelDiablo; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public boolean isEstaActivo() { return estaActivo; }
    public void setEstaActivo(boolean estaActivo) { this.estaActivo = estaActivo; }
    public int getIslaId() { return islaId; }
    public void setIslaId(int islaId) { this.islaId = islaId; }
}