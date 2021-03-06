package Controller;

import Model.*;
import Model.dao.ViagemDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class ViagemController {

    private static AtomicInteger id_generator = new AtomicInteger(0);
    private Viagem viagem;
    private ViagemDao viagemDao;
    private ArrayList<Viagem> viagens = new ArrayList<Viagem>();


    public Viagem preencher() {
        Scanner leia = new Scanner(System.in);

        viagem = new Viagem();

        viagem.setId(id_generator.getAndIncrement());

        System.out.println("Informe a hora da saida:");
        viagem.setHoraPartida(leia.nextInt());

        System.out.println("Informe os minutos da saida:");
        viagem.setMinutoPartida(leia.nextInt());

        System.out.println("Informe o ano de saida:");
        int saidaAno = leia.nextInt();
        System.out.println("Informe o mês de saida:");
        int saidaMes = leia.nextInt();
        System.out.println("Informe o dia de saida:");
        int saidaDia = leia.nextInt();

        viagem.setDataSaida(LocalDate.of(saidaAno, saidaMes, saidaDia));

        System.out.println("Informe a hora da chegada:");
        viagem.setHoraChegada(leia.nextInt());

        System.out.println("Informe os minutos da chegada:");
        viagem.setMinutoChegada(leia.nextInt());

        System.out.println("Informe o ano de chegada:");
        int chegadaAno = leia.nextInt();
        System.out.println("Informe o mês de chegada:");
        int chegadaMes = leia.nextInt();
        System.out.println("Informe o dia de chegada:");
        int chegadaDia = leia.nextInt();

        viagem.setDataChegada(LocalDate.of(saidaAno, saidaMes, saidaDia));

        System.out.println("Informe o ID da Carga:");
        viagem.setIdCarga(leia.nextInt());

        System.out.println("Informe o ID do Veiculo:");
        viagem.setIdVeiculo(leia.nextInt());

        System.out.println("Informe o ID do Motorista:");
        viagem.setIdMotorista(leia.nextInt());

        System.out.println("Informe o ID da Rota:");
        viagem.setIdRota(leia.nextInt());


        viagens.add(viagem);
        
        return viagem;

    }

    public void calcularFretePeso(Viagem viagem, Carga carga, Rota rota, Veiculo veiculo) {

        double freteTotal = 0;

        double freteKM = rota.getDistancia() * 1.50;

        carga.setPesoOcupada(carga.getAltura() * carga.getComprimento() * carga.getLargura() * 300);
        if (carga.getPesoOcupada() > 0 && carga.getPesoOcupada() <= 200) {
            freteTotal = 100 + freteKM;
        } else if (carga.getPesoOcupada() > 200 && carga.getPesoOcupada() <= 500) {
            freteTotal = 150 + freteKM;
        } else if (carga.getPesoOcupada() > 500 && carga.getPesoOcupada() <= 800) {
            freteTotal = 200 + freteKM;
        } else if (carga.getPesoOcupada() > 800 && carga.getPesoOcupada() <= 12000) {
            freteTotal = 250 + freteKM;
        } else if (carga.getPesoOcupada() > 12000 && carga.getPesoOcupada() <= veiculo.getCapacidade()) {
            freteTotal = 300 + freteKM;
        }
        viagem.setFrete(freteTotal);
        System.out.println("O Frete Calculado é de:" + freteTotal);
    }
//
//    public Viagem listarViagens(long id) {
//        for (Viagem viagem : viagens) {
//            if (viagem.getId() == id) {
//                return viagem;
//            }
//        }
//        return null;
//
//
//    }
//
//    public void editarViagem(long id) {
//        int log = 0;
//        for (Viagem viagem : viagens) {
//            if (viagem.getId() == id) {
//                Scanner leia = new Scanner(System.in);
//
//                Viagem viagemNovo = new Viagem();
//
//                System.out.println("Informe a nova hora da saida:");
//                viagemNovo.setHoraPartida(leia.next());
//
//                System.out.println("Informe o novo ano de saida:");
//                int novaSaidaAno = leia.nextInt();
//                System.out.println("Informe o novo mês de saida:");
//                int novaSaidaMes = leia.nextInt();
//                System.out.println("Informe o novo dia de saida:");
//                int novaSaidaDia = leia.nextInt();
//
//                viagem.setDataSaida(LocalDate.of(novaSaidaAno, novaSaidaMes, novaSaidaDia));
//
//                System.out.println("Informe a nova hora da chegada:");
//                viagemNovo.setHoraChegada(leia.next());
//
//                System.out.println("Informe o novo ano de chegada:");
//                int novaChegadaAno = leia.nextInt();
//                System.out.println("Informe o novo mês de chegada:");
//                int novaChegadaMes = leia.nextInt();
//                System.out.println("Informe o novo dia de chegada:");
//                int novaChegadaDia = leia.nextInt();
//
//
//                viagem.setDataChegada(LocalDate.of(novaChegadaAno, novaChegadaMes, novaChegadaDia));
//
//                viagens.add(log, viagemNovo);
//            }
//        }
//    }
//
//    public void deletarViagem(long id) {
//        int log = 0;
//        for (Viagem viagem : viagens) {
//            if (viagem.getId() == id) {
//                viagens.remove(log);
//            }
//            log++;
//
//        }
//    }
    public void printarViagem (Viagem viagem) {

        System.out.println();
        System.out.println("A Hora da Partida foi: " + viagem.getHoraPartida() + " Horas e " + viagem.getMinutoPartida() + " minutos");
        System.out.println("A Hora da Chegada foi: " + viagem.getHoraChegada() + " Horas e " + viagem.getMinutoChegada() + " minutos");
        System.out.println("A Data da Saida foi: " + viagem.getDataSaida());
        System.out.println("A Data da Saida foi: " + viagem.getDataChegada());
        System.out.println("O ID da Carga é: " + viagem.getIdCarga());
        System.out.println("O ID da Veiculo é: " + viagem.getIdVeiculo());
        System.out.println("O ID da Motorista é: " + viagem.getIdMotorista());
        System.out.println("O ID da Rota é: " + viagem.getIdRota());
        System.out.println("O ID da Frete é: " + viagem.getFrete());
        System.out.println();


    }


    public ArrayList<Viagem> listarViagems() {
        viagemDao = new ViagemDao();
        ArrayList<Viagem> viagems = viagemDao.listarViagems();
        return viagems;
    }

    public boolean salvarViagem() {
        Viagem viagem = preencher();
        viagemDao = new ViagemDao();
        boolean isSalvo = viagemDao.salvarViagem(viagem);
        return isSalvo;
    }

    public boolean editarViagems() {
        viagemDao = new ViagemDao();
        int id = digitarId();
        Viagem viagem = preencher();
        viagem.setId(id);
        boolean isSalvo = viagemDao.editarViagem(viagem);
        return isSalvo;
    }

    public boolean deletarViagem() {
        viagemDao = new ViagemDao();
        int id = digitarId();
        boolean isSalvo = viagemDao.deletarViagem(id);
        return isSalvo;
    }

    public void printAll(ArrayList<Viagem> viagems) {
        for (Viagem viagem : viagems) {
            printarViagem(viagem);
        }
    }
    public Viagem procurarPorId(int id) {
        viagemDao = new ViagemDao();
        Viagem viagem = viagemDao.buscarViagemPorId(id);
        return viagem;
    }
    public int digitarId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Qual o ID da Viagem que deseja modificar: ");
        int id = input.nextInt();
        return id;
    }
}



