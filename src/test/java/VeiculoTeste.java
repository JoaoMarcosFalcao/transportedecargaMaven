import Controller.VeiculoController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VeiculoTeste {

    VeiculoController veiculoController = new VeiculoController();

    @Test
    public void deletarVeiculo() {
        int id = 1;
        assertTrue(veiculoController.deletarVeiculo(id));
}
}
