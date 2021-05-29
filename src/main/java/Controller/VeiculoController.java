package Controller;

import Model.Veiculo;
import Model.Rota;
import Model.Veiculo;
import Model.dao.VeiculoDao;
import Model.dao.VeiculoDao;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class VeiculoController {
    
    private VeiculoDao veiculoDao;
    private Veiculo veiculo;
    private static AtomicInteger id_generator = new AtomicInteger(0);
    private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    public Veiculo preencher() {
        veiculo = new Veiculo();

        Scanner leia = new Scanner(System.in);

        veiculo.setId(id_generator.getAndIncrement());

        System.out.println("Informe o Modelo do Veiculo:");
        veiculo.setModelo(leia.nextLine());

        System.out.println("Informe a Marca do Veiculo:");
        veiculo.setMarca(leia.nextLine());

        System.out.println("Informe o Ano do Veiculo:");
        veiculo.setAno(leia.nextDouble());

        System.out.println("Informe a Placa do Veiculo:");
        veiculo.setPlaca(leia.next());

        System.out.println("Informe o Renavam do Veiculo:");
        veiculo.setRENAVAM(leia.next());

        System.out.println("Informe a Capacidade do Veiculo:");
        veiculo.setCapacidade(leia.nextDouble());

        veiculos.add(veiculo);
        
        return veiculo;
    }
//    }
//    public Veiculo listarVeiculos(long id) {
//        for (Veiculo veiculo : veiculos) {
//            if(veiculo.getId() == id) {
//                return veiculo;
//            }
//        }
//
//
//        return null;
//
//
//    }
//    public void editarVeiculo(long id) {
//        int log = 0;
//        for (Veiculo veiculo : veiculos) {
//            if(veiculo.getId() == id) {
//
//                Veiculo veiculoNovo = new Veiculo();
//                Scanner leia = new Scanner(System.in);
//
//                System.out.println("Informe o Modelo do Veiculo:");
//                veiculoNovo.setModelo(leia.next());
//
//                System.out.println("Informe a Marca do Veiculo:");
//                veiculoNovo.setMarca(leia.next());
//
//                System.out.println("Informe o Ano do Veiculo:");
//                veiculoNovo.setAno(leia.nextDouble());
//
//                System.out.println("Informe a Placa do Veiculo:");
//                veiculoNovo.setPlaca(leia.next());
//
//                System.out.println("Informe o Renavam do Veiculo:");
//                veiculoNovo.setRENAVAM(leia.next());
//
//                System.out.println("Informe a Capacidade do Veiculo:");
//                veiculoNovo.setCapacidade(leia.nextDouble());
//
//                veiculos.set(log, veiculoNovo);
//
//            }
//            log++;
//        }
//    }
//    public void deletarVeiculos(long id) {
//        int log = 0;
//        for (Veiculo veiculo : veiculos) {
//            if(veiculo.getId() == id) {
//                veiculos.remove(log);
//            }
//            log++;
//        }
    
    public void printarVeiculo (Veiculo veiculo) {
        System.out.println();
        System.out.println("A Marca do Veiculo é:" + veiculo.getMarca());
        System.out.println("O Modelo do Veiculo é:" + veiculo.getModelo());
        System.out.println("O Ano do Veiculo é:" + veiculo.getAno());
        System.out.println("A Placa do Veiculo é:" + veiculo.getPlaca());
        System.out.println("O RENVAM do Veiculo é:" + veiculo.getRENAVAM());
        System.out.println("A Capacidade de Carga Total do Veiculo é:" + veiculo.getCapacidade());
        System.out.println();
    }

    public ArrayList<Veiculo> listarVeiculos() {
        veiculoDao = new VeiculoDao();
        ArrayList<Veiculo> veiculos = veiculoDao.listarVeiculos();
        return veiculos;
    }

    public boolean salvarVeiculo() {
        Veiculo veiculo = preencher();
        veiculoDao = new VeiculoDao();
        boolean isSalvo = veiculoDao.salvarVeiculo(veiculo);
        return isSalvo ;
    }

    public boolean editarVeiculos() {
        veiculoDao = new VeiculoDao();
        int id = digitarId();
        Veiculo veiculo = preencher();
        veiculo.setId(id);
        boolean isSalvo = veiculoDao.editarVeiculo(veiculo);
        return isSalvo;
    }

    public boolean deletarVeiculo() {
        veiculoDao = new VeiculoDao();
        int id = digitarId();
        boolean isSalvo = veiculoDao.deletarVeiculo(id);
        return isSalvo;
    }

    public void printAll(ArrayList<Veiculo> veiculos) {
        for (Veiculo veiculo : veiculos) {
            printarVeiculo(veiculo);
        }
    }
    public Veiculo procurarPorId(int id) {
        veiculoDao = new VeiculoDao();
        Veiculo veiculo = veiculoDao.buscarVeiculoPorId(id);
        return veiculo;
    }
    public int digitarId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Qual o ID do Veiculo que deseja modificar? ");
        int id = input.nextInt();
        return id;
    }

    public boolean deletarVeiculo(int id) {
        veiculoDao = new VeiculoDao();
        boolean isSalvo = true;
        return isSalvo;
    }
}


