package Controller;

import Model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class ViagemController {

    private static AtomicInteger id_generator = new AtomicInteger(0);
    private Viagem viagem;
    private ArrayList<Viagem> viagens = new ArrayList<Viagem>();


    public void cadastrarViagem() {
        Scanner leia = new Scanner(System.in);

        viagem = new Viagem();

        viagem.setId(id_generator.getAndIncrement());

        System.out.println("Informe a hora da saida:");
        viagem.setHoraPartida(leia.next());

        System.out.println("Informe o ano de saida:");
        int saidaAno = leia.nextInt();
        System.out.println("Informe o mês de saida:");
        int saidaMes = leia.nextInt();
        System.out.println("Informe o dia de saida:");
        int saidaDia = leia.nextInt();

        viagem.setDataSaida(LocalDate.of(saidaAno, saidaMes, saidaDia));

        System.out.println("Informe a hora da chegada:");
        viagem.setHoraChegada(leia.next());

        System.out.println("Informe o ano de chegada:");
        int chegadaAno = leia.nextInt();
        System.out.println("Informe o mês de chegada:");
        int chegadaMes = leia.nextInt();
        System.out.println("Informe o dia de chegada:");
        int chegadaDia = leia.nextInt();


        viagem.setDataChegada(LocalDate.of(saidaAno, saidaMes, saidaDia));


        viagens.add(viagem);

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

    public Viagem listarViagens(long id) {
        for (Viagem viagem : viagens) {
            if (viagem.getId() == id) {
                return viagem;
            }
        }
        return null;


    }

    public void editarViagem(long id) {
        int log = 0;
        for (Viagem viagem : viagens) {
            if (viagem.getId() == id) {
                Scanner leia = new Scanner(System.in);

                Viagem viagemNovo = new Viagem();

                System.out.println("Informe a nova hora da saida:");
                viagemNovo.setHoraPartida(leia.next());

                System.out.println("Informe o novo ano de saida:");
                int novaSaidaAno = leia.nextInt();
                System.out.println("Informe o novo mês de saida:");
                int novaSaidaMes = leia.nextInt();
                System.out.println("Informe o novo dia de saida:");
                int novaSaidaDia = leia.nextInt();

                viagem.setDataSaida(LocalDate.of(novaSaidaAno, novaSaidaMes, novaSaidaDia));

                System.out.println("Informe a nova hora da chegada:");
                viagemNovo.setHoraChegada(leia.next());

                System.out.println("Informe o novo ano de chegada:");
                int novaChegadaAno = leia.nextInt();
                System.out.println("Informe o novo mês de chegada:");
                int novaChegadaMes = leia.nextInt();
                System.out.println("Informe o novo dia de chegada:");
                int novaChegadaDia = leia.nextInt();


                viagem.setDataChegada(LocalDate.of(novaChegadaAno, novaChegadaMes, novaChegadaDia));

                viagens.add(log, viagemNovo);
            }
        }
    }

    public void deletarViagem(long id) {
        int log = 0;
        for (Viagem viagem : viagens) {
            if (viagem.getId() == id) {
                viagens.remove(log);
            }
            log++;

        }
    }
    public void printarViagem (Viagem viagem) {
        System.out.println(viagem.toString());

    }
}


