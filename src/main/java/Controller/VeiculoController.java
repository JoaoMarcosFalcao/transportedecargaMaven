package Controller;

import Model.Rota;
import Model.Veiculo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class VeiculoController {

    private Veiculo veiculo;
    private static AtomicInteger id_generator = new AtomicInteger(0);
    private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    public void cadastrarVeiculo() {
        veiculo = new Veiculo();

        Scanner leia = new Scanner(System.in);

        veiculo.setId(id_generator.getAndIncrement());

        System.out.println("Informe o Modelo do Veiculo:");
        veiculo.setModelo(leia.next());

        System.out.println("Informe a Marca do Veiculo:");
        veiculo.setMarca(leia.next());

        System.out.println("Informe o Ano do Veiculo:");
        veiculo.setAno(leia.nextDouble());

        System.out.println("Informe a Placa do Veiculo:");
        veiculo.setPlaca(leia.next());

        System.out.println("Informe o Renavam do Veiculo:");
        veiculo.setRENAVAM(leia.next());

        System.out.println("Informe a Capacidade do Veiculo:");
        veiculo.setCapacidade(leia.nextDouble());

        veiculos.add(veiculo);

    }
    public Veiculo listarVeiculos(long id) {
        for (Veiculo veiculo : veiculos) {
            if(veiculo.getId() == id) {
                return veiculo;
            }
        }


        return null;


    }
    public void editarVeiculo(long id) {
        int log = 0;
        for (Veiculo veiculo : veiculos) {
            if(veiculo.getId() == id) {

                Veiculo veiculoNovo = new Veiculo();
                Scanner leia = new Scanner(System.in);

                System.out.println("Informe o Modelo do Veiculo:");
                veiculoNovo.setModelo(leia.next());

                System.out.println("Informe a Marca do Veiculo:");
                veiculoNovo.setMarca(leia.next());

                System.out.println("Informe o Ano do Veiculo:");
                veiculoNovo.setAno(leia.nextDouble());

                System.out.println("Informe a Placa do Veiculo:");
                veiculoNovo.setPlaca(leia.next());

                System.out.println("Informe o Renavam do Veiculo:");
                veiculoNovo.setRENAVAM(leia.next());

                System.out.println("Informe a Capacidade do Veiculo:");
                veiculoNovo.setCapacidade(leia.nextDouble());

                veiculos.set(log, veiculoNovo);

            }
            log++;
        }
    }
    public void deletarVeiculos(long id) {
        int log = 0;
        for (Veiculo veiculo : veiculos) {
            if(veiculo.getId() == id) {
                veiculos.remove(log);
            }
            log++;
        }
    }
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
    public Veiculo getVeiculo(int i) {
        return veiculos.get(i);
    }
}

