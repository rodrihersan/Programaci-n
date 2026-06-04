package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.ConexionBBDD;

public class RecompensaDAO {

    public void listarRecompensas() {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "SELECT r.id, p.nombre AS pirata, t.nombre AS tripulacion, r.cantidad, r.estaVigente " +
                         "FROM Recompensa r " +
                         "JOIN Pirata p ON r.pirata_id = p.id " +
                         "LEFT JOIN Reclutamiento rec ON p.id = rec.pirata_id AND rec.esMiembroActual = TRUE " +
                         "LEFT JOIN Tripulacion t ON rec.tripulacion_id = t.id";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("Recompensas");
            System.out.println("--------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String pirata = rs.getString("pirata");
                String tripulacion = rs.getString("tripulacion");
                double cantidad = rs.getDouble("cantidad");
                boolean vigente = rs.getBoolean("estaVigente");
                System.out.println(id + " | Pirata: " + pirata +
                        " | Tripulacion: " + (tripulacion != null ? tripulacion : "Sin tripulacion") +
                        " | Cantidad: " + cantidad + " berries" +
                        " | Vigente: " + vigente);
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Transacción emitir recompensa
    public boolean emitirRecompensa(int pirataId, double cantidad) {
        Connection conexion = null;
        try {
            conexion = ConexionBBDD.getConexion();
            conexion.setAutoCommit(false);

            // 1. Verificar que el pirata existe y está activo
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

            // 2. Verificar que la cantidad sea mayor que 0
            if (cantidad <= 0) {
                System.out.println("La recompensa debe ser mayor que 0.");
                conexion.rollback();
                conexion.close();
                return false;
            }

            // 3. Desactivar recompensa anterior si existe
            String sqlDesactivar = "UPDATE Recompensa SET estaVigente = FALSE WHERE pirata_id = ? AND estaVigente = TRUE";
            PreparedStatement psDesactivar = conexion.prepareStatement(sqlDesactivar);
            psDesactivar.setInt(1, pirataId);
            psDesactivar.executeUpdate();

            // 4. Insertar nueva recompensa
            String sqlRecompensa = "INSERT INTO Recompensa (pirata_id, cantidad, estaVigente) VALUES (?, ?, TRUE)";
            PreparedStatement psRecompensa = conexion.prepareStatement(sqlRecompensa);
            psRecompensa.setInt(1, pirataId);
            psRecompensa.setDouble(2, cantidad);
            psRecompensa.executeUpdate();

            // 5. Registrar en TesoreriaMarina
            String sqlTesoreria = "INSERT INTO TesoreriaMarina (importe, tipoOperacion) VALUES (?, 'EMISION RECOMPENSA')";
            PreparedStatement psTesoreria = conexion.prepareStatement(sqlTesoreria);
            psTesoreria.setDouble(1, -10000.00);
            psTesoreria.executeUpdate();

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
