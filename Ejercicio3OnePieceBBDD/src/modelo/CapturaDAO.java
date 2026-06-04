package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.ConexionBBDD;

public class CapturaDAO {

    public void listarCapturas() {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "SELECT c.id, p.nombre AS pirata, c.lugarCaptura, c.fechaCaptura, c.recompensaCobrada " +
                         "FROM Captura c " +
                         "JOIN Pirata p ON c.pirata_id = p.id";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("Capturas");
            System.out.println("--------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String pirata = rs.getString("pirata");
                String lugar = rs.getString("lugarCaptura");
                String fecha = rs.getString("fechaCaptura");
                double recompensa = rs.getDouble("recompensaCobrada");
                System.out.println(id + " | Pirata: " + pirata + " | Lugar: " + lugar + " | Fecha: " + fecha + " | Recompensa cobrada: " + recompensa + " berries");
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Transacción registrar captura
    public boolean registrarCaptura(int pirataId, String lugarCaptura) {
        Connection conexion = null;
        try {
            conexion = ConexionBBDD.getConexion();
            conexion.setAutoCommit(false);

            // 1. Comprobar que el pirata existe y está activo
            String sqlPirata = "SELECT id FROM Pirata WHERE id = ? AND estaActivo = TRUE";
            PreparedStatement psPirata = conexion.prepareStatement(sqlPirata);
            psPirata.setInt(1, pirataId);
            ResultSet rsPirata = psPirata.executeQuery();
            if (!rsPirata.next()) {
                System.out.println("No existe ningún pirata activo con id " + pirataId);
                conexion.rollback();
                conexion.close();
                return false;
            }

            // 2. Comprobar si tiene recompensa vigente
            String sqlRecompensa = "SELECT id, cantidad FROM Recompensa WHERE pirata_id = ? AND estaVigente = TRUE";
            PreparedStatement psRecompensa = conexion.prepareStatement(sqlRecompensa);
            psRecompensa.setInt(1, pirataId);
            ResultSet rsRecompensa = psRecompensa.executeQuery();

            double recompensaCobrada = 0;

            if (rsRecompensa.next()) {
                int recompensaId = rsRecompensa.getInt("id");
                recompensaCobrada = rsRecompensa.getDouble("cantidad");

                // Marcar recompensa como no vigente
                String sqlDesactivar = "UPDATE Recompensa SET estaVigente = FALSE WHERE id = ?";
                PreparedStatement psDesactivar = conexion.prepareStatement(sqlDesactivar);
                psDesactivar.setInt(1, recompensaId);
                psDesactivar.executeUpdate();

                // Registrar en TesoreriaMarina
                String sqlTesoreria = "INSERT INTO TesoreriaMarina (importe, tipoOperacion) VALUES (?, 'PAGO_RECOMPENSA_CAPTURA')";
                PreparedStatement psTesoreria = conexion.prepareStatement(sqlTesoreria);
                psTesoreria.setDouble(1, -recompensaCobrada);
                psTesoreria.executeUpdate();
            }

            // 3. Insertar la captura
            String sqlCaptura = "INSERT INTO Captura (pirata_id, lugarCaptura, recompensaCobrada) VALUES (?, ?, ?)";
            PreparedStatement psCaptura = conexion.prepareStatement(sqlCaptura);
            psCaptura.setInt(1, pirataId);
            psCaptura.setString(2, lugarCaptura);
            psCaptura.setDouble(3, recompensaCobrada);
            psCaptura.executeUpdate();

            // 4. Marcar al pirata como inactivo
            String sqlPirataInactivo = "UPDATE Pirata SET estaActivo = FALSE WHERE id = ?";
            PreparedStatement psPirataInactivo = conexion.prepareStatement(sqlPirataInactivo);
            psPirataInactivo.setInt(1, pirataId);
            psPirataInactivo.executeUpdate();

            // 5. Marcar reclutamiento activo como no actual
            String sqlReclutamiento = "UPDATE Reclutamiento SET esMiembroActual = FALSE WHERE pirata_id = ? AND esMiembroActual = TRUE";
            PreparedStatement psReclutamiento = conexion.prepareStatement(sqlReclutamiento);
            psReclutamiento.setInt(1, pirataId);
            psReclutamiento.executeUpdate();

            conexion.commit();
            conexion.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error en la transacción: " + e.getMessage());
            e.printStackTrace();
            try {
                if (conexion != null) {
                    conexion.rollback();
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al hacer rollback: " + ex.getMessage());
            }
            return false;
        }
    }
}