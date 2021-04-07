package Controller;

import Model.*;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ViagemNegocioController {

    private static AtomicInteger id_generator = new AtomicInteger(0);
    private Viagem viagem;
    private Carga carga;
    private Veiculo veiculo;

    public double calcularFretePeso(Carga carga, Rota rota) {

        double freteKM = rota.getDistancia() * 1.50;

        carga.setPesoOcupada(carga.getAltura() * carga.getComprimento() * carga.getLargura() * 300);
        if (carga.getPesoOcupada() > 0 && carga.getPesoOcupada() <= 200) {
            return 100 + freteKM;
        } else if (carga.getPesoOcupada() > 200 && carga.getPesoOcupada() <= 500) {
            return 150 + freteKM;
        } else if (carga.getPesoOcupada() > 500 && carga.getPesoOcupada() <= 800) {
            return 200 + freteKM;
        } else if (carga.getPesoOcupada() > 800 && carga.getPesoOcupada() <= 12000) {
            return 250 + freteKM;
        } else if (carga.getPesoOcupada() > 12000 && carga.getPesoOcupada() <= veiculo.getCapacidade()) {
            return 300 + freteKM;
        }
        return -1;

    }


    public void precoFrete(Viagem viagem, Carga carga, Rota rota){

        viagem.setFrete(calcularFretePeso(carga, rota));
    }
}

