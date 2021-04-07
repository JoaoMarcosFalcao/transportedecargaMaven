package Controller;

import Model.Telefone;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class TelefoneController {


    private ArrayList<Telefone> telefones = new ArrayList<Telefone>();
    private static AtomicInteger id_generator = new AtomicInteger(0);
    private Telefone telefone;

    public void cadastrarTelefone() {

        telefone = new Telefone();
        Scanner leia = new Scanner(System.in);

        telefone.setId(id_generator.getAndIncrement());

        System.out.println("Informe o código de área: ");
        telefone.setCodigoArea(leia.next());

        System.out.println("Informe o DDD: ");
        telefone.setDDD(leia.next());

        System.out.println("Informe o número do telefone: ");
        telefone.setNumero(leia.next());


        telefone.setId(id_generator.getAndIncrement());
        System.out.println("O ID do telefone registrado é: " + telefone.getId());

        telefones.add(telefone);


    }

    public Telefone listarTelefones(long id) {
        for (Telefone telefone : telefones) {
            if (telefone.getId() == id) {
                return telefone;
            }
        }
        return null;
    }

    public void editarTelefones(long id) {
        int log = 0;
        for (Telefone telefone : telefones) {
            if (telefone.getId() == id) {
                Telefone telefoneNovo = new Telefone();

                Scanner leia = new Scanner(System.in);

                System.out.println("Informe o código de área: ");
                telefoneNovo.setCodigoArea(leia.next());

                System.out.println("Informe o DDD: ");
                telefoneNovo.setDDD(leia.next());

                System.out.println("Informe o número do telefone: ");
                telefoneNovo.setNumero(leia.next());

                telefoneNovo.setId(id);
            }

            telefones.set(log, telefone);

        }
        log++;
    }



    public void deletarTelefones(long id){
        int log = 0;
        for(Telefone telefone : telefones) {
            if(telefone.getId() == id) {
                telefones.remove(log);
                break;
            }
            log++;
        }
    }
    public void printarTelefones (Telefone telefone) {
        System.out.println();
        System.out.println("O Numero do Telefone é:" + telefone.getNumero());
        System.out.println("O Código de Area é:" + telefone.getCodigoArea());
        System.out.println("O DDD do Telefone é:" + telefone.getDDD());
        System.out.println();
    }
}
