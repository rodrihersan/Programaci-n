	package vista;

import java.util.ArrayList;
import controlador.ReservaController;
import modelo.ReservaDTO;
import utils.Lecturas;

public class VistaReserva {
	ReservaController reservaController = new ReservaController();
	
	public void menuReservas(){
		boolean salir = false;
		do {
			System.out.println("=== Gestion Reservas ===");
			System.out.println("1. Listar reservas");
			System.out.println("2. Realizar reserva");
			System.out.println("0. Volver");
			int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 2);
			
			switch (opcion) {
			
			case 1:System.out.println("Listar reservas");verTodasLasReservas();break;			
			case 2:System.out.println("Realizar reserva");programarReserva();break;
			case 0:salir = true;break;
			}
		} while (!salir);
	}
	
	public void verTodasLasReservas() {
		ArrayList<ReservaDTO> lista = reservaController.obtenerTodasLasReservas();
		
		System.out.println("Reservas");
		System.out.println("--------------");
		if (lista.isEmpty()) {
            System.out.println("No hay reservas registradas.");
        } else {
            for (ReservaDTO r : lista) {
                System.out.println(r.getId() + " | " + r.getTituloPelicula() + " | " + r.getNombreCliente() + 
                		" | " + r.getHora() + " min | " + r.getNumEntradas() + " | " + r.getTotal());
            }
        }
    }
	
	private void programarReserva() {
		System.out.println("--- Programar nueva reserva ---");

		int idSesion = Lecturas.leerEntero("Id de la sesion: ");
		int idCliente = Lecturas.leerEntero("Id del cliente: ");
		int numEntradas = Lecturas.leerEntero("Numero de entradas: ");

		boolean resultado = reservaController.programarReserva(idSesion, idCliente, numEntradas);
		if (!resultado) {
			System.out.println("No se pudo programar la sesion.");
		}		
	}

}
