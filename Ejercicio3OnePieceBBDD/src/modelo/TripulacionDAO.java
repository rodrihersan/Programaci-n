package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.ConexionBBDD;

public class TripulacionDAO {

    public void listarTodasLasTripulaciones() {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "SELECT t.id, t.nombre, t.barco, t.estaActiva, COUNT(r.pirata_id) AS numMiembros " +
                         "FROM Tripulacion t " +
                         "LEFT JOIN Reclutamiento r ON t.id = r.tripulacion_id AND r.esMiembroActual = TRUE " +
                         "GROUP BY t.id";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("Tripulaciones");
            System.out.println("--------------");
            while (rs.next()) {
                long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                String barco = rs.getString("barco");
                boolean activa = rs.getBoolean("estaActiva");
                int numMiembros = rs.getInt("numMiembros");
                System.out.println(id + " | " + nombre + " | Barco: " + barco + " | Activa: " + activa + " | Miembros: " + numMiembros);
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean insertarTripulacion(TripulacionDTO tripulacion) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "INSERT INTO Tripulacion (nombre, barco, estaActiva) VALUES (?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, tripulacion.getNombre());
            ps.setString(2, tripulacion.getBarco());
            ps.setBoolean(3, tripulacion.isEstaActiva());
            int filasAfectadas = ps.executeUpdate();
            conexion.close();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarTripulacion(TripulacionDTO tripulacion) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "UPDATE Tripulacion SET nombre = ?, barco = ? WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, tripulacion.getNombre());
            ps.setString(2, tripulacion.getBarco());
            ps.setLong(3, tripulacion.getId());
            int filas = ps.executeUpdate();
            conexion.close();
            if (filas == 0) System.out.println("No se encontró ninguna tripulación con id " + tripulacion.getId());
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarTripulacion(long id) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "UPDATE Tripulacion SET estaActiva = FALSE WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setLong(1, id);
            int filas = ps.executeUpdate();
            conexion.close();
            if (filas == 0) System.out.println("No se encontró ninguna tripulación con id " + id);
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            return false;
        }
    }
}