package modelo;

public class RecompensaDTO {
    private int id;
    private int pirataId;
    private double cantidad;
    private boolean estaVigente;

    public RecompensaDTO(int id, int pirataId, double cantidad, boolean estaVigente) {
        super();
        this.id = id;
        this.pirataId = pirataId;
        this.cantidad = cantidad;
        this.estaVigente = estaVigente;
    }

    public RecompensaDTO(int pirataId, double cantidad, boolean estaVigente) {
        super();
        this.pirataId = pirataId;
        this.cantidad = cantidad;
        this.estaVigente = estaVigente;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getPirataId() { return pirataId; }
    public void setPirataId(int pirataId) { this.pirataId = pirataId; }
    public double getCantidad() { return cantidad; }
    public void setCantidad(double cantidad) { this.cantidad = cantidad; }
    public boolean isEstaVigente() { return estaVigente; }
    public void setEstaVigente(boolean estaVigente) { this.estaVigente = estaVigente; }
}
