package simulacionExamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Personaje> personajes = new ArrayList<Personaje>();

        boolean salir = false;
        do {
            System.out.println("\n=== GESTION DE SUPERHEROES ===");
            System.out.println("1. Añadir personaje");
            System.out.println("2. Mostrar personajes por bando");
            System.out.println("3. Añadir al equipo activo");
            System.out.println("4. Salir");
            System.out.print("Introduce una opcion: ");

            int opcion = -1;
            boolean datosOK = false;
            while (!datosOK) {
                try {
                    opcion = Integer.parseInt(leer.readLine());
                    datosOK = true;
                } catch (NumberFormatException | IOException e) {
                    System.out.println("Solo puedes introducir numeros");
                }
            }

            switch (opcion) {
                case 1:
                    añadirPersonaje(personajes);
                    break;
                case 2:
                    mostrarPorBando(personajes);
                    break;
                case 3:
                    añadirAlEquipo(personajes);
                    break;
                case 4:
                    salir = true;
                    System.out.println("¡Que empiece la batalla!");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (!salir);
    }

    private static void añadirPersonaje(ArrayList<Personaje> personajes) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        int cantidad = 0;
        boolean datosOK = false;
        while (!datosOK) {
            try {
                System.out.print("¿Cuantos personajes desea añadir?: ");
                cantidad = Integer.parseInt(leer.readLine());
                datosOK = true;
            } catch (NumberFormatException | IOException e) {
                System.out.println("Solo puedes introducir numeros");
            }
        }

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Añadiendo personaje " + (i + 1) + " de " + cantidad);
            String tipo = "";
            do {
                try {
                    System.out.print("Tipo de personaje (Heroe o Villano): ");
                    tipo = leer.readLine();
                    if (!tipo.equalsIgnoreCase("heroe") && !tipo.equalsIgnoreCase("villano"))
                        System.out.println("Tiene que ser Heroe o Villano");
                } catch (IOException e) {
                    System.out.println("Error leyendo datos");
                }
            } while (!tipo.equalsIgnoreCase("heroe") && !tipo.equalsIgnoreCase("villano"));

            if (tipo.equalsIgnoreCase("heroe")) {
                Heroe h = new Heroe();
                h.pedirDatos(personajes);
                personajes.add(h);
            } else {
                Villano v = new Villano();
                v.pedirDatos(personajes);
                personajes.add(v);
            }
        }
    }

    private static void mostrarPorBando(ArrayList<Personaje> personajes) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        String bando = "";

        do {
            try {
                System.out.print("Introduce el bando (heroe/villano): ");
                bando = leer.readLine();
                if (!bando.equalsIgnoreCase("heroe") && !bando.equalsIgnoreCase("villano"))
                    System.out.println("Tiene que ser heroe o villano");
            } catch (IOException e) {
                System.out.println("Error leyendo datos");
            }
        } while (!bando.equalsIgnoreCase("heroe") && !bando.equalsIgnoreCase("villano"));

        boolean enc = false;
        int contador = 1;
        for (Personaje p : personajes) {
            if (p.getBando().equalsIgnoreCase(bando)) {
                System.out.println("Mostrando personaje " + contador);
                p.mostrarDatos();
                enc = true;
                contador++;
            }
        }

        if (!enc)
            System.out.println("No hay personajes de ese bando");
    }

    private static void añadirAlEquipo(ArrayList<Personaje> personajes) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        String nombre = "";

        try {
            System.out.print("Introduce el nombre del personaje: ");
            nombre = leer.readLine();
        } catch (IOException e) {
            System.out.println("Error leyendo datos");
            return;
        }

        Personaje encontrado = null;
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = p;
                break;
            }
        }

        if (encontrado == null) {
            System.out.println("No se ha encontrado el personaje");
            return;
        }

        if (encontrado.isEnEquipoActivo()) {
            System.out.println("El personaje ya esta en el equipo activo");
            return;
        }

        int enEquipo = 0;
        for (Personaje p : personajes) {
            if (p.isEnEquipoActivo())
                enEquipo++;
        }

        if (enEquipo >= 6) {
            System.out.println("El equipo ya tiene 6 personajes, no se pueden añadir mas");
            return;
        }

        encontrado.setEnEquipoActivo(true);
        enEquipo++;
        System.out.println("Personaje añadido correctamente al equipo");
        System.out.println("Personajes en el equipo: " + enEquipo);

        int totalPoder = 0;
        for (Personaje p : personajes) {
            if (p.isEnEquipoActivo())
                totalPoder += p.getNivelPoder();
        }
        System.out.println("Media de nivel de poder del equipo: " + (totalPoder / enEquipo));
    }
    /*SIN NULL
     * private static void añadirAlEquipo(ArrayList<Personaje> personajes) {
    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    String nombre = "";

    try {
        System.out.print("Introduce el nombre del personaje: ");
        nombre = leer.readLine();
    } catch (IOException e) {
        System.out.println("Error leyendo datos");
        return;
    }

    int posEncontrado = -1;
    for (int i = 0; i < personajes.size(); i++) {
        if (personajes.get(i).getNombre().equalsIgnoreCase(nombre)) {
            posEncontrado = i;
            break;
        }
    }

    if (posEncontrado == -1) {
        System.out.println("No se ha encontrado el personaje");
        return;
    }

    if (personajes.get(posEncontrado).isEnEquipoActivo()) {
        System.out.println("El personaje ya esta en el equipo activo");
        return;
    }

    int enEquipo = 0;
    for (int i = 0; i < personajes.size(); i++) {
        if (personajes.get(i).isEnEquipoActivo())
            enEquipo++;
    }

    if (enEquipo >= 6) {
        System.out.println("El equipo ya tiene 6 personajes, no se pueden añadir mas");
        return;
    }

    personajes.get(posEncontrado).setEnEquipoActivo(true);
    enEquipo++;
    System.out.println("Personaje añadido correctamente al equipo");
    System.out.println("Personajes en el equipo: " + enEquipo);

    int totalPoder = 0;
    for (int i = 0; i < personajes.size(); i++) {
        if (personajes.get(i).isEnEquipoActivo())
            totalPoder += personajes.get(i).getNivelPoder();
    }
    System.out.println("Media de nivel de poder del equipo: " + (totalPoder / enEquipo));
}*/
  
}
