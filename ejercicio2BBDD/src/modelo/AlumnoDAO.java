package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.ConexionBBDD;

public class AlumnoDAO {

    public ArrayList<AlumnoDTO> obtenerTodosLosAlumnos() {
        ArrayList<AlumnoDTO> lista = new ArrayList<>();
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "SELECT id, nombre, email, edad FROM alumno";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                int edad = rs.getInt("edad");
                lista.add(new AlumnoDTO(id, nombre, email, edad));
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
    public ArrayList<AlumnoDTO> obtenerAlumnosPorEdadMaxima(int edadMaxima) {
        ArrayList<AlumnoDTO> lista = new ArrayList<>();
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "SELECT id, nombre, email, edad FROM alumno WHERE edad <= ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, edadMaxima);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                int edad = rs.getInt("edad");
                lista.add(new AlumnoDTO(id, nombre, email, edad));
            }
            conexion.close();
            return lista;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            e.printStackTrace();
            return lista;
        }
    }

    // Ejercicio 2 — JOIN
    public ArrayList<AlumnoDTO> obtenerAlumnosPorCurso(String nombreCurso) {
        ArrayList<AlumnoDTO> lista = new ArrayList<>();
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "SELECT a.id, a.nombre, a.email, a.edad " +
                         "FROM alumno a " +
                         "JOIN matricula m ON a.id = m.id_alumno " +
                         "JOIN curso c ON m.id_curso = c.id " +
                         "WHERE c.nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombreCurso);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                int edad = rs.getInt("edad");
                lista.add(new AlumnoDTO(id, nombre, email, edad));
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
    public boolean insertarAlumno(AlumnoDTO alumno) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "INSERT INTO alumno (nombre, email, edad) VALUES (?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getEmail());
            ps.setInt(3, alumno.getEdad());
            int filasAfectadas = ps.executeUpdate();
            conexion.close();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarAlumno(AlumnoDTO alumno) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "UPDATE alumno SET nombre = ?, email = ?, edad = ? WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getEmail());
            ps.setInt(3, alumno.getEdad());
            ps.setInt(4, alumno.getId());
            int filas = ps.executeUpdate();
            conexion.close();
            if (filas == 0) System.out.println("No se encontró ningún alumno con id " + alumno.getId());
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            return false;
        }
    }

    public boolean borrarAlumno(int id) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "DELETE FROM alumno WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            conexion.close();
            if (filasAfectadas == 0) System.out.println("No se encontró ningún alumno con id " + id);
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            return false;
        }
    }
}