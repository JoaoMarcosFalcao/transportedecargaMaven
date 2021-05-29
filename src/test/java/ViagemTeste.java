import Controller.ViagemController;
import Model.Viagem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ViagemTeste {

    ViagemController viagemController = new ViagemController();

    @Test
    public void procurarViagemPorID() {
        int id = 1;
        Viagem viagem = viagemController.procurarPorId(id);
        assertTrue(viagem.getId() != 0);
    }
}

