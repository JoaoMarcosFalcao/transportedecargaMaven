package Controller;

import Model.Endereco;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class EnderecoController {

    private Endereco endereco;
    private static AtomicInteger id_generator = new AtomicInteger(0);
    private ArrayList<Endereco> enderecos = new ArrayList<Endereco>();

    public void cadastrarEndereco() {
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

        enderecos.add(endereco);

    }
    public Endereco listarEndereco(long id) {
        for (Endereco endereco : enderecos) {
            if(endereco.getId() == id) {
                return endereco;
            }
        }


        return null;


    }
    public void editarEndereco(long id) {
       int log = 0;
        for (Endereco endereco : enderecos) {
            if(endereco.getId() == id) {

                Endereco enderecoNovo = new Endereco();
                Scanner leia = new Scanner(System.in);

                System.out.println("Informe o Nome da Rua:");
                enderecoNovo.setRua(leia.next());

                System.out.println("Informe o Número da Casa:");
                enderecoNovo.setNumero(leia.next());

                System.out.println("Informe o Nome do Bairro:");
                enderecoNovo.setBairro(leia.next());

                System.out.println("Informe o Nome da Cidade:");
                enderecoNovo.setCidade(leia.next());

                System.out.println("Informe o Nome do Estado:");
                enderecoNovo.setEstado(leia.next());

                enderecos.set(log, enderecoNovo);

            }
            log++;
        }
    }
    public void deletarEndereco(long id) {
        int log = 0;
        for (Endereco endereco : enderecos) {
            if(endereco.getId() == id) {
                enderecos.remove(log);
            }
            log++;
        }
    }
}
