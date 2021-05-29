import Controller.EnderecoController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class EnderecoTeste {

    EnderecoController enderecoController = new EnderecoController();

    @Test
    public void deletarEnderecoDoCliente() {
        int id = 2;
        assertTrue(enderecoController.deletarEnderecoDoCliente(id));
    }
}

