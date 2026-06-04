package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.ConexionBBDD;

public class DetallePedidoDAO {

    public ArrayList<DetallePedidoDTO> obtenerTodosLosDetalles() {
        ArrayList<DetallePedidoDTO> lista = new ArrayList<>();
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "SELECT id, id_pedido, id_producto, cantidad, precio_unitario FROM detalle_pedido";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int idPedido = rs.getInt("id_pedido");
                int idProducto = rs.getInt("id_producto");
                int cantidad = rs.getInt("cantidad");
                double precioUnitario = rs.getDouble("precio_unitario");
                lista.add(new DetallePedidoDTO(id, idPedido, idProducto, cantidad, precioUnitario));
            }
            conexion.close();
            return lista;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            e.printStackTrace();
            return lista;
        }
    }

    // Ejercicio 6 — JOIN con producto y pedido
    public void mostrarDetallesConJoin(int idPedido) {
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "SELECT dp.id, p.nombre AS producto, dp.cantidad, dp.precio_unitario, " +
                         "pe.fecha, pe.total " +
                         "FROM detalle_pedido dp " +
                         "JOIN producto p ON dp.id_producto = p.id " +
                         "JOIN pedido pe ON dp.id_pedido = pe.id " +
                         "WHERE dp.id_pedido = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();
            boolean hayResultados = false;
            while (rs.next()) {
                if (!hayResultados) {
                    String fecha = rs.getString("fecha");
                    double total = rs.getDouble("total");
                    System.out.println("Pedido #" + idPedido + " | Fecha: " + fecha + " | Total: " + total + " EUR");
                    System.out.println("--------------");
                    hayResultados = true;
                }
                int id = rs.getInt("id");
                String nombreProducto = rs.getString("producto");
                int cantidad = rs.getInt("cantidad");
                double precioUnitario = rs.getDouble("precio_unitario");
                System.out.println(id + " | " + nombreProducto + " | Cantidad: " + cantidad + " | Precio unitario: " + precioUnitario + " EUR");
            }
            if (!hayResultados) System.out.println("No se encontró ningún pedido con id " + idPedido);
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Ejercicio 8 — obtener detalles por idPedido para la transacción
    public ArrayList<DetallePedidoDTO> obtenerDetallesPorPedido(int idPedido) {
        ArrayList<DetallePedidoDTO> lista = new ArrayList<>();
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "SELECT id, id_pedido, id_producto, cantidad, precio_unitario FROM detalle_pedido WHERE id_pedido = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int idPed = rs.getInt("id_pedido");
                int idProducto = rs.getInt("id_producto");
                int cantidad = rs.getInt("cantidad");
                double precioUnitario = rs.getDouble("precio_unitario");
                lista.add(new DetallePedidoDTO(id, idPed, idProducto, cantidad, precioUnitario));
            }
            conexion.close();
            return lista;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            e.printStackTrace();
            return lista;
        }
    }
}
