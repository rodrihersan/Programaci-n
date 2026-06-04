package modelo;

public class MatriculaDTO {
    private int idAlumno;
    private int idCurso;
    private String fecha;

    public MatriculaDTO(int idAlumno, int idCurso, String fecha) {
        super();
        this.idAlumno = idAlumno;
        this.idCurso = idCurso;
        this.fecha = fecha;
    }

    public int getIdAlumno() { return idAlumno; }
    public void setIdAlumno(int idAlumno) { this.idAlumno = idAlumno; }
    public int getIdCurso() { return idCurso; }
    public void setIdCurso(int idCurso) { this.idCurso = idCurso; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}