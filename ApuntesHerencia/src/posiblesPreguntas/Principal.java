package posiblesPreguntas;

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
            System.out.println("2. Mostrar todos los personajes");
            System.out.println("3. Mostrar todos los heroes");
            System.out.println("4. Mostrar todos los villanos");
            System.out.println("5. Mostrar por bando");
            System.out.println("6. Mostrar por organizacion");
            System.out.println("7. Mostrar por peligrosidad");
            System.out.println("8. Mostrar por nivel de poder minimo");
            System.out.println("9. Añadir al equipo activo");
            System.out.println("10. Buscar personaje por nombre");
            System.out.println("11. Media de nivel de poder de todos");
            System.out.println("12. Media de nivel de poder de heroes");
            System.out.println("13. Media de nivel de poder de villanos");
            System.out.println("14. Personaje mas poderoso");
            System.out.println("15. Heroe con mas misiones");
            System.out.println("16. Contar heroes y villanos");
            System.out.println("17. Contar por organizacion");
            System.out.println("18. Buscar por organizacion");
            System.out.println("19. Buscar villanos de peligrosidad alta");
            System.out.println("20. Subir nivel de poder");
            System.out.println("21. Cambiar bando");
            System.out.println("22. Salir");
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
                    mostrarTodos(personajes);
                    break;
                case 3:
                    mostrarHeroes(personajes);
                    break;
                case 4:
                    mostrarVillanos(personajes);
                    break;
                case 5:
                    mostrarPorBando(personajes);
                    break;
                case 6:
                    mostrarPorOrganizacion(personajes);
                    break;
                case 7:
                    mostrarPorPeligrosidad(personajes);
                    break;
                case 8:
                    mostrarPorNivelMinimo(personajes);
                    break;
                case 9:
                    añadirAlEquipo(personajes);
                    break;
                case 10:
                    buscarPorNombre(personajes);
                    break;
                case 11:
                    mediaNivelTodos(personajes);
                    break;
                case 12:
                    mediaNivelHeroes(personajes);
                    break;
                case 13:
                    mediaNivelVillanos(personajes);
                    break;
                case 14:
                    personajeMasPoderoso(personajes);
                    break;
                case 15:
                    heroeMasMisiones(personajes);
                    break;
                case 16:
                    contarHeroesYVillanos(personajes);
                    break;
                case 17:
                    contarPorOrganizacion(personajes);
                    break;
                case 18:
                    buscarPorOrganizacion(personajes);
                    break;
                case 19:
                    villanosPeligrososAltos(personajes);
                    break;
                case 20:
                    subirNivelPoder(personajes);
                    break;
                case 21:
                    cambiarBando(personajes);
                    break;
                case 22:
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

    private static void mostrarTodos(ArrayList<Personaje> personajes) {
        if (personajes.size() == 0) {
            System.out.println("No hay personajes registrados");
            return;
        }
        for (int i = 0; i < personajes.size(); i++) {
            personajes.get(i).mostrarDatos();
        }
    }

    private static void mostrarHeroes(ArrayList<Personaje> personajes) {
        boolean enc = false;
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i) instanceof Heroe) {
                personajes.get(i).mostrarDatos();
                enc = true;
            }
        }
        if (!enc)
            System.out.println("No hay heroes registrados");
    }

    private static void mostrarVillanos(ArrayList<Personaje> personajes) {
        boolean enc = false;
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i) instanceof Villano) {
                personajes.get(i).mostrarDatos();
                enc = true;
            }
        }
        if (!enc)
            System.out.println("No hay villanos registrados");
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
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i).getBando().equalsIgnoreCase(bando)) {
                personajes.get(i).mostrarDatos();
                enc = true;
            }
        }
        if (!enc)
            System.out.println("No hay personajes de ese bando");
    }

    private static void mostrarPorOrganizacion(ArrayList<Personaje> personajes) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
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

        boolean enc = false;
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i) instanceof Heroe) {
                if (((Heroe) personajes.get(i)).getOrganizacion().equalsIgnoreCase(organizacion)) {
                    personajes.get(i).mostrarDatos();
                    enc = true;
                }
            }
        }
        if (!enc)
            System.out.println("No hay heroes de esa organizacion");
    }

    private static void mostrarPorPeligrosidad(ArrayList<Personaje> personajes) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
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

        boolean enc = false;
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i) instanceof Villano) {
                if (((Villano) personajes.get(i)).getPeligrosidad().equalsIgnoreCase(peligrosidad)) {
                    personajes.get(i).mostrarDatos();
                    enc = true;
                }
            }
        }
        if (!enc)
            System.out.println("No hay villanos con esa peligrosidad");
    }

    private static void mostrarPorNivelMinimo(ArrayList<Personaje> personajes) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        int nivelMinimo = -1;
        boolean datosOK = false;
        while (!datosOK) {
            try {
                System.out.print("Introduce el nivel minimo de poder (1-10): ");
                nivelMinimo = Integer.parseInt(leer.readLine());
                if (nivelMinimo < 1 || nivelMinimo > 10)
                    System.out.println("Tiene que ser entre 1 y 10");
                else
                    datosOK = true;
            } catch (NumberFormatException | IOException e) {
                System.out.println("Solo puedes introducir numeros");
            }
        }

        boolean enc = false;
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i).getNivelPoder() >= nivelMinimo) {
                personajes.get(i).mostrarDatos();
                enc = true;
            }
        }
        if (!enc)
            System.out.println("No hay personajes con ese nivel minimo");
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

    private static void buscarPorNombre(ArrayList<Personaje> personajes) {
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

        personajes.get(posEncontrado).mostrarDatos();
    }

    private static void mediaNivelTodos(ArrayList<Personaje> personajes) {
        if (personajes.size() == 0) {
            System.out.println("No hay personajes registrados");
            return;
        }
        int total = 0;
        for (int i = 0; i < personajes.size(); i++) {
            total += personajes.get(i).getNivelPoder();
        }
        System.out.println("Media de nivel de poder de todos: " + (total / personajes.size()));
    }

    private static void mediaNivelHeroes(ArrayList<Personaje> personajes) {
        int total = 0;
        int contador = 0;
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i) instanceof Heroe) {
                total += personajes.get(i).getNivelPoder();
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("No hay heroes registrados");
            return;
        }
        System.out.println("Media de nivel de poder de heroes: " + (total / contador));
    }

    private static void mediaNivelVillanos(ArrayList<Personaje> personajes) {
        int total = 0;
        int contador = 0;
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i) instanceof Villano) {
                total += personajes.get(i).getNivelPoder();
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("No hay villanos registrados");
            return;
        }
        System.out.println("Media de nivel de poder de villanos: " + (total / contador));
    }

    private static void personajeMasPoderoso(ArrayList<Personaje> personajes) {
        if (personajes.size() == 0) {
            System.out.println("No hay personajes registrados");
            return;
        }
        int posMasFuerte = 0;
        for (int i = 1; i < personajes.size(); i++) {
            if (personajes.get(i).getNivelPoder() > personajes.get(posMasFuerte).getNivelPoder()) {
                posMasFuerte = i;
            }
        }
        System.out.println("Personaje mas poderoso:");
        personajes.get(posMasFuerte).mostrarDatos();
    }

    private static void heroeMasMisiones(ArrayList<Personaje> personajes) {
        int posMasMisiones = -1;
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i) instanceof Heroe) {
                if (posMasMisiones == -1) {
                    posMasMisiones = i;
                } else if (((Heroe) personajes.get(i)).getMisiones() > ((Heroe) personajes.get(posMasMisiones)).getMisiones()) {
                    posMasMisiones = i;
                }
            }
        }
        if (posMasMisiones == -1) {
            System.out.println("No hay heroes registrados");
            return;
        }
        System.out.println("Heroe con mas misiones:");
        personajes.get(posMasMisiones).mostrarDatos();
    }

    private static void contarHeroesYVillanos(ArrayList<Personaje> personajes) {
        int numHeroes = 0;
        int numVillanos = 0;
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i) instanceof Heroe)
                numHeroes++;
            else if (personajes.get(i) instanceof Villano)
                numVillanos++;
        }
        System.out.println("Numero de heroes: " + numHeroes);
        System.out.println("Numero de villanos: " + numVillanos);
    }

    private static void contarPorOrganizacion(ArrayList<Personaje> personajes) {
        int avengers = 0;
        int xmen = 0;
        int justiceLeague = 0;
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i) instanceof Heroe) {
                String org = ((Heroe) personajes.get(i)).getOrganizacion();
                if (org.equalsIgnoreCase("Avengers"))
                    avengers++;
                else if (org.equalsIgnoreCase("XMen"))
                    xmen++;
                else if (org.equalsIgnoreCase("JusticeLeague"))
                    justiceLeague++;
            }
        }
        System.out.println("Avengers: " + avengers);
        System.out.println("XMen: " + xmen);
        System.out.println("JusticeLeague: " + justiceLeague);
    }

    private static void buscarPorOrganizacion(ArrayList<Personaje> personajes) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
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

        boolean enc = false;
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i) instanceof Heroe) {
                if (((Heroe) personajes.get(i)).getOrganizacion().equalsIgnoreCase(organizacion)) {
                    personajes.get(i).mostrarDatos();
                    enc = true;
                }
            }
        }
        if (!enc)
            System.out.println("No hay heroes de esa organizacion");
    }

    private static void villanosPeligrososAltos(ArrayList<Personaje> personajes) {
        boolean enc = false;
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i) instanceof Villano) {
                if (((Villano) personajes.get(i)).getPeligrosidad().equalsIgnoreCase("alto")) {
                    personajes.get(i).mostrarDatos();
                    enc = true;
                }
            }
        }
        if (!enc)
            System.out.println("No hay villanos de peligrosidad alta");
    }

    private static void subirNivelPoder(ArrayList<Personaje> personajes) {
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

        int nuevoNivel = -1;
        boolean datosOK = false;
        while (!datosOK) {
            try {
                System.out.print("Introduce el nuevo nivel de poder (1-10): ");
                nuevoNivel = Integer.parseInt(leer.readLine());
                if (nuevoNivel < 1 || nuevoNivel > 10)
                    System.out.println("Tiene que ser entre 1 y 10");
                else
                    datosOK = true;
            } catch (NumberFormatException | IOException e) {
                System.out.println("Solo puedes introducir numeros");
            }
        }

        personajes.get(posEncontrado).setNivelPoder(nuevoNivel);
        System.out.println("Nivel de poder actualizado correctamente");
    }

    private static void cambiarBando(ArrayList<Personaje> personajes) {
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

        String bandoActual = personajes.get(posEncontrado).getBando();
        if (bandoActual.equalsIgnoreCase("heroe")) {
            personajes.get(posEncontrado).setBando("villano");
            System.out.println("El personaje ahora es villano");
        } else {
            personajes.get(posEncontrado).setBando("heroe");
            System.out.println("El personaje ahora es heroe");
        }
    }
}
