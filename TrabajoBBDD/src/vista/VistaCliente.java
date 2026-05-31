package vista;

import java.util.ArrayList;
import controlador.ClienteController;
import modelo.ClienteDTO;
import utils.Lecturas;

public class VistaCliente {

    private boolean validarEmail(String email) {
        return email.contains("@") && email.indexOf(".") > email.indexOf("@");
    }

    private boolean validarTelefono(String telefono) {
        return telefono.matches("[0-9]+");
    }
    
    ClienteController clienteControlador = new ClienteController();

    public void menuCliente() {
        boolean salir = false;
        do {
            System.out.println("=== Gestion Cliente ===");
            System.out.println("1. Listar clientes");
            System.out.println("2. Añadir cliente");
            System.out.println("3. Editar cliente");
            System.out.println("4. Borrar cliente");
            System.out.println("0. Volver");
            int opcion = Lecturas.leerEnteroEnRango("Introduce una opcion: ", 0, 4);
            
            switch (opcion) {
                case 1:System.out.println("Ver Clientes");verTodosLosClientes(); break;
                case 2:System.out.println("Insertar Clientes");insertar(); break;
                case 3:System.out.println("Editar Clientes");editar(); break;
                case 4:System.out.println("Borrar Clientes");borrar(); break;
                case 0:salir = true; break;
            }
        } while (!salir);
    }

    public void verTodosLosClientes() {
        ArrayList<ClienteDTO> listaClientes = clienteControlador.obtenerClientes();
        
        System.out.println("Clientes");
        System.out.println("--------------");
        
        if (listaClientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (ClienteDTO c : listaClientes) {
                System.out.println(c.getId() + " - " + c.getNombre() + " - " + c.getEmail() + " - " + c.getTelefono());
            }
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
            System.out.println("Telefono no valido, solo digitos. Operacion cancelada.");
            return;
        }

        ClienteDTO cliente  = new ClienteDTO(nombre, email, telefono);

        if (clienteControlador.insertar(cliente))
            System.out.println("Cliente añadido correctamente");
        else
            System.out.println("Error al añadir el cliente");
    }

    public void editar() {
        int id = Lecturas.leerEntero("ID del cliente a editar: ");

        String nombre = Lecturas.leerString("Nuevo nombre: ");
        String email = Lecturas.leerString("Nuevo email: ");
        String telefono = Lecturas.leerString("Nuevo telefono: ");

        if (!validarEmail(email)) 
        	return;
        
        if (!validarTelefono(telefono)) 
        	return;

        ClienteDTO editado = new ClienteDTO(id, nombre, email, telefono);

        if (clienteControlador.editar(editado))
            System.out.println("Cliente actualizado correctamente.");
        else
            System.out.println("Error al actualizar el cliente.");
    }

    public void borrar() {
        int id = Lecturas.leerEntero("Id del cliente a borrar: ");
        if (clienteControlador.borrar(id))
            System.out.println("Cliente borrado correctamente.");
        else
            System.out.println("Error al borrar el cliente.");
    }
}
