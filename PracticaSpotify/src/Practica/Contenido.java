package Practica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Contenido {
	private int id; //positivo aleatorio 1000-9999 y no repetido
	private String titulo;
	private int minutos; // entre 1-180
	private String categoria; //valores: "música", "podcast", "audiolibro","meditación"
	private int reproduccionesTotales; // entero - cuántas veces se ha reproducido
	private boolean activa; // indica si el contenido está en la playlist de reproducción actual
	
	public void pedirDatos(Contenido[] contenidos, int pos) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		
		Random rand = new Random();
		int idGenerado = -1;
		do {
			idGenerado = rand.nextInt(9000) + 1000;
			System.err.println("He generado el numero: " + idGenerado);
		} while (estaRepetido(contenidos, pos, idGenerado));
		System.out.println("Asignado el id " + idGenerado);
		this.id = idGenerado;
		boolean datosOk = false;
		
		do {
			try {
				System.out.print("Introduce el título del contenido: ");
				this.titulo = leer.readLine();
				do {
					System.out.print("Introduce la duración en minutos (1-180): ");
					this.minutos = Integer.parseInt(leer.readLine());
					if(!(minutos < 1 || minutos >180)) {
						System.out.println("Tiempo incorrecto");
					}
					}while (minutos < 1 || minutos > 180);

	                do {
	                	System.out.print("Introduce la categoría (música-podcast-audiolibro-meditación): ");
	                    this.categoria = leer.readLine().toLowerCase();
	                    if (!categoria.equals("música") && !categoria.equals("podcast") &&!categoria.equals("audiolibro") && !categoria.equals("meditación")) {
	                    	System.out.println("Introduce una opción válida");
	                    }
	                } while (!categoria.equals("música") &&!categoria.equals("podcast") &&!categoria.equals("audiolibro") &&!categoria.equals("meditación"));

	                System.out.print("Introduce el número de reproducciones totales: ");
	                this.reproduccionesTotales = Integer.parseInt(leer.readLine());
	                this.activa = false;
	                datosOk = true;
	               	} catch (NumberFormatException | IOException e) {
	               		System.err.println("Error en los datos. Inténtalo de nuevo.");
	               	}
			} while (!datosOk);
	 }
	
	private boolean estaRepetido(Contenido[] contenidos, int pos, int idGenerado) {
		for (int i = 0; i < (pos - 1); i++) {
			if (contenidos[i].getId() == idGenerado) {
				System.err.println("El numero esta repetido");
				return true;
			}
		}
		return false;
	}
	
	public int getId() {
        return id;
    }

    public void mostrarDatos() {
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Duración: " + minutos);
        System.out.println("Categoría: " + categoria);
        System.out.println("Reproducciones: " + reproduccionesTotales);
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public boolean isActiva() {
        return activa;
    }
    
    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
    public int getMinutos() {
        return minutos;
    }
    
    public static int contarElementosPlaylist(Contenido[] contenidos, int pos) {
        int contador = 0;
        for (int i = 0; i < pos; i++) {
            if (contenidos[i].isActiva()) {
                contador++;
            }
        }
        return contador;
    }

    public static int calcularDuracionPlaylist(Contenido[] contenidos, int pos) {
        int duracion = 0;
        for (int i = 0; i < pos; i++) {
            if (contenidos[i].isActiva()) {
                duracion += contenidos[i].getMinutos();
            }
        }
        return duracion;
    }
}
