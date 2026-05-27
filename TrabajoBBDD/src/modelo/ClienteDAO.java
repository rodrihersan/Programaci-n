package modelo;

import java.sql.*;
import java.util.ArrayList;
import Utils.ConexionBBDD;

public class ClienteDAO {

    public ArrayList<ClienteDTO> obtenerTodosLosClientes() {
        ArrayList<ClienteDTO> listaClientes = new ArrayList<>();
        Connection conexion = ConexionBBDD.getConexion();
        try {
            String sql = "SELECT * FROM clientes";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id          = rs.getInt("id");
                String nombre   = rs.getString("nombre");
                String email    = rs.getString("email");
                String telefono = rs.getString("telefono");
                listaClientes.add(new ClienteDTO(id, nombre, email, telefono));
            }
            conexion.close();
            return listaClientes;
        } catch (SQLException e) {
            e.printStackTrace();
            return listaClientes;
        }
    }

    public boolean insertarCliente(ClienteDTO cliente) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "INSERT INTO clientes (nombre, email, telefono) VALUES (?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefono());
            int filasAfectadas = ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            int idGenerado = -1;
            System.out.println(keys.next());
            idGenerado = keys.getInt(1);
            System.out.println("EL ID GENERADO ES " + idGenerado);
            conexion.close();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
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
            System.out.println("Error en la BBDD: " + e.getMessage());
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
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            return false;
        }
    }
}
