/*
1. Listar sesiones de una película concreta (el usuario introduce el título o id)

// SesionDAO
public ArrayList<SesionDTO> obtenerSesionesPorPelicula(int idPelicula) {
    ArrayList<SesionDTO> lista = new ArrayList<>();
    try {
        Connection conexion = ConexionBBDD.getConexion();
        String sql = "SELECT s.id, p.titulo, sa.numero, s.fecha, s.hora, s.precio, s.asientos_disponibles " +
                     "FROM sesiones s " +
                     "JOIN peliculas p ON s.id_pelicula = p.id " +
                     "JOIN salas sa ON s.id_sala = sa.id " +
                     "WHERE s.id_pelicula = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idPelicula);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String titulo = rs.getString("titulo");
            int numero = rs.getInt("numero");
            String fecha = rs.getString("fecha");
            String hora = rs.getString("hora");
            double precio = rs.getDouble("precio");
            int asientos = rs.getInt("asientos_disponibles");
            lista.add(new SesionDTO(id, titulo, numero, fecha, hora, precio, asientos));
        }
        conexion.close();
        return lista;
    } catch (SQLException e) {
        System.out.println("Error en la BBDD: " + e.getMessage());
        e.printStackTrace();
        return lista;
    }
}

2. Listar sesiones con asientos disponibles (sesiones que no están llenas)

public ArrayList<SesionDTO> obtenerSesionesConAsientos() {
    ArrayList<SesionDTO> lista = new ArrayList<>();
    try {
        Connection conexion = ConexionBBDD.getConexion();
        String sql = "SELECT s.id, p.titulo, sa.numero, s.fecha, s.hora, s.precio, s.asientos_disponibles " +
                     "FROM sesiones s " +
                     "JOIN peliculas p ON s.id_pelicula = p.id " +
                     "JOIN salas sa ON s.id_sala = sa.id " +
                     "WHERE s.asientos_disponibles > 0";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String titulo = rs.getString("titulo");
            int numero = rs.getInt("numero");
            String fecha = rs.getString("fecha");
            String hora = rs.getString("hora");
            double precio = rs.getDouble("precio");
            int asientos = rs.getInt("asientos_disponibles");
            lista.add(new SesionDTO(id, titulo, numero, fecha, hora, precio, asientos));
        }
        conexion.close();
        return lista;
    } catch (SQLException e) {
        System.out.println("Error en la BBDD: " + e.getMessage());
        e.printStackTrace();
        return lista;
    }
}

3. Listar reservas de un cliente (JOIN entre reservas, sesiones y peliculas)
Necesitarías un ReservaDTO nuevo. El DTO sería:
// modelo/ReservaDTO.java
package modelo;

public class ReservaDTO {
    private int id;
    private String tituloPelicula;
    private String fecha;
    private String hora;
    private int numEntradas;
    private double total;

    public ReservaDTO(int id, String tituloPelicula, String fecha, String hora, int numEntradas, double total) {
        this.id = id;
        this.tituloPelicula = tituloPelicula;
        this.fecha = fecha;
        this.hora = hora;
        this.numEntradas = numEntradas;
        this.total = total;
    }

    public int getId() { return id; }
    public String getTituloPelicula() { return tituloPelicula; }
    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public int getNumEntradas() { return numEntradas; }
    public double getTotal() { return total; }
}


// ReservaDAO
public ArrayList<ReservaDTO> obtenerReservasPorCliente(int idCliente) {
    ArrayList<ReservaDTO> lista = new ArrayList<>();
    try {
        Connection conexion = ConexionBBDD.getConexion();
        String sql = "SELECT r.id, p.titulo, s.fecha, s.hora, r.num_entradas, r.total " +
                     "FROM reservas r " +
                     "JOIN sesiones s ON r.id_sesion = s.id " +
                     "JOIN peliculas p ON s.id_pelicula = p.id " +
                     "WHERE r.id_cliente = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idCliente);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String titulo = rs.getString("titulo");
            String fecha = rs.getString("fecha");
            String hora = rs.getString("hora");
            int numEntradas = rs.getInt("num_entradas");
            double total = rs.getDouble("total");
            lista.add(new ReservaDTO(id, titulo, fecha, hora, numEntradas, total));
        }
        conexion.close();
        return lista;
    } catch (SQLException e) {
        System.out.println("Error en la BBDD: " + e.getMessage());
        e.printStackTrace();
        return lista;
    }
}


4. Listar películas de un género concreto
public ArrayList<PeliculaDTO> obtenerPeliculasPorGenero(String genero) {
    ArrayList<PeliculaDTO> lista = new ArrayList<>();
    try {
        Connection conexion = ConexionBBDD.getConexion();
        String sql = "SELECT id, titulo, genero, duracion, anio FROM peliculas WHERE genero = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, genero);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String titulo = rs.getString("titulo");
            String gen = rs.getString("genero");
            int duracion = rs.getInt("duracion");
            int anio = rs.getInt("anio");
            lista.add(new PeliculaDTO(id, titulo, gen, duracion, anio));
        }
        conexion.close();
        return lista;
    } catch (SQLException e) {
        System.out.println("Error en la BBDD: " + e.getMessage());
        e.printStackTrace();
        return lista;
    }
}

-----------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------

TRANSACCIÓN — posibilidades
5. Hacer una reserva (la más probable) — el usuario introduce id de sesión, id de cliente y número de entradas
// SesionDAO o ReservaDAO
public boolean hacerReserva(int idSesion, int idCliente, int numEntradas) {
    Connection conexion = null;
    try {
        conexion = ConexionBBDD.getConexion();
        conexion.setAutoCommit(false);

        // 1. Comprobar que la sesion existe y tiene asientos suficientes
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

        // 2. Comprobar que el cliente existe
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

        // 3. Insertar la reserva
        double total = precio * numEntradas;
        String sqlReserva = "INSERT INTO reservas (id_sesion, id_cliente, num_entradas, total) VALUES (?, ?, ?, ?)";
        PreparedStatement psReserva = conexion.prepareStatement(sqlReserva);
        psReserva.setInt(1, idSesion);
        psReserva.setInt(2, idCliente);
        psReserva.setInt(3, numEntradas);
        psReserva.setDouble(4, total);
        psReserva.executeUpdate();

        // 4. Actualizar asientos disponibles en la sesion
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


6. Cancelar una reserva — el usuario introduce el id de la reserva
public boolean cancelarReserva(int idReserva) {
    Connection conexion = null;
    try {
        conexion = ConexionBBDD.getConexion();
        conexion.setAutoCommit(false);

        // 1. Obtener datos de la reserva
        String sqlReserva = "SELECT id_sesion, num_entradas FROM reservas WHERE id = ?";
        PreparedStatement psReserva = conexion.prepareStatement(sqlReserva);
        psReserva.setInt(1, idReserva);
        ResultSet rsReserva = psReserva.executeQuery();
        if (!rsReserva.next()) {
            System.out.println("No existe ninguna reserva con id " + idReserva);
            conexion.rollback();
            conexion.close();
            return false;
        }
        int idSesion = rsReserva.getInt("id_sesion");
        int numEntradas = rsReserva.getInt("num_entradas");

        // 2. Borrar la reserva
        String sqlBorrar = "DELETE FROM reservas WHERE id = ?";
        PreparedStatement psBorrar = conexion.prepareStatement(sqlBorrar);
        psBorrar.setInt(1, idReserva);
        psBorrar.executeUpdate();

        // 3. Devolver los asientos a la sesion
        String sqlAsientos = "UPDATE sesiones SET asientos_disponibles = asientos_disponibles + ? WHERE id = ?";
        PreparedStatement psAsientos = conexion.prepareStatement(sqlAsientos);
        psAsientos.setInt(1, numEntradas);
        psAsientos.setInt(2, idSesion);
        psAsientos.executeUpdate();

        conexion.commit();
        conexion.close();
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

*/