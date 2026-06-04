package vista;

import controlador.PirataController;
import modelo.PirataDTO;
import utils.Lecturas;

public class VistaPirata {
    PirataController pirataController = new PirataController();

    public void menuPirata() {
        boolean salir = false;
        do {
            System.out.println("=== Gestion Piratas ===");
            System.out.println("1. Listar todos los piratas");
            System.out.println("2. Insertar pirata");
            System.out.println("3. Editar pirata");
            System.out.println("4. Eliminar pirata");
            System.out.println("0. Volver al menu principal");
            int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 4);
            switch (opcion) {
                case 1: pirataController.listarTodosLosPiratas(); break;
                case 2: insertarPirata(); break;
                case 3: editarPirata(); break;
                case 4: eliminarPirata(); break;
                case 0: salir = true; break;
            }
        } while (!salir);
    }

    public void insertarPirata() {
        String nombre = Lecturas.leerString("Nombre: ");
        String fruta = Lecturas.leerString("Fruta del Diablo (deja vacio si no tiene): ");
        String fecha = Lecturas.leerString("Fecha de nacimiento (YYYY-MM-DD): ");
        int islaId = Lecturas.leerEntero("Id de la isla de origen: ");
        PirataDTO nuevo = new PirataDTO(nombre, fruta, fecha, true, islaId);
        if (pirataController.insertar(nuevo))
            System.out.println("Pirata insertado correctamente.");
        else
            System.out.println("Error al insertar el pirata.");
    }

    public void editarPirata() {
        pirataController.listarTodosLosPiratas();
        int id = Lecturas.leerEntero("Id del pirata a editar: ");
        String nombre = Lecturas.leerString("Nuevo nombre: ");
        String fruta = Lecturas.leerString("Nueva fruta del diablo (deja vacio si no tiene): ");
        String fecha = Lecturas.leerString("Nueva fecha de nacimiento (YYYY-MM-DD): ");
        int islaId = Lecturas.leerEntero("Nuevo id de isla: ");
        PirataDTO pirata = new PirataDTO(id, nombre, fruta, fecha, true, islaId);
        if (pirataController.actualizar(pirata))
            System.out.println("Pirata actualizado correctamente.");
        else
            System.out.println("Error al actualizar el pirata.");
    }

    public void eliminarPirata() {
        pirataController.listarTodosLosPiratas();
        int id = Lecturas.leerEntero("Id del pirata a eliminar: ");
        if (pirataController.eliminar(id))
            System.out.println("Pirata marcado como inactivo correctamente.");
        else
            System.out.println("Error al eliminar el pirata.");
    }
}
