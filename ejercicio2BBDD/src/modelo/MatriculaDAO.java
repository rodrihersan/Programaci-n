package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.ConexionBBDD;

public class MatriculaDAO {

    public boolean matricularAlumno(int idAlumno, int idCurso, String fecha) {
        Connection conexion = null;
        try {
            conexion = ConexionBBDD.getConexion();
            conexion.setAutoCommit(false);

            // 1. Comprobar que el alumno existe
            String sqlAlumno = "SELECT id FROM alumno WHERE id = ?";
            PreparedStatement psAlumno = conexion.prepareStatement(sqlAlumno);
            psAlumno.setInt(1, idAlumno);
            ResultSet rsAlumno = psAlumno.executeQuery();
            if (!rsAlumno.next()) {
                System.out.println("No existe ningún alumno con id " + idAlumno);
                conexion.rollback();
                conexion.close();
                return false;
            }

            // 2. Comprobar que el curso existe
            String sqlCurso = "SELECT id FROM curso WHERE id = ?";
            PreparedStatement psCurso = conexion.prepareStatement(sqlCurso);
            psCurso.setInt(1, idCurso);
            ResultSet rsCurso = psCurso.executeQuery();
            if (!rsCurso.next()) {
                System.out.println("No existe ningún curso con id " + idCurso);
                conexion.rollback();
                conexion.close();
                return false;
            }

            // 3. Insertar la matrícula
            String sqlMatricula = "INSERT INTO matricula (id_alumno, id_curso, fecha) VALUES (?, ?, ?)";
            PreparedStatement psMatricula = conexion.prepareStatement(sqlMatricula);
            psMatricula.setInt(1, idAlumno);
            psMatricula.setInt(2, idCurso);
            psMatricula.setString(3, fecha);
            psMatricula.executeUpdate();

            conexion.commit();
            conexion.close();
            return true;

        } catch (SQLException e) {
            // 4. Si la matrícula ya existe (clave duplicada) o cualquier otro error
            if (e.getErrorCode() == 1062) {
                System.out.println("Ese alumno ya está matriculado en ese curso.");
            } else {
                System.out.println("Error en la transacción: " + e.getMessage());
                e.printStackTrace();
            }
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