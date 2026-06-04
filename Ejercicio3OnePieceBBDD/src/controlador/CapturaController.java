package controlador;

import modelo.CapturaDAO;

public class CapturaController {

    public void listarCapturas() {
        CapturaDAO capturaDAO = new CapturaDAO();
        capturaDAO.listarCapturas();
    }

    public boolean registrarCaptura(int pirataId, String lugarCaptura) {
        CapturaDAO capturaDAO = new CapturaDAO();
        return capturaDAO.registrarCaptura(pirataId, lugarCaptura);
    }
}