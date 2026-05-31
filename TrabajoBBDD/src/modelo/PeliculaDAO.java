package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.ConexionBBDD;

public class PeliculaDAO {
	public ArrayList<PeliculaDTO> obtenerTodasLasPeliculas() {
		
		ArrayList<PeliculaDTO> listaPeliculas  = new ArrayList<>();
		
		try {
			Connection conexion = ConexionBBDD.getConexion();
			String sql = "SELECT id, titulo, genero, duracion, anio FROM peliculas";
			
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
			System.out.println("Error en la BBDD: " + e.getMessage());
			e.printStackTrace();
			return listaPeliculas;
		}

	}

	public boolean insertarPelicula(PeliculaDTO pelicula) {
		try {
			Connection conexion = ConexionBBDD.getConexion();
			String sql = "INSERT INTO peliculas (titulo, genero, duracion, anio) VALUES (?, ?, ?, ?)";
			
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, pelicula.getTitulo());
	        ps.setString(2, pelicula.getGenero());
	        ps.setInt(3, pelicula.getDuracion());
	        ps.setInt(4, pelicula.getAnio());
			int filasAfectadas = ps.executeUpdate();
			
			conexion.close();
			return filasAfectadas > 0;
			
		} catch (SQLException e) {
			System.out.println("Error en la BBDD: " + e.getMessage());
			return false;
		}
	}
	
	public boolean editarPelicula(PeliculaDTO pelicula) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "UPDATE peliculas SET titulo = ?, genero = ?, duracion = ?, anio = ? WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getGenero());
            ps.setInt(3, pelicula.getDuracion());
            ps.setInt(4, pelicula.getAnio());
            ps.setInt(5, pelicula.getId());
            int filas = ps.executeUpdate();
            conexion.close();
            if (filas == 0) {
            	System.out.println("No se encontró ninguna película con id " + pelicula.getId());
            }
            
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            return false;
        }
    }
	
	public boolean borrarPelicula(int id) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            
            String sql = "DELETE FROM peliculas WHERE id = ?";
            
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            
            int filasAfectadas = ps.executeUpdate();
            conexion.close();
            if (filasAfectadas == 0) System.out.println("No se encontró ninguna película con id " + id);
            
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            return false;
        }
    }
}