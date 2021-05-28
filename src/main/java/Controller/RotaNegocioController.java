package Controller;

import Model.Rota;
import Model.dao.RotaDao;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class RotaNegocioController {

    private static AtomicInteger id_generator = new AtomicInteger(0);
    private Rota rota;
    private RotaDao rotaDao;
    private ArrayList<Rota> rotas = new ArrayList<Rota>();

    public Rota preencher() {
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
            rotas.add(rota);


        }
        return rota;

//    }
//
//    public Rota listarRotas(long id) {
//        for (Rota rota : rotas) {
//            if (rota.getId() == id) {
//                return rota;
//            }
//        }
//
//
//        return null;
//
//
//    }
//
//    public void editarRotas(long id) {
//        int log = 0;
//        for (Rota rota : rotas) {
//            if (rota.getId() == id) {
//
//                Rota rotaNova = new Rota();
//                Scanner leia = new Scanner(System.in);
//
//                System.out.println("Informe a Nova Cidade de Saida:");
//                rotaNova.setCidadeSaida(leia.next());
//
//                System.out.println("Informe a Nova Cidade de Chegada:");
//                rotaNova.setCidadeChegada(leia.next());
//
//                System.out.println("Informe a Nova Distancia");
//                rotaNova.setDistancia(leia.nextDouble());
//
//                int cp = 1;
//                while (cp == 1) {
//                    System.out.println("Qual cidade você quer cadastrar");
//                    rotaNova.setCidadeParadas(leia.next());
//
//                    System.out.println("Quer cadastar uma nova cidade! Digite 1 para sim");
//                    cp = leia.nextInt();
//                }
//                rotas.add(log, rotaNova);
//            }
//        }
//    }
//
//    public void deletarRota(long id) {
//        int log = 0;
//        for (Rota rota : rotas) {
//            if (rota.getId() == id) {
//                rotas.remove(log);
//            }
//            log++;

    }
    public void printarRotas(Rota rota) {
        System.out.println();
        System.out.println("A Cidade de Saida é:" + rota.getCidadeSaida());
        System.out.println("A Cidade Final é:" + rota.getCidadeChegada());
        System.out.println("A Distancia entre as cidades é:" + rota.getDistancia());
        System.out.println("As Cidades pela qual a rota passa são:" + rota.getCidadesRotas());
        System.out.println();
    }

    public ArrayList<Rota> listarRotas() {
        rotaDao = new RotaDao();
        ArrayList<Rota> rotas = rotaDao.listarRotas();
        return rotas;
    }

    public boolean salvarRota() {
        rotaDao = new RotaDao();
        Rota rota = preencher();
        boolean isSalvo = rotaDao.salvarRota(rota);
        return isSalvo;
    }

    public boolean editarRotas() {
        rotaDao = new RotaDao();
        int id = digitarId();
        Rota rota = preencher();
        rota.setId(id);
        boolean isSalvo = rotaDao.editarRota(rota);
        return isSalvo;
    }

    public boolean deletarRota() {
        rotaDao = new RotaDao();
        int id = digitarId();
        boolean isSalvo = rotaDao.deletarRota(id);
        return isSalvo;
    }

    public void printAll(ArrayList<Rota> rotas) {
        for (Rota rota : rotas) {
            printarRotas(rota);
        }
    }

    public Rota procurarPorId(int id) {
        rotaDao = new RotaDao();
        Rota rota = rotaDao.buscarRotaPorId(id);
        return rota;
    }

    public int digitarId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Qual o ID da Rota que deseja modificar? ");
        int id = input.nextInt();
        return id;
    }
}