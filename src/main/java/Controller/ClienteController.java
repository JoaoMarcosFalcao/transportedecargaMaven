package Controller;

import Model.Cliente;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ClienteController {

    private Cliente cliente;
    private static AtomicInteger id_generator = new AtomicInteger(0);
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public void cadastrarCliente() {
        cliente = new Cliente();

        Scanner leia = new Scanner(System.in);

        cliente.setId(id_generator.getAndIncrement());

        System.out.println("Informe o Nome do Cliente:");
         cliente.setNome(leia.next());

        System.out.println("Informe o email do Cliente:");
        cliente.setEmail(leia.next());

        System.out.println("Informe o CPF do Cliente:");
        cliente.setCpf(leia.next());

        clientes.add(cliente);

    }
    public Cliente listarClientes(long id) {
        for (Cliente cliente : clientes) {
            if(cliente.getId() == id) {
                return cliente;
            }
        }


        return null;


    }
    public void editarClientes(long id) {
        int log = 0;
        for (Cliente cliente : clientes) {
            if(cliente.getId() == id) {

                Cliente clienteNovo = new Cliente();
                Scanner leia = new Scanner(System.in);

                System.out.println("Informe o Novo Nome do Cliente:");
                clienteNovo.setNome(leia.next());

                System.out.println("Informe o Novo email do Cliente:");
                clienteNovo.setEmail(leia.next());

                System.out.println("Informe o Novo CPF do CLiente:");
                clienteNovo.setCpf(leia.next());

                clientes.set(log, clienteNovo);

            }
            log++;
        }
    }
    public void deletarCliente(long id) {
        int log = 0;
        for (Cliente cliente : clientes) {
            if(cliente.getId() == id) {
                clientes.remove(log);
            }
            log++;
        }
    }
}

