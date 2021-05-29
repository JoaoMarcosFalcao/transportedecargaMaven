import Controller.RotaNegocioController;
import Model.Rota;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RotaTeste {

    RotaNegocioController rotaNegocioController = new RotaNegocioController();

    @Test
    public void procurarRotaPorID() {
        int id = 1;
        Rota rota = rotaNegocioController.procurarPorId(id);
        assertTrue(rota.getId() != 0);
    }
}
