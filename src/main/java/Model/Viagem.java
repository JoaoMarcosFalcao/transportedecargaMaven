package Model;

import java.time.LocalDate;

public class Viagem {


    private long id;
    private double horaPartida;
    private double horaChegada;
    private LocalDate dataSaida;
    private LocalDate dataChegada;
    private Carga carga;
    private Veiculo veiculo;
    private Motorista motorista;
    private Rota rotas;
    private double frete;

    public Viagem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(double horaPartida) {
        this.horaPartida = horaPartida;
    }

    public double getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(double horaChegada) {
        this.horaChegada = horaChegada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public LocalDate getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(LocalDate dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Carga getCarga() {
        return carga;
    }

    public void setCarga(Carga carga) {
        this.carga = carga;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Rota getRotas() {
        return rotas;
    }

    public void setRotas(Rota rotas) {
        this.rotas = rotas;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

}
