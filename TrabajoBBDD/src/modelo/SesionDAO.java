package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Utils.ConexionBBDD;

public class SesionDAO {
	public ArrayList<SesionDTO> obtenerTodasLasSesiones() {
		
		ArrayList<SesionDTO> listaSesiones = new ArrayList<>();

		try {
			Connection conexion = ConexionBBDD.getConexion();
			String sql = "SELECT s.id, p.titulo, sa.numero, s.fecha, s.hora, s.precio, s.asientos_disponibles " + "FROM sesiones s " + "JOIN peliculas p ON s.id_pelicula = p.id " + "JOIN salas sa ON s.id_sala = sa.id";

			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String titulo = rs.getString("titulo");
				int numero = rs.getInt("numero");
				String fecha = rs.getString("fecha");
				String hora = rs.getString("hora");
				double precio = rs.getDouble("precio");
				int asientosDisponibles = rs.getInt("asientos_disponibles");

				SesionDTO sesion = new SesionDTO(id, titulo, numero, fecha, hora, precio, asientosDisponibles);
				listaSesiones.add(sesion);
			}
			conexion.close();
			return listaSesiones;
		} catch (SQLException e) {
			System.out.println("Error en la BBDD: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean borrarSesion(int id) {
		
		try {
			String sql = "DELETE FROM sesiones WHERE id = ?";
			Connection conexion = ConexionBBDD.getConexion();
			
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);

			int filasAfectadas = ps.executeUpdate();

			if (filasAfectadas == 0) {
				System.out.println("No se encontró ninguna sesión con id " + id);
			}
			conexion.close();
			return filasAfectadas > 0;
		} catch (SQLException e) {
			System.out.println("Error la sesion: " + e.getMessage());
			return false;
		}
	}
	
	public boolean programarSesion(int idPelicula, int idSala, String fecha, String hora, double precio) {
		Connection conexion = null;
        
		try {
            conexion = ConexionBBDD.getConexion(); //se obtiene la conexion
            conexion.setAutoCommit(false);//desactivacion autoCommit

            //nos aseguramos si la sala esta ocupada a esa hora y dia (AND)
            String sqlComprobar = "SELECT COUNT(*) FROM sesiones WHERE id_sala = ? AND fecha = ? AND hora = ?";
            //no hacemos while rs.next porque count(*) devuelve una sola fila y no varias
            PreparedStatement psComprobar = conexion.prepareStatement(sqlComprobar);
            psComprobar.setInt(1, idSala);
            psComprobar.setString(2, fecha);
            psComprobar.setString(3, hora);
            ResultSet rs = psComprobar.executeQuery();
            rs.next();
            int ocupadas = rs.getInt(1); //rs.getInt(1) porque queremos el primer valor de la fila (resultado del count)
            psComprobar.close();

            //si se cumple s que esta ocupada a hora y fecha
            if (ocupadas > 0) {
                conexion.rollback();
                System.out.println("Error: la sala " + idSala + " ya tiene una sesión el " + fecha + " a las " + hora);
                return false;
            }

            String sqlAforo = "SELECT aforo FROM salas WHERE id = ?";
            PreparedStatement psAforo = conexion.prepareStatement(sqlAforo);
            psAforo.setInt(1, idSala);
            ResultSet rsAforo = psAforo.executeQuery();
            
            int aforo = 0;
            //validamos que exista o no el aforo. en este caso si no existe se hace rollback
            if (!rsAforo.next()) {
                conexion.rollback();
                System.out.println("Error: no existe ninguna sala con id " + idSala);
                return false;
            } else { //si existe cogemos el valor de campo aforo
                aforo = rsAforo.getInt("aforo");
                psAforo.close();
            }
            
            String sqlInsertar = "INSERT INTO sesiones (id_pelicula, id_sala, fecha, hora, precio, asientos_disponibles) " + "VALUES (?, ?, ?, ?, ?, ?)";
            
            PreparedStatement psInsertar = conexion.prepareStatement(sqlInsertar);
            psInsertar.setInt(1, idPelicula);
            psInsertar.setInt(2, idSala);
            psInsertar.setString(3, fecha);
            psInsertar.setString(4, hora);
            psInsertar.setDouble(5, precio);
            psInsertar.setInt(6, aforo);
            psInsertar.executeUpdate();
            psInsertar.close();

            //guardado
            conexion.commit();
            System.out.println("Sesión programada correctamente con " + aforo + " asientos disponibles.");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al programar la sesión: " + e.getMessage());
            if (conexion != null) {
                try {
                    conexion.rollback();
                    System.out.println("Cambios revertidos.");
                } catch (SQLException ex) {
                    System.out.println("Error en rollback: " + ex.getMessage());
                }
            }
            return false;
        } finally {
            if (conexion != null) {
                try {
                    conexion.setAutoCommit(true);
                    conexion.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar conexión: " + e.getMessage());
                }
            }
        }
    }
}
