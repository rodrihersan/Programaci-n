package vista;

import java.util.ArrayList;
import controlador.SesionController;
import modelo.SesionDTO;
import utils.Lecturas;

public class VistaSesion {
	SesionController sesionController = new SesionController();
	
	public void menuSesiones(){
		boolean salir = false;
		do {
			System.out.println("=== Gestion Sesiones ===");
			System.out.println("1. Listar Sesiones");
			System.out.println("2. Borrar Sesiones");
			System.out.println("3. Anadir una Sesion ");
			System.out.println("0. Salir al menu principal");
			int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 3);
			
			switch (opcion) {
			
			case 1:System.out.println("Mostras Sesiones");mostrarSesiones();break;
			case 2:System.out.println("Borrar Sesiones");borrarSesion();break;
			case 3:System.out.println("Anadir Sesiones");programarSesion();break;
			case 0:salir = true;break;
			}
		} while (!salir);
	}
	
	public void mostrarSesiones() {
		ArrayList<SesionDTO> lista = sesionController.obtenerTodasLasSesiones();

		System.out.println("---Sesiones---");
		System.out.println("--------------");
		if (lista.isEmpty()) {
            System.out.println("No hay peliculas registradas.");
        } else {
        	for (SesionDTO sesiones : lista) {
        		System.out.println(sesiones.getId() + " - " + sesiones.getTituloPelicula() + " - " + sesiones.getNumeroSala() + " - " + sesiones.getFecha() + " - " + sesiones.getHora() + " - " + sesiones.getPrecio() + " - " + sesiones.getAsientosDisponibles());
        		}
        	}
		}
	
	public void borrarSesion() {
		int id = Lecturas.leerEntero("Introduce el id de la sesion que quieres borrar:");
		boolean borradoOK = sesionController.borrar(id);

		if (borradoOK) {
			System.out.println("Sesion borrada correctamente");
		} else {
			System.out.println("Error al borrar la sesion");
		}
	}
	
	private void programarSesion() {
		System.out.println("--- Programar nueva sesion ---");

		int idPelicula = Lecturas.leerEntero("Id de la pelicuula: ");
		int idSala = Lecturas.leerEntero("Id de la sala: ");
		String fecha = Lecturas.leerString("Fecha: ");
		String hora = Lecturas.leerString("Hora: ");
		double precio = Lecturas.leerDouble("Precio de la entrada: ");

		boolean resultado = sesionController.programarSesion(idPelicula, idSala, fecha, hora, precio);
		if (!resultado) {
			System.out.println("No se pudo programar la sesion.");
		}
	}
}