package simulacionExamenArrayNormal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {

    public static void main(String[] args) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        Personaje[] personajes = new Personaje[10];
        int numPersonajes = 0;

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
                    numPersonajes = añadirPersonaje(personajes, numPersonajes);
                    break;
                case 2:
                    mostrarPorBando(personajes, numPersonajes);
                    break;
                case 3:
                    añadirAlEquipo(personajes, numPersonajes);
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

    private static int añadirPersonaje(Personaje[] personajes, int numPersonajes) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        if (numPersonajes >= 10) {
            System.out.println("No se pueden añadir mas personajes, limite alcanzado");
            return numPersonajes;
        }

        int cantidad = 0;
        boolean datosOK = false;
        while (!datosOK) {
            try {
                System.out.print("¿Cuantos personajes desea añadir?: ");
                cantidad = Integer.parseInt(leer.readLine());
                if (cantidad <= 0)
                    System.out.println("Tiene que ser mayor que 0");
                else
                    datosOK = true;
            } catch (NumberFormatException | IOException e) {
                System.out.println("Solo puedes introducir numeros");
            }
        }

        for (int i = 0; i < cantidad; i++) {
            if (numPersonajes >= 10) {
                System.out.println("Se ha alcanzado el limite de personajes");
                break;
            }

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
                h.pedirDatos(personajes, numPersonajes);
                personajes[numPersonajes] = h;
            } else {
                Villano v = new Villano();
                v.pedirDatos(personajes, numPersonajes);
                personajes[numPersonajes] = v;
            }
            numPersonajes++;
        }
        return numPersonajes;
    }

    private static void mostrarPorBando(Personaje[] personajes, int numPersonajes) {
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
        for (int i = 0; i < numPersonajes; i++) {
            if (personajes[i].getBando().equalsIgnoreCase(bando)) {
                System.out.println("Mostrando personaje " + contador);
                personajes[i].mostrarDatos();
                enc = true;
                contador++;
            }
        }

        if (!enc)
            System.out.println("No hay personajes de ese bando");
    }

    private static void añadirAlEquipo(Personaje[] personajes, int numPersonajes) {
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
        for (int i = 0; i < numPersonajes; i++) {
            if (personajes[i].getNombre().equalsIgnoreCase(nombre)) {
                encontrado = personajes[i];
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
        for (int i = 0; i < numPersonajes; i++) {
            if (personajes[i].isEnEquipoActivo())
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
        for (int i = 0; i < numPersonajes; i++) {
            if (personajes[i].isEnEquipoActivo())
                totalPoder += personajes[i].getNivelPoder();
        }
        System.out.println("Media de nivel de poder del equipo: " + (totalPoder / enEquipo));
    }
    
    /*SIN NULL
     * private static void añadirAlEquipo(Personaje[] personajes, int numPersonajes) {
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
    for (int i = 0; i < numPersonajes; i++) {
        if (personajes[i].getNombre().equalsIgnoreCase(nombre)) {
            posEncontrado = i;
            break;
        }
    }

    if (posEncontrado == -1) {
        System.out.println("No se ha encontrado el personaje");
        return;
    }

    if (personajes[posEncontrado].isEnEquipoActivo()) {
        System.out.println("El personaje ya esta en el equipo activo");
        return;
    }

    int enEquipo = 0;
    for (int i = 0; i < numPersonajes; i++) {
        if (personajes[i].isEnEquipoActivo())
            enEquipo++;
    }

    if (enEquipo >= 6) {
        System.out.println("El equipo ya tiene 6 personajes, no se pueden añadir mas");
        return;
    }

    personajes[posEncontrado].setEnEquipoActivo(true);
    enEquipo++;
    System.out.println("Personaje añadido correctamente al equipo");
    System.out.println("Personajes en el equipo: " + enEquipo);

    int totalPoder = 0;
    for (int i = 0; i < numPersonajes; i++) {
        if (personajes[i].isEnEquipoActivo())
            totalPoder += personajes[i].getNivelPoder();
    }
    System.out.println("Media de nivel de poder del equipo: " + (totalPoder / enEquipo));
}  */
}
