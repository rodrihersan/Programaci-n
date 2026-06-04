package vista;

import controlador.TripulacionController;
import modelo.TripulacionDTO;
import utils.Lecturas;

public class VistaTripulacion {
    TripulacionController tripulacionController = new TripulacionController();

    public void menuTripulacion() {
        boolean salir = false;
        do {
            System.out.println("=== Gestion Tripulaciones ===");
            System.out.println("1. Listar todas las tripulaciones");
            System.out.println("2. Crear tripulacion");
            System.out.println("3. Editar tripulacion");
            System.out.println("4. Eliminar tripulacion");
            System.out.println("0. Volver al menu principal");
            int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 4);
            switch (opcion) {
                case 1: tripulacionController.listarTodasLasTripulaciones(); break;
                case 2: crearTripulacion(); break;
                case 3: editarTripulacion(); break;
                case 4: eliminarTripulacion(); break;
                case 0: salir = true; break;
            }
        } while (!salir);
    }

    public void crearTripulacion() {
        String nombre = Lecturas.leerString("Nombre de la tripulacion: ");
        String barco = Lecturas.leerString("Nombre del barco: ");
        TripulacionDTO nueva = new TripulacionDTO(nombre, barco, true);
        if (tripulacionController.insertar(nueva))
            System.out.println("Tripulacion creada correctamente.");
        else
            System.out.println("Error al crear la tripulacion.");
    }

    public void editarTripulacion() {
        tripulacionController.listarTodasLasTripulaciones();
        long id = Lecturas.leerEntero("Id de la tripulacion a editar: ");
        String nombre = Lecturas.leerString("Nuevo nombre: ");
        String barco = Lecturas.leerString("Nuevo barco: ");
        TripulacionDTO tripulacion = new TripulacionDTO(id, nombre, barco, true);
        if (tripulacionController.actualizar(tripulacion))
            System.out.println("Tripulacion actualizada correctamente.");
        else
            System.out.println("Error al actualizar la tripulacion.");
    }

    public void eliminarTripulacion() {
        tripulacionController.listarTodasLasTripulaciones();
        long id = Lecturas.leerEntero("Id de la tripulacion a eliminar: ");
        if (tripulacionController.eliminar(id))
            System.out.println("Tripulacion marcada como inactiva correctamente.");
        else
            System.out.println("Error al eliminar la tripulacion.");
    }
}