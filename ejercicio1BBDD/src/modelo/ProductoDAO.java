package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.ConexionBBDD;

public class ProductoDAO {

    public ArrayList<ProductoDTO> obtenerTodosLosProductos() {
        ArrayList<ProductoDTO> lista = new ArrayList<>();
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "SELECT id, nombre, precio, stock, id_categoria FROM producto";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                int idCategoria = rs.getInt("id_categoria");
                lista.add(new ProductoDTO(id, nombre, precio, stock, idCategoria));
            }
            conexion.close();
            return lista;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            e.printStackTrace();
            return lista;
        }
    }

    public ArrayList<ProductoDTO> obtenerProductosPorCategoria(int idCategoria) {
        ArrayList<ProductoDTO> lista = new ArrayList<>();
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "SELECT id, nombre, precio, stock, id_categoria FROM producto WHERE id_categoria = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idCategoria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                int idCat = rs.getInt("id_categoria");
                lista.add(new ProductoDTO(id, nombre, precio, stock, idCat));
            }
            conexion.close();
            return lista;
        } catch (SQLException e) {
            System.out.println("Error en la BBDD: " + e.getMessage());
            e.printStackTrace();
            return lista;
        }
    }

    public ArrayList<ProductoDTO> obtenerProductosConStockBajo(int maxStock) {
        ArrayList<ProductoDTO> lista = new ArrayList<>();
        try {
            Connection conexion = ConexionBBDD.getConexion();
            String sql = "SELECT id, nombre, precio, stock, id_categoria FROM producto WHERE stock <= ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, maxStock);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                int idCategoria = rs.getInt("id_categoria");
                lista.add(new ProductoDTO(id, nombre, precio, stock, idCategoria));
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
