package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.ConexionBBDD;

public class PirataDAO {

    // Listar todos con tripulación, isla
    public void listarTodosLosPiratas() {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "SELECT p.id, p.nombre, p.frutaDelDiablo, p.fechaNacimiento, p.estaActivo, " +
                         "i.nombre AS isla, t.nombre AS tripulacion " +
                         "FROM Pirata p " +
                         "LEFT JOIN Isla i ON p.isla_id = i.id " +
                         "LEFT JOIN Reclutamiento r ON p.id = r.pirata_id AND r.esMiembroActual = TRUE " +
                         "LEFT JOIN Tripulacion t ON r.tripulacion_id = t.id";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("Piratas");
            System.out.println("--------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String fruta = rs.getString("frutaDelDiablo");
                String fecha = rs.getString("fechaNacimiento");
                boolean activo = rs.getBoolean("estaActivo");
                String isla = rs.getString("isla");
                String tripulacion = rs.getString("tripulacion");
                System.out.println(id + " | " + nombre +
                        " | Fruta: " + (fruta != null ? fruta : "Ninguna") +
                        " | Tripulacion: " + (tripulacion != null ? tripulacion : "Sin tripulacion") +
                        " | Nacimiento: " + fecha +
                        " | Isla: " + isla +
                        " | Activo: " + activo);
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean insertarPirata(PirataDTO pirata) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "INSERT INTO Pirata (nombre, frutaDelDiablo, fechaNacimiento, estaActivo, isla_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, pirata.getNombre());
            ps.setString(2, pirata.getFrutaDelDiablo().isEmpty() ? null : pirata.getFrutaDelDiablo());
            ps.setString(3, pirata.getFechaNacimiento());
            ps.setBoolean(4, pirata.isEstaActivo());
            ps.setInt(5, pirata.getIslaId());
            int filasAfectadas = ps.executeUpdate();
            conexion.close();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarPirata(PirataDTO pirata) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "UPDATE Pirata SET nombre = ?, frutaDelDiablo = ?, fechaNacimiento = ?, isla_id = ? WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, pirata.getNombre());
            ps.setString(2, pirata.getFrutaDelDiablo().isEmpty() ? null : pirata.getFrutaDelDiablo());
            ps.setString(3, pirata.getFechaNacimiento());
            ps.setInt(4, pirata.getIslaId());
            ps.setInt(5, pirata.getId());
            int filas = ps.executeUpdate();
            conexion.close();
            if (filas == 0) System.out.println("No se encontró ningún pirata con id " + pirata.getId());
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            return false;
        }
    }

    // Borrado lógico
    public boolean eliminarPirata(int id) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "UPDATE Pirata SET estaActivo = FALSE WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            conexion.close();
            if (filas == 0) System.out.println("No se encontró ningún pirata con id " + id);
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            return false;
        }
    }
}
