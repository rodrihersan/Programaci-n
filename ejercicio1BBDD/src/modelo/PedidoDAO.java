package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.ConexionBBDD;

public class PedidoDAO {

    public ArrayList<PedidoDTO> obtenerTodosLosPedidos() {
        ArrayList<PedidoDTO> lista = new ArrayList<>();
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "SELECT id, fecha, total FROM pedido";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fecha = rs.getString("fecha");
                double total = rs.getDouble("total");
                lista.add(new PedidoDTO(id, fecha, total));
            }
            conexion.close();
            return lista;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            e.printStackTrace();
            return lista;
        }
    }

    public ArrayList<PedidoDTO> obtenerPedidosPorFecha(String fecha) {
        ArrayList<PedidoDTO> lista = new ArrayList<>();
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "SELECT id, fecha, total FROM pedido WHERE fecha = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, fecha);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String f = rs.getString("fecha");
                double total = rs.getDouble("total");
                lista.add(new PedidoDTO(id, f, total));
            }
            conexion.close();
            return lista;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            e.printStackTrace();
            return lista;
        }
    }

    public ArrayList<PedidoDTO> obtenerPedidosPorTotalMinimo(double totalMinimo) {
        ArrayList<PedidoDTO> lista = new ArrayList<>();
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "SELECT id, fecha, total FROM pedido WHERE total >= ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setDouble(1, totalMinimo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fecha = rs.getString("fecha");
                double total = rs.getDouble("total");
                lista.add(new PedidoDTO(id, fecha, total));
            }
            conexion.close();
            return lista;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            e.printStackTrace();
            return lista;
        }
    }

    // Ejercicio 8 — transacción cancelación de pedido
    public boolean cancelarPedido(int idPedido) {
        Connection conexion = null;
        try {
            conexion = ConexionBBDD.getConexion();
            conexion.setAutoCommit(false);

            // 1. Obtener los detalles del pedido
            String sqlDetalles = "SELECT id_producto, cantidad FROM detalle_pedido WHERE id_pedido = ?";
            PreparedStatement psDetalles = conexion.prepareStatement(sqlDetalles);
            psDetalles.setInt(1, idPedido);
            ResultSet rs = psDetalles.executeQuery();

            ArrayList<int[]> lineas = new ArrayList<>();
            while (rs.next()) {
                int idProducto = rs.getInt("id_producto");
                int cantidad = rs.getInt("cantidad");
                lineas.add(new int[]{idProducto, cantidad});
            }

            if (lineas.isEmpty()) {
                System.out.println("No se encontró ningún pedido con id " + idPedido);
                conexion.rollback();
                conexion.close();
                return false;
            }

            // 2. Borrar los detalles del pedido
            String sqlBorrarDetalles = "DELETE FROM detalle_pedido WHERE id_pedido = ?";
            PreparedStatement psBorrarDetalles = conexion.prepareStatement(sqlBorrarDetalles);
            psBorrarDetalles.setInt(1, idPedido);
            psBorrarDetalles.executeUpdate();

            // 3. Devolver el stock a cada producto
            String sqlStock = "UPDATE producto SET stock = stock + ? WHERE id = ?";
            PreparedStatement psStock = conexion.prepareStatement(sqlStock);
            for (int[] linea : lineas) {
                psStock.setInt(1, linea[1]);
                psStock.setInt(2, linea[0]);
                psStock.executeUpdate();
            }

            // 4. Borrar el pedido
            String sqlBorrarPedido = "DELETE FROM pedido WHERE id = ?";
            PreparedStatement psBorrarPedido = conexion.prepareStatement(sqlBorrarPedido);
            psBorrarPedido.setInt(1, idPedido);
            psBorrarPedido.executeUpdate();

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