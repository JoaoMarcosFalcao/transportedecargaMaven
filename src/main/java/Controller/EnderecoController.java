package Controller;

import Model.Endereco;
import Model.dao.EnderecoDao;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class EnderecoController {

    private EnderecoDao enderecoDao;
    private Endereco endereco;
    private static AtomicInteger id_generator = new AtomicInteger(0);
    private ArrayList<Endereco> enderecos = new ArrayList<Endereco>();

    public Endereco preencher() {
        endereco = new Endereco();
        Scanner leia = new Scanner(System.in);

        endereco.setId(id_generator.getAndIncrement());

        System.out.println("Informe o Nome da Rua:");
        endereco.setRua(leia.next());

        System.out.println("Informe o Número da Casa:");
        endereco.setNumero(leia.next());

        System.out.println("Informe o Nome do Bairro:");
        endereco.setBairro(leia.next());

        System.out.println("Informe o Nome da Cidade:");
        endereco.setCidade(leia.next());

        System.out.println("Informe o Nome do Estado:");
        endereco.setEstado(leia.next());

        endereco.setId(id_generator.getAndIncrement());
        System.out.println("O ID do endereco registrado é: " + endereco.getId());

        enderecos.add(endereco);


        return endereco;
    }
//
//    public void editarEndereco(long id) {
//        int log = 0;
//        for (Endereco endereco : enderecos) {
//            if (endereco.getId() == id) {
//
//                Endereco enderecoNovo = new Endereco();
//                Scanner leia = new Scanner(System.in);
//
//                System.out.println("Informe o Nome da Rua:");
//                enderecoNovo.setRua(leia.next());
//
//                System.out.println("Informe o Número da Casa:");
//                enderecoNovo.setNumero(leia.next());
//
//                System.out.println("Informe o Nome do Bairro:");
//                enderecoNovo.setBairro(leia.next());
//
//                System.out.println("Informe o Nome da Cidade:");
//                enderecoNovo.setCidade(leia.next());
//
//                System.out.println("Informe o Nome do Estado:");
//                enderecoNovo.setEstado(leia.next());
//
//                enderecos.set(log, enderecoNovo);
//
//            }
//            log++;
//        }
//    }
//
//    public void deletarEndereco(long id) {
//        int log = 0;
//        for (Endereco endereco : enderecos) {
//            if (endereco.getId() == id) {
//                enderecos.remove(log);
//            }
//            log++;
//        }


// METODOS NOVOS

    public ArrayList<Endereco> listarEnderecosDosClientes() {
        enderecoDao = new EnderecoDao();
        ArrayList<Endereco> enderecos = enderecoDao.listarEnderecosDosClientes();
        return enderecos;
    }

    public ArrayList<Endereco> listarEnderecosDosMotoristas() {
        enderecoDao = new EnderecoDao();
        ArrayList<Endereco> enderecos = enderecoDao.listarEnderecosDosMotoristas();
        return enderecos;
    }

    public void printarEndereco(Endereco endereco) {
        System.out.println();
        System.out.println("A Rua é:" + endereco.getRua());
        System.out.println("O Número da Casa é:" + endereco.getNumero());
        System.out.println("O Bairro é:" + endereco.getBairro());
        System.out.println("A Cidade é:" + endereco.getCidade());
        System.out.println("O Estado é:" + endereco.getEstado());
        System.out.println();
    }


    public boolean salvarEnderecoDoCliente() {
        enderecoDao = new EnderecoDao();
        Endereco endereco = preencher();
        boolean isSalvo = enderecoDao.salvarEnderecoDoCliente(endereco);
        return isSalvo;
    }
    public boolean salvarEnderecoDoMotorista() {
        enderecoDao = new EnderecoDao();
        Endereco endereco = preencher();
        boolean isSalvo = enderecoDao.salvarEnderecoDoMotorista(endereco);
        return isSalvo;
    }

    public boolean editarEnderecoDoCliente() {
        enderecoDao = new EnderecoDao();
        int id = digitarId();
        Endereco endereco = preencher();
        endereco.setId(id);
        boolean isSalvo = enderecoDao.editarEnderecoDoCliente(endereco);
        return isSalvo;
    }
    public boolean editarEnderecoDoMotorista() {
        enderecoDao = new EnderecoDao();
        int id = digitarId();
        Endereco endereco = preencher();
        endereco.setId(id);
        boolean isSalvo = enderecoDao.editarEnderecoDoMotorista(endereco);
        return isSalvo;
    }

    public boolean deletarEnderecoDoCliente() {
        enderecoDao = new EnderecoDao();
        int id = digitarId();
        boolean isSalvo = enderecoDao.deletarEnderecoDoCliente(id);
        return isSalvo;
    }
    public boolean deletarEnderecoDoMotorista() {
        enderecoDao = new EnderecoDao();
        int id = digitarId();
        boolean isSalvo = enderecoDao.deletarEnderecoDoMotorista(id);
        return isSalvo;
    }

    public void printAll(ArrayList<Endereco> enderecos) {
        for (Endereco endereco : enderecos) {
            printarEndereco(endereco);
        }
    }
    public int digitarId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Qual o id: ");
        int id = input.nextInt();
        return id;
    }
}
