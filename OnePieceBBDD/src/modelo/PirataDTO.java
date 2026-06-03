package modelo;

import java.time.LocalDate;
import java.time.Period;

public class PirataDTO {
	private int id;
    private String nombre;
    private String frutaDiablo;
    private String [] tripulacion;	
    private LocalDate fechaNacimiento;
    private String islaOrigen;
    private boolean activo;
    
    public  PirataDTO(int id, String nombre, String frutaDiablo, String [] tripulacion, LocalDate fechaNacimiento, String islaOrigen, boolean activo) {
    	this.id = id;
        this.nombre = nombre;
        this.frutaDiablo = frutaDiablo;
        this.tripulacion = tripulacion;
        this.fechaNacimiento = fechaNacimiento;
        this.islaOrigen = islaOrigen;
        this.activo = activo;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFrutaDiablo() {
		return frutaDiablo;
	}

	public void setFrutaDiablo(String frutaDiablo) {
		this.frutaDiablo = frutaDiablo;
	}

	public String[] getTripulacion() {
		return tripulacion;
	}

	public void setTripulacion(String[] tripulacion) {
		this.tripulacion = tripulacion;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getIslaOrigen() {
		return islaOrigen;
	}

	public void setIslaOrigen(String islaOrigen) {
		this.islaOrigen = islaOrigen;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
    
    
    	
 
}


