package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.ConexionBBDD;

public class ClienteDAO {
    public ArrayList<ClienteDTO> obtenerTodosLosClientes() {
    	
        ArrayList<ClienteDTO> listaClientes = new ArrayList<>();
        
        try {
        	Connection conexion = ConexionBBDD.getConexion();
        	
            String sql = "SELECT * FROM clientes";
            
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id          = rs.getInt("id");
                String nombre   = rs.getString("nombre");
                String email    = rs.getString("email");
                String telefono = rs.getString("telefono");
                ClienteDTO cliente = new ClienteDTO(id, nombre, email, telefono);
                listaClientes.add(cliente);
            }
            conexion.close();
			return listaClientes;
        } catch (SQLException e) {
        	System.out.println("Error al obtener clientes: " + e.getMessage());
        	e.printStackTrace();
			return null;
		}
    }

    public boolean insertarCliente(ClienteDTO cliente) {
    	
        try {
            Connection conexion = ConexionBBDD.getConexion();
            
            String sql = "INSERT INTO clientes (nombre, email, telefono) VALUES (?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefono());
            
            int filasAfectadas = ps.executeUpdate();
			conexion.close();

			return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error en la BBDD al insertar: " + e.getMessage());
            return false;
        }
    }

    public boolean editarCliente(ClienteDTO cliente) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            
            String sql = "UPDATE clientes SET nombre=?, email=?, telefono=? WHERE id=?";
            
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefono());
            ps.setInt(4, cliente.getId());
            
            int filasAfectadas = ps.executeUpdate();
            conexion.close();
            
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error en la BBDD al eidtar: " + e.getMessage());
            return false;
        }
    }

    public boolean borrarCliente(int id) {
        try {
        	
        	Connection conexion = ConexionBBDD.getConexion();
        	
            String sql = "DELETE FROM clientes WHERE id=?";
            
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            
            int filasAfectadas = ps.executeUpdate();
            
            conexion.close();
            
            if (filasAfectadas == 0) {
                System.err.println("No se encontró ninguna película con id " + id);
            }
            
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error en la BBDD al borrar: " + e.getMessage());
            return false;
        }
    }
}