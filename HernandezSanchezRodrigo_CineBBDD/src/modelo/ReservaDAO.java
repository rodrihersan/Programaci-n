package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.ConexionBBDD;

public class ReservaDAO {
	public ArrayList<ReservaDTO> obtenerTodasLasReservas() {
	    ArrayList<ReservaDTO> listaReserva = new ArrayList<>();
	    try {
	        Connection conexion = ConexionBBDD.getConexion();
	        String sql = "SELECT r.id, p.titulo, s.hora, c.nombre, r.num_entradas, r.total " +
	                     "FROM clientes c " +
	                     "JOIN reservas r ON r.id_cliente = c.id " +
	                     "JOIN sesiones s ON r.id_sesion = s.id " +
	                     "JOIN peliculas p ON s.id_pelicula = p.id ";
	        PreparedStatement ps = conexion.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String tituloPelicula = rs.getString("titulo");
	            String hora = rs.getString("hora");
	            int numEntradas = rs.getInt("num_entradas");
	            double total = rs.getDouble("total");
	            listaReserva.add(new ReservaDTO(id, tituloPelicula, hora, numEntradas, total));
	        }
	        conexion.close();
	        return listaReserva;
	    } catch (SQLException e) {
	        System.out.println("Error en la BBDD: " + e.getMessage());
	        e.printStackTrace();
	        return listaReserva;
	    }
	}
	
	public boolean programarReserva(int idSesion, int idCliente, int numEntradas) {
	    Connection conexion = null;
	    try {
	        conexion = ConexionBBDD.getConexion();
	        conexion.setAutoCommit(false);

	        String sqlSesion = "SELECT asientos_disponibles, precio FROM sesiones WHERE id = ?";
	        PreparedStatement psSesion = conexion.prepareStatement(sqlSesion);
	        psSesion.setInt(1, idSesion);
	        ResultSet rsSesion = psSesion.executeQuery();
	        if (!rsSesion.next()) {
	            System.out.println("No existe ninguna sesion con id " + idSesion);
	            conexion.rollback();
	            conexion.close();
	            return false;
	        }
	        int asientosDisponibles = rsSesion.getInt("asientos_disponibles");
	        double precio = rsSesion.getDouble("precio");

	        if (asientosDisponibles < numEntradas) {
	            System.out.println("No hay suficientes asientos. Disponibles: " + asientosDisponibles);
	            conexion.rollback();
	            conexion.close();
	            return false;
	        }

	        String sqlCliente = "SELECT id FROM clientes WHERE id = ?";
	        PreparedStatement psCliente = conexion.prepareStatement(sqlCliente);
	        psCliente.setInt(1, idCliente);
	        ResultSet rsCliente = psCliente.executeQuery();
	        if (!rsCliente.next()) {
	            System.out.println("No existe ningun cliente con id " + idCliente);
	            conexion.rollback();
	            conexion.close();
	            return false;
	        }

	        double total = precio * numEntradas;
	        String sqlReserva = "INSERT INTO reservas (id_sesion, id_cliente, num_entradas, total) VALUES (?, ?, ?, ?)";
	        PreparedStatement psReserva = conexion.prepareStatement(sqlReserva);
	        psReserva.setInt(1, idSesion);
	        psReserva.setInt(2, idCliente);
	        psReserva.setInt(3, numEntradas);
	        psReserva.setDouble(4, total);
	        psReserva.executeUpdate();

	        String sqlActualizar = "UPDATE sesiones SET asientos_disponibles = asientos_disponibles - ? WHERE id = ?";
	        PreparedStatement psActualizar = conexion.prepareStatement(sqlActualizar);
	        psActualizar.setInt(1, numEntradas);
	        psActualizar.setInt(2, idSesion);
	        psActualizar.executeUpdate();

	        conexion.commit();
	        conexion.close();
	        System.out.println("Reserva realizada correctamente. Total: " + total + " EUR");
	        return true;

	    } catch (SQLException e) {
	        System.out.println("Error en la transaccion: " + e.getMessage());
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
