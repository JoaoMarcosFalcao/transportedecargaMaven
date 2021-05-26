import Controller.ClienteController;
import Model.Cliente;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTeste {
    ClienteController clienteController = new ClienteController();
    ArrayList<Cliente> clienteTeste = clienteController.listarClientes();
    @Test
    public void testeDoCadastro() {
    }
        @Test
        void listar () {
            ArrayList<Cliente> clientes = clienteController.listarClientes();
            assertEquals(clienteTeste.get(0).getCpf(), clienteTeste.get(0).getCpf());
        }
    }


