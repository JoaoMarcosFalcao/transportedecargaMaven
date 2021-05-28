package Controller;

import Model.Cliente;
import Model.dao.ClienteDao;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class ClienteController {

    private ClienteDao clienteDao;
    private Cliente cliente;
    private static AtomicInteger id_generator = new AtomicInteger(0);
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public Cliente preencher() {
        cliente = new Cliente();

        Scanner leia = new Scanner(System.in);

        cliente.setId(id_generator.getAndIncrement());

        System.out.println("Informe o Nome do Cliente:");
        cliente.setNome(leia.next());

        System.out.println("Informe o email do Cliente:");
        cliente.setEmail(leia.next());

        System.out.println("Informe o CPF do Cliente:");
        cliente.setCpf(leia.next());

        System.out.println("Informe o ID do Telefone:");
        cliente.setIdTelefone(leia.nextInt());

        System.out.println("Informe o ID do Endereco:");
        cliente.setIdEndereco(leia.nextInt());


        clientes.add(cliente);

        return cliente;

    }
//
//    public void editarClientes(long id) {
//        int log = 0;
//        for (Cliente cliente : clientes) {
//            if (cliente.getId() == id) {
//
//                Cliente clienteNovo = new Cliente();
//                Scanner leia = new Scanner(System.in);
//
//                System.out.println("Informe o Novo Nome do Cliente:");
//                clienteNovo.setNome(leia.next());
//
//                System.out.println("Informe o Novo email do Cliente:");
//                clienteNovo.setEmail(leia.next());
//
//                System.out.println("Informe o Novo CPF do CLiente:");
//                clienteNovo.setCpf(leia.next());
//
//                clientes.set(log, clienteNovo);
//
//            }
//            log++;
//        }
//    }
//
//    public void deletarCliente(long id) {
//        int log = 0;
//        for (Cliente cliente : clientes) {
////            if (cliente.getId() == id) {
////                clientes.remove(log);
////            }
////            log++;
////        }
////    }


    // METODOS NOVOS


    public void printarCliente(Cliente cliente) {
        System.out.println();
        System.out.println("O Nome do Cliente é: " + cliente.getNome());
        System.out.println("O Email do Cliente é: " + cliente.getEmail());
        System.out.println("O CPF do Cliente é: " + cliente.getCpf());
        System.out.println("O Telefone do Cliente é: " + cliente.getIdTelefone());
        System.out.println("O Enderenço do Clietne é: " + cliente.getIdEndereco());

        System.out.println();
    }

    public ArrayList<Cliente> listarClientes() {
        clienteDao = new ClienteDao();
        ArrayList<Cliente> clientes = clienteDao.listarClientes();
        return clientes;
    }

    public boolean salvarCliente() {
        Cliente cliente = preencher();
        clienteDao = new ClienteDao();
        boolean isSalvo = clienteDao.salvarCliente(cliente);
        return isSalvo;
    }

    public boolean editarClientes() {
        clienteDao = new ClienteDao();
        int id = digitarId();
        Cliente cliente = preencher();
        cliente.setId(id);
        boolean isSalvo = clienteDao.editarCliente(cliente);
        return isSalvo;
    }

    public boolean deletarCliente() {
        clienteDao = new ClienteDao();
        int id = digitarId();
        boolean isSalvo = clienteDao.deletarCliente(id);
        return isSalvo;
    }

    public void printAll(ArrayList<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            printarCliente(cliente);
        }
    }
    public Cliente procurarPorId(int id) {
        clienteDao = new ClienteDao();
        Cliente cliente = clienteDao.buscarClientePorId(id);
        return cliente;
}
    public int digitarId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Qual o ID do Cliente que deseja modificar? ");
        int id = input.nextInt();
        return id;
    }
}