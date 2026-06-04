package modelo;

public class PedidoDTO {
    private int id;
    private String fecha;
    private double total;

    public PedidoDTO(int id, String fecha, double total) {
        super();
        this.id = id;
        this.fecha = fecha;
        this.total = total;
    }

    public PedidoDTO(String fecha, double total) {
        super();
        this.fecha = fecha;
        this.total = total;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}