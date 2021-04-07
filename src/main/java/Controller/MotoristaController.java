package Controller;


import Model.Motorista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MotoristaController {

    private Motorista motorista;
    private static AtomicInteger id_generator = new AtomicInteger(0);
    private ArrayList<Motorista> motoristas = new ArrayList<Motorista>();

    public void cadastrarMotorista() {
        motorista = new Motorista();

        Scanner leia = new Scanner(System.in);

        motorista.setId(id_generator.getAndIncrement());

        System.out.println("Informe o Nome do Motorista:");
        motorista.setNome(leia.next());

        System.out.println("Informe o email do Motorista:");
        motorista.setEmail(leia.next());

        System.out.println("Informe o numero da CNH do Motorista:");
        motorista.setCNH(leia.next());

        System.out.println("Informe o ano da validade da CNH:");
        int anoValidade = leia.nextInt();
        System.out.println("Informe o mês da validade da CNH:");
        int mesValidade = leia.nextInt();
        System.out.println("Informe o dia da validade da CNH:");
        int diaValidade = leia.nextInt();

        motorista.setValidadeCHN(LocalDate.of(anoValidade, mesValidade, diaValidade));

        motoristas.add(motorista);

    }
    public Motorista listarMotorista(long id) {
        for (Motorista motorista : motoristas) {
            if(motorista.getId() == id) {
                return motorista;
            }
        }


        return null;


    }
    public void editarMotorista(long id) {
        int log = 0;
        for (Motorista motorista : motoristas) {
            if(motorista.getId() == id) {

                Motorista motoristaNovo = new Motorista();
                Scanner leia = new Scanner(System.in);

                System.out.println("Informe o Nome do Cliente:");
                motoristaNovo.setNome(leia.next());

                System.out.println("Informe o email do Cliente:");
                motoristaNovo.setEmail(leia.next());

                System.out.println("Informe o CPF do Cliente:");
                motoristaNovo.setCNH(leia.next());

                System.out.println("Informe o ano da validade da CNH:");
                int novoAnoValidade = leia.nextInt();
                System.out.println("Informe o mês da validade da CNH:");
                int novoMesValidade = leia.nextInt();
                System.out.println("Informe o dia da validade da CNH:");
                int novoDiaValidade = leia.nextInt();

                motoristaNovo.setValidadeCHN(LocalDate.of(novoAnoValidade, novoMesValidade, novoDiaValidade));

                motoristas.set(log, motoristaNovo);

            }
            log++;
        }
    }
    public void deletarMotorista(long id) {
        int log = 0;
        for (Motorista motorista : motoristas) {
            if(motorista.getId() == id) {
                motoristas.remove(log);
            }
            log++;
        }
    }
}
