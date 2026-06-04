package controlador;

import java.util.ArrayList;
import modelo.AlumnoDAO;
import modelo.AlumnoDTO;

public class AlumnoController {

    public ArrayList<AlumnoDTO> obtenerTodosLosAlumnos() {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        return alumnoDAO.obtenerTodosLosAlumnos();
    }

    public ArrayList<AlumnoDTO> obtenerAlumnosPorEdadMaxima(int edadMaxima) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        return alumnoDAO.obtenerAlumnosPorEdadMaxima(edadMaxima);
    }

    public ArrayList<AlumnoDTO> obtenerAlumnosPorCurso(String nombreCurso) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        return alumnoDAO.obtenerAlumnosPorCurso(nombreCurso);
    }

    public boolean insertar(AlumnoDTO alumno) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        return alumnoDAO.insertarAlumno(alumno);
    }

    public boolean actualizar(AlumnoDTO alumno) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        return alumnoDAO.actualizarAlumno(alumno);
    }

    public boolean borrar(int id) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        return alumnoDAO.borrarAlumno(id);
    }
}