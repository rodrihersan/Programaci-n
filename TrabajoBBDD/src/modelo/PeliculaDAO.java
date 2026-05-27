package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Utils.ConexionBBDD;

public class PeliculaDAO {

	public ArrayList<PeliculaDTO> obtenerTodasLasPeliculas() {

		ArrayList<PeliculaDTO> listaPeliculas = new ArrayList<PeliculaDTO>();

		Connection conexion = ConexionBBDD.getConexion();

		try {
			String sql = "SELECT * FROM peliculas";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id        = rs.getInt("id");
	            String titulo = rs.getString("titulo");
	            String genero = rs.getString("genero");
	            int duracion  = rs.getInt("duracion");
	            int anio      = rs.getInt("anio");
	            PeliculaDTO pelicula = new PeliculaDTO(id, titulo, genero, duracion, anio);
	            listaPeliculas.add(pelicula);
			}

			conexion.close();
			return listaPeliculas;

		} catch (SQLException e) {
			e.printStackTrace();
			return listaPeliculas;
		}

	}

	public boolean insertarPelicula(PeliculaDTO pelicula) {
		try {
			Connection conexion = ConexionBBDD.getConexion();
			// Preparamos la consulta
			String sql = "INSERT INTO pelicula (titulo, genero, duracion, anio) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			// Rellenamos los parámetros en orden
			ps.setString(1, pelicula.getNombrePelicula());
	        ps.setString(2, pelicula.getGenero());
	        ps.setInt(3, pelicula.getDuracion());
	        ps.setInt(4, pelicula.getAnio());


			int filasAfectadas = ps.executeUpdate();
			
			// Obtenemos el id generado
			ResultSet keys = ps.getGeneratedKeys();
			int idGenerado = -1;
			System.out.println(keys.next());
			idGenerado = keys.getInt(1);
	
			System.out.println("EL ID GENERADO ES " + idGenerado);
			
			conexion.close();
			// Si se insertó al menos una fila, devolvemos true
			return filasAfectadas > 0;
		} catch (SQLException e) {
			System.out.println("Error en la BBDD: " + e.getMessage());
			return false;
		}
	}

}