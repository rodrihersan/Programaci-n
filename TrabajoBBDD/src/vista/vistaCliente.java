package vista;

import java.util.ArrayList;
import controlador.ClienteController;
import modelo.ClienteDTO;
import Utils.Lecturas;

public class vistaCliente {

    private boolean validarEmail(String email) {
        return email.contains("@") && email.indexOf(".") > email.indexOf("@");
    }

    private boolean validarTelefono(String telefono) {
        return telefono.matches("[0-9]+");
    }

    public void menuCliente() {
        boolean salir = false;
        do {
            System.out.println("=== GESTION DE CLIENTES ===");
            System.out.println("1. Listar clientes");
            System.out.println("2. Añadir cliente");
            System.out.println("3. Editar cliente");
            System.out.println("4. Borrar cliente");
            System.out.println("0. Volver");
            int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 4);
            switch (opcion) {
                case 1: verTodosLosClientes(); break;
                case 2: insertar(); break;
                case 3: editar(); break;
                case 4: borrar(); break;
                case 0: salir = true; break;
            }
        } while (!salir);
    }

    public void verTodosLosClientes() {
        ClienteController clienteControlador = new ClienteController();
        ArrayList<ClienteDTO> listaClientes = clienteControlador.obtenerTodosLosClientes();
        System.out.println("CLIENTES");
        System.out.println("--------------");
        for (ClienteDTO cliente : listaClientes) {
            System.out.println(cliente.getId() + " - " + cliente.getNombre() + " | " + cliente.getEmail() + " | " + cliente.getTelefono());
        }
    }

    public void insertar() {
        String nombre   = Lecturas.leerString("Nombre: ");
        String email    = Lecturas.leerString("Email: ");
        String telefono = Lecturas.leerString("Telefono: ");

        if (!validarEmail(email)) {
            System.out.println("Email no valido. Operacion cancelada.");
            return;
        }
        if (!validarTelefono(telefono)) {
            System.out.println("Telefono no valido, solo se permiten digitos. Operacion cancelada.");
            return;
        }

        ClienteDTO cliente = new ClienteDTO(nombre, email, telefono);
        ClienteController clienteControlador = new ClienteController();
        if (clienteControlador.insertar(cliente))
            System.out.println("Cliente añadido correctamente");
        else
            System.out.println("Error al añadir el cliente");
    }

    public void editar() {
        int id = Lecturas.leerEnteroEnRango("ID del cliente a editar: ", 1, Integer.MAX_VALUE);
        String nombre   = Lecturas.leerString("Nuevo nombre: ");
        String email    = Lecturas.leerString("Nuevo email: ");
        String telefono = Lecturas.leerString("Nuevo telefono: ");

        if (!validarEmail(email)) {
            System.out.println("Email no valido. Operacion cancelada.");
            return;
        }
        if (!validarTelefono(telefono)) {
            System.out.println("Telefono no valido, solo se permiten digitos. Operacion cancelada.");
            return;
        }

        ClienteDTO cliente = new ClienteDTO(id, nombre, email, telefono);
        ClienteController clienteControlador = new ClienteController();
        if (clienteControlador.editar(cliente))
            System.out.println("Cliente editado correctamente");
        else
            System.out.println("Error: no se encontro el cliente con ese ID");
    }

    public void borrar() {
        int id = Lecturas.leerEnteroEnRango("ID del cliente a borrar: ", 1, Integer.MAX_VALUE);
        ClienteController clienteControlador = new ClienteController();
        if (clienteControlador.borrar(id))
            System.out.println("Cliente borrado correctamente");
        else
            System.out.println("Error: no se encontro el cliente con ese ID");
    }
}
