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
        public void listarCliente () {
            ArrayList<Cliente> clientes = clienteController.listarClientes();
            assertFalse(clientes.isEmpty());
            assertEquals(clientes.size(), clienteTeste.size());
            assertEquals(clienteTeste.get(0).getCpf(), clienteTeste.get(0).getCpf());

            Cliente cliente = new Cliente();
            cliente.setCpf("123456789");
            assertEquals(cliente.getCpf(), clienteController.listarClientes().get(0).getCpf());
        }
    }


