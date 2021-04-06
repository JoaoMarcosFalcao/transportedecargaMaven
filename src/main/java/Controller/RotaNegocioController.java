package Controller;

import Model.Rota;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class RotaNegocioController {

    private static AtomicInteger id_generator = new AtomicInteger(0);
    private Rota rota;
    private ArrayList<Rota> rotas = new ArrayList<Rota>();

    public void definirRotas() {
        Scanner leia = new Scanner(System.in);

        rota = new Rota();
        rota.setId(id_generator.getAndIncrement());

        System.out.println("Informe a Cidade de Saida:");
        rota.setCidadeSaida(leia.next());

        System.out.println("Informe a Cidade de Chegada:");
        rota.setCidadeChegada(leia.next());

        System.out.println("Informe o a Distancia");
        rota.setDistancia(leia.nextDouble());

        int cp = 1;
        while (cp == 1) {
            System.out.println("Qual cidade você quer cadastrar");
            rota.setCidadeParadas(leia.next());

            System.out.println("Quer cadastar uma nova cidade! Digite 1 para sim");
            cp = leia.nextInt();
        }


        rotas.add(rota);
    }

    public Rota listarRotas(long id) {
        for (Rota rota : rotas) {
            if (rota.getId() == id) {
                return rota;
            }
        }


        return null;


    }

    public void editarRotas(long id) {
        int log = 0;
        for (Rota rota : rotas) {
            if (rota.getId() == id) {

                Rota rotaNova = new Rota();
                Scanner leia = new Scanner(System.in);

                System.out.println("Informe a Nova Cidade de Saida:");
                rotaNova.setCidadeSaida(leia.next());

                System.out.println("Informe a Nova Cidade de Chegada:");
                rotaNova.setCidadeChegada(leia.next());

                System.out.println("Informe a Nova Distancia");
                rotaNova.setDistancia(leia.nextDouble());

                int cp = 1;
                while (cp == 1) {
                    System.out.println("Qual cidade você quer cadastrar");
                    rotaNova.setCidadeParadas(leia.next());

                    System.out.println("Quer cadastar uma nova cidade! Digite 1 para sim");
                    cp = leia.nextInt();
                }
                rotas.add(log, rotaNova);
            }
        }
    }

    public void deletarRota(long id) {
        int log = 0;
        for (Rota rota : rotas) {
            if (rota.getId() == id) {
                rotas.remove(log);
            }
            log++;
        }
    }
}