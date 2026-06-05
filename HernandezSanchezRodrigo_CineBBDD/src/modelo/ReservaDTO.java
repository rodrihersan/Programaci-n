package modelo;

public class ReservaDTO {
    private int id;
    private String tituloPelicula;
    private String hora;
    private String nombreCliente;
    private int numEntradas;
    private double total;

    public ReservaDTO(int id, String tituloPelicula, String hora, int numEntradas, double total) {
        this.id = id;
        this.tituloPelicula = tituloPelicula;
        this.hora = hora;
        this.numEntradas = numEntradas;
        this.total = total;
    }
    
    public ReservaDTO(String tituloPelicula, String hora, int numEntradas, double total) {
        this.tituloPelicula = tituloPelicula;
        this.hora = hora;
        this.numEntradas = numEntradas;
        this.total = total;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTituloPelicula() {
		return tituloPelicula;
	}

	public void setTituloPelicula(String tituloPelicula) {
		this.tituloPelicula = tituloPelicula;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getNumEntradas() {
		return numEntradas;
	}

	public void setNumEntradas(int numEntradas) {
		this.numEntradas = numEntradas;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
    
    
}
