package conConstructorArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

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

    private static int generarId(ArrayList<Personaje> personajes) {
        Random rand = new Random();
        int idGenerado = -1;
        boolean repetido = true;
        while (repetido) {
            idGenerado = rand.nextInt(9000) + 1000;
            repetido = false;
            for (int i = 0; i < personajes.size(); i++) {
                if (personajes.get(i).getId() == idGenerado) {
                    repetido = true;
                    break;
                }
            }
        }
        return idGenerado;
    }

    private static void añadirPersonaje(ArrayList<Personaje> personajes) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

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

            // datos comunes
            int id = generarId(personajes);
            System.out.println("ID asignado: " + id);

            String nombre = "";
            boolean nombreOK = false;
            while (!nombreOK) {
                try {
                    System.out.print("Introduce el nombre: ");
                    nombre = leer.readLine();
                    nombreOK = true;
                } catch (IOException e) {
                    System.out.println("Error leyendo datos");
                }
            }

            int nivelPoder = -1;
            boolean poderOK = false;
            while (!poderOK) {
                try {
                    System.out.print("Introduce el nivel de poder (1-10): ");
                    nivelPoder = Integer.parseInt(leer.readLine());
                    if (nivelPoder < 1 || nivelPoder > 10)
                        System.out.println("Tiene que ser entre 1 y 10");
                    else
                        poderOK = true;
                } catch (NumberFormatException | IOException e) {
                    System.out.println("Solo puedes introducir numeros");
                }
            }

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

            // datos especificos
            if (tipo.equalsIgnoreCase("heroe")) {
                String organizacion = "";
                do {
                    try {
                        System.out.print("Introduce la organizacion (Avengers/XMen/JusticeLeague): ");
                        organizacion = leer.readLine();
                        if (!organizacion.equalsIgnoreCase("Avengers") &&
                            !organizacion.equalsIgnoreCase("XMen") &&
                            !organizacion.equalsIgnoreCase("JusticeLeague"))
                            System.out.println("Organizacion no valida");
                    } catch (IOException e) {
                        System.out.println("Error leyendo datos");
                    }
                } while (!organizacion.equalsIgnoreCase("Avengers") &&
                         !organizacion.equalsIgnoreCase("XMen") &&
                         !organizacion.equalsIgnoreCase("JusticeLeague"));

                int misiones = -1;
                boolean misionesOK = false;
                while (!misionesOK) {
                    try {
                        System.out.print("Introduce el numero de misiones completadas: ");
                        misiones = Integer.parseInt(leer.readLine());
                        if (misiones < 0)
                            System.out.println("No puede ser negativo");
                        else
                            misionesOK = true;
                    } catch (NumberFormatException | IOException e) {
                        System.out.println("Solo puedes introducir numeros");
                    }
                }

                personajes.add(new Heroe(id, nombre, nivelPoder, bando, organizacion, misiones));

            } else {
                String peligrosidad = "";
                do {
                    try {
                        System.out.print("Introduce la peligrosidad (bajo/medio/alto): ");
                        peligrosidad = leer.readLine();
                        if (!peligrosidad.equalsIgnoreCase("bajo") &&
                            !peligrosidad.equalsIgnoreCase("medio") &&
                            !peligrosidad.equalsIgnoreCase("alto"))
                            System.out.println("Tiene que ser bajo, medio o alto");
                    } catch (IOException e) {
                        System.out.println("Error leyendo datos");
                    }
                } while (!peligrosidad.equalsIgnoreCase("bajo") &&
                         !peligrosidad.equalsIgnoreCase("medio") &&
                         !peligrosidad.equalsIgnoreCase("alto"));

                String arma = "";
                boolean armaOK = false;
                while (!armaOK) {
                    try {
                        System.out.print("Introduce el arma principal: ");
                        arma = leer.readLine();
                        armaOK = true;
                    } catch (IOException e) {
                        System.out.println("Error leyendo datos");
                    }
                }

                personajes.add(new Villano(id, nombre, nivelPoder, bando, peligrosidad, arma));
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
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i).getBando().equalsIgnoreCase(bando)) {
                System.out.println("Mostrando personaje " + contador);
                personajes.get(i).mostrarDatos();
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
    }
}