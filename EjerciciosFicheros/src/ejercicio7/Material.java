package ejercicio7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Material {

    protected int id;
    protected String tipo; // L o R
    protected String titulo;
    protected String autor;
    protected int anioPublicacion;
    protected boolean prestado;

    protected static boolean idRepetido(int id) throws IOException {
        boolean enc = false;
        File f = new File("biblioteca.txt");
        if (f.exists()) {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null && enc == false) {
                String[] datos = linea.split(",");
                int idLeido = Integer.parseInt(datos[0].trim());
                if (id == idLeido) {
                    enc = true;
                    System.out.println("ID Repetido");
                }
                linea = br.readLine();
            }
            br.close();
            fr.close();
        }
        return enc;
    }

    public int getId() { return id; }
    public String getTipo() { return tipo; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public boolean isPrestado() { return prestado; }
    public void setPrestado(boolean prestado) { this.prestado = prestado; }
}
