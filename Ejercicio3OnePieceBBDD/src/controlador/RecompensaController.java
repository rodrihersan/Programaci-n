package controlador;

import modelo.RecompensaDAO;

public class RecompensaController {

    public void listarRecompensas() {
        RecompensaDAO recompensaDAO = new RecompensaDAO();
        recompensaDAO.listarRecompensas();
    }

    public boolean emitirRecompensa(int pirataId, double cantidad) {
        RecompensaDAO recompensaDAO = new RecompensaDAO();
        return recompensaDAO.emitirRecompensa(pirataId, cantidad);
    }
}
