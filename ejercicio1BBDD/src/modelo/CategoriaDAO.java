package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.ConexionBBDD;

public class CategoriaDAO {

    public ArrayList<CategoriaDTO> obtenerTodasLasCategorias() {
        ArrayList<CategoriaDTO> lista = new ArrayList<>();
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "SELECT id, nombre FROM categoria";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                lista.add(new CategoriaDTO(id, nombre));
            }
            conexion.close();
            return lista;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            e.printStackTrace();
            return lista;
        }
    }

    // Usado en Ejercicio 4 para buscar productos por nombre de categoría
    public int obtenerIdPorNombre(String nombre) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "SELECT id FROM categoria WHERE nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                conexion.close();
                return id;
            }
            conexion.close();
            return -1;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            return -1;
        }
    }

    // Ejercicio 7
    public boolean insertarCategoria(CategoriaDTO categoria) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "INSERT INTO categoria (nombre) VALUES (?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, categoria.getNombre());
            int filasAfectadas = ps.executeUpdate();
            conexion.close();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarCategoria(CategoriaDTO categoria) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "UPDATE categoria SET nombre = ? WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, categoria.getNombre());
            ps.setInt(2, categoria.getId());
            int filas = ps.executeUpdate();
            conexion.close();
            if (filas == 0) System.out.println("No se encontró ninguna categoría con id " + categoria.getId());
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            return false;
        }
    }

    public boolean borrarCategoria(int id) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "DELETE FROM categoria WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            conexion.close();
            if (filasAfectadas == 0) System.out.println("No se encontró ninguna categoría con id " + id);
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            System.out.println("Puede que la categoría tenga productos asociados y no se pueda borrar.");
            return false;
        }
    }
}