package vista;

import java.util.ArrayList;
import controlador.PirataController;
import modelo.PirataDTO;
import utils.Lecturas;

public class VistaPirata {
    
	PirataController pirataControlador = new PirataController();

    public void menuPirata() {
        boolean salir = false;
        do {
            System.out.println("=== Gestion Pirata ===");
            System.out.println("1. Listar Pirata");
            System.out.println("2. anadir Pirata");
            System.out.println("3. Editar Pirata");
            System.out.println("4. Borrar Pirata");
            System.out.println("0. Volver");
            int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 4);
            
            switch (opcion) {
                case 1:System.out.println("Listar Pirata");verTodosLosPiratas(); break;
                //case 2:System.out.println("anadir Pirata");insertar(); break;
                //case 3:System.out.println("Editar Pirata");editar(); break;
                //case 4:System.out.println("Borrar Pirata");borrar(); break;
                case 0:salir = true; break;
            }
        } while (!salir);
    }
        
        public void verTodosLosPiratas() {
        	//recorremos todo ela rray para ver los datos
            ArrayList<PirataDTO> listaPiratas = pirataControlador.verTodosLosPiratas();
            
            System.out.println("Piratas");
            System.out.println("--------------");
            
            //si esta vacio mensaje
            if (listaPiratas.isEmpty()) {
                System.out.println("No hay piratas registrados.");
            //si no esta vacio, bucle que recorra la lista y da atributos
            } else {
                for (PirataDTO p : listaPiratas) {
                    System.out.println(p.getId() + " - " + p.getNombre() + " - " + p.getFrutaDiablo() + " - " 
                + p.getTripulacion() + " - " + p.isActivo());
                }
            }
        }
    }
