package modelo;

public class CapturaDTO {
    private int id;
    private int pirataId;
    private String lugarCaptura;
    private String fechaCaptura;
    private double recompensaCobrada;

    public CapturaDTO(int id, int pirataId, String lugarCaptura, String fechaCaptura, double recompensaCobrada) {
        super();
        this.id = id;
        this.pirataId = pirataId;
        this.lugarCaptura = lugarCaptura;
        this.fechaCaptura = fechaCaptura;
        this.recompensaCobrada = recompensaCobrada;
    }

    public CapturaDTO(int pirataId, String lugarCaptura, double recompensaCobrada) {
        super();
        this.pirataId = pirataId;
        this.lugarCaptura = lugarCaptura;
        this.recompensaCobrada = recompensaCobrada;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getPirataId() { return pirataId; }
    public void setPirataId(int pirataId) { this.pirataId = pirataId; }
    public String getLugarCaptura() { return lugarCaptura; }
    public void setLugarCaptura(String lugarCaptura) { this.lugarCaptura = lugarCaptura; }
    public String getFechaCaptura() { return fechaCaptura; }
    public void setFechaCaptura(String fechaCaptura) { this.fechaCaptura = fechaCaptura; }
    public double getRecompensaCobrada() { return recompensaCobrada; }
    public void setRecompensaCobrada(double recompensaCobrada) { this.recompensaCobrada = recompensaCobrada; }
}
