import Controller.CargaNegocioController;
import Model.Carga;
import Model.TipoCarga;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class CargaTeste {

    CargaNegocioController cargaNegocioController = new CargaNegocioController();

    @Test
    public void editarCarga() {
        int id = 1;
        Carga carga = new Carga();
        carga.setPeso(600);
        carga.setAltura(2);
        carga.setComprimento(3);
        carga.setLargura(2);
        carga.setPesoOcupada(500);
        carga.setTipoCarga(TipoCarga.fragil);


        Carga cargaExists = cargaNegocioController.procurarPorId(id);
        assertTrue(!cargaNegocioController.editarCargas(carga));
    }
}
