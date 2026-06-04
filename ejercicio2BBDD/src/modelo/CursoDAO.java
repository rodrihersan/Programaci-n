package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.ConexionBBDD;

public class CursoDAO {

    public ArrayList<CursoDTO> obtenerTodosLosCursos() {
        ArrayList<CursoDTO> lista = new ArrayList<>();
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "SELECT id, nombre, duracion_horas, precio FROM curso";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int duracionHoras = rs.getInt("duracion_horas");
                double precio = rs.getDouble("precio");
                lista.add(new CursoDTO(id, nombre, duracionHoras, precio));
            }
            conexion.close();
            return lista;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            e.printStackTrace();
            return lista;
        }
    }

    // Ejercicio 2
    public ArrayList<CursoDTO> obtenerCursosPorPrecioMaximo(double precioMaximo) {
        ArrayList<CursoDTO> lista = new ArrayList<>();
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "SELECT id, nombre, duracion_horas, precio FROM curso WHERE precio <= ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setDouble(1, precioMaximo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int duracionHoras = rs.getInt("duracion_horas");
                double precio = rs.getDouble("precio");
                lista.add(new CursoDTO(id, nombre, duracionHoras, precio));
            }
            conexion.close();
            return lista;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            e.printStackTrace();
            return lista;
        }
    }

    // Ejercicio 3
    public boolean insertarCurso(CursoDTO curso) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "INSERT INTO curso (nombre, duracion_horas, precio) VALUES (?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, curso.getNombre());
            ps.setInt(2, curso.getDuracionHoras());
            ps.setDouble(3, curso.getPrecio());
            int filasAfectadas = ps.executeUpdate();
            conexion.close();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarCurso(CursoDTO curso) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "UPDATE curso SET nombre = ?, duracion_horas = ?, precio = ? WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, curso.getNombre());
            ps.setInt(2, curso.getDuracionHoras());
            ps.setDouble(3, curso.getPrecio());
            ps.setInt(4, curso.getId());
            int filas = ps.executeUpdate();
            conexion.close();
            if (filas == 0) System.out.println("No se encontró ningún curso con id " + curso.getId());
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            return false;
        }
    }

    public boolean borrarCurso(int id) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "DELETE FROM curso WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            conexion.close();
            if (filasAfectadas == 0) System.out.println("No se encontró ningún curso con id " + id);
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            return false;
        }
    }
}
