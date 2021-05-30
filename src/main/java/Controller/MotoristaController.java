package Controller;

import java.time.format.DateTimeFormatter;
import Model.Motorista;
import Model.Motorista;
import Model.dao.MotoristaDao;
import Model.dao.MotoristaDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MotoristaController {

    private MotoristaDao motoristaDao;
    private Motorista motorista;
    private static AtomicInteger id_generator = new AtomicInteger(0);
    private ArrayList<Motorista> motoristas = new ArrayList<Motorista>();

    public Motorista preencher() {
        motorista = new Motorista();

        Scanner leia = new Scanner(System.in);

        motorista.setId(id_generator.getAndIncrement());

        System.out.println("Informe o Nome do Motorista:");
        motorista.setNome(leia.next());

        System.out.println("Informe o Email do Motorista:");
        motorista.setEmail(leia.next());

        System.out.println("Informe o ID do Telefone:");
        motorista.setIdTelefone(leia.nextInt());

        System.out.println("Informe o ID do Endereco:");
        motorista.setIdEndereco(leia.nextInt());

        System.out.println("Informe o Número da CNH do Motorista:");
        motorista.setCNH(leia.next());

        System.out.println("Informe o Ano da Validade da CNH:");
        int anoValidade = leia.nextInt();
        System.out.println("Informe o Mês da Validade da CNH:");
        int mesValidade = leia.nextInt();
        System.out.println("Informe o Dia da Validade da CNH:");
        int diaValidade = leia.nextInt();

        motorista.setValidadeCHN(LocalDate.of(anoValidade, mesValidade, diaValidade));

        motoristas.add(motorista);

        return motorista;
//    }
//    public Motorista listarMotorista(long id) {
//        for (Motorista motorista : motoristas) {
//            if(motorista.getId() == id) {
//                return motorista;
//            }
//        }
//
//
//        return null;
//
//
//    }
//    public void editarMotorista(long id) {
//        int log = 0;
//        for (Motorista motorista : motoristas) {
//            if(motorista.getId() == id) {
//
//                Motorista motoristaNovo = new Motorista();
//                Scanner leia = new Scanner(System.in);
//
//                System.out.println("Informe o Nome do Motorista:");
//                motoristaNovo.setNome(leia.next());
//
//                System.out.println("Informe o email do Motorista:");
//                motoristaNovo.setEmail(leia.next());
//
//                System.out.println("Informe a CNH do Motorista:");
//                motoristaNovo.setCNH(leia.next());
//
//                System.out.println("Informe o ano da validade da CNH:");
//                int novoAnoValidade = leia.nextInt();
//                System.out.println("Informe o mês da validade da CNH:");
//                int novoMesValidade = leia.nextInt();
//                System.out.println("Informe o dia da validade da CNH:");
//                int novoDiaValidade = leia.nextInt();
//
//                motoristaNovo.setValidadeCHN(LocalDate.of(novoAnoValidade, novoMesValidade, novoDiaValidade));
//
//                motoristas.set(log, motoristaNovo);
//
//            }
//            log++;
//        }
//    }
//    public void deletarMotorista(long id) {
//        int log = 0;
//        for (Motorista motorista : motoristas) {
//            if(motorista.getId() == id) {
//                motoristas.remove(log);
//            }
//            log++;
    }

    public void printarMotorista(Motorista motorista) {

        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        System.out.println();
        System.out.println("O Nome do motorista é:" + motorista.getNome());
        System.out.println("O Email do motorista é:" + motorista.getEmail());
        System.out.println("A CNH do motorista é:" + motorista.getCNH());
        System.out.println("O Telefone do Motorista é:" + motorista.getIdTelefone());
        System.out.println("O Enderenço do Motorista é:" + motorista.getIdEndereco());
        System.out.println("A Data de Vencimento da CNH do Motorista é:" + formatDate.format(motorista.getValidadeCHN()));
        System.out.println();

    }

    public ArrayList<Motorista> listarMotoristas() {
        motoristaDao = new MotoristaDao();
        ArrayList<Motorista> motoristas = motoristaDao.listarMotoristas();
        return motoristas;
    }

    public boolean salvarMotorista() {
        Motorista motorista = preencher();
        motoristaDao = new MotoristaDao();
        boolean isSalvo = motoristaDao.salvarMotorista(motorista);
        return isSalvo;
    }

    public boolean editarMotoristas() {
        motoristaDao = new MotoristaDao();
        int id = digitarId();
        Motorista motorista = preencher();
        motorista.setId(id);
        boolean isSalvo = motoristaDao.editarMotorista(motorista);
        return isSalvo;
    }

    public boolean deletarMotorista() {
        motoristaDao = new MotoristaDao();
        int id = digitarId();
        boolean isSalvo = motoristaDao.deletarMotorista(id);
        return isSalvo;
    }

    public void printAll(ArrayList<Motorista> motoristas) {
        for (Motorista motorista : motoristas) {
            printarMotorista(motorista);
        }
    }

    public Motorista procurarPorId(int id) {
        motoristaDao = new MotoristaDao();
        Motorista motorista = motoristaDao.buscarMotoristaPorId(id);
        return motorista;
    }

    public int digitarId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Qual o ID do Motorista que deseja modificar? ");
        int id = input.nextInt();
        return id;
    }

    public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }

    public boolean salvarMotorista(Motorista motorista) {
        motoristaDao = new MotoristaDao();
        boolean isSalvo = false;
        return isSalvo;
    }

}


