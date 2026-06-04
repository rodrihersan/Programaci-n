package controlador;

import modelo.MatriculaDAO;

public class MatriculaController {

	public boolean matricularAlumno(int idAlumno, int idCurso, String fecha) {
	    MatriculaDAO matriculaDAO = new MatriculaDAO();
	    return matriculaDAO.matricularAlumno(idAlumno, idCurso, fecha);
	}
}
