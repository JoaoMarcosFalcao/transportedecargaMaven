package Model;

import java.time.LocalDate;

public class Viagem {


    private long id;
    private String horaPartida;
    private String horaChegada;
    private LocalDate dataSaida;
    private LocalDate dataChegada;
    private int idCarga;
    private int idVeiculo;
    private int idMotorista;
    private int idRota;
    private double frete;

    public Viagem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(String horaPartida) {
        this.horaPartida = horaPartida;
    }

    public String getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(String horaChegada) {
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

    public int getIdCarga() {
        return idCarga;
    }

    public void setIdCarga(int idCarga) {
        this.idCarga = idCarga;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public int getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(int idMotorista) {
        this.idMotorista = idMotorista;
    }

    public int getIdRota() {
        return idRota;
    }

    public void setIdRota(int idRota) {
        this.idRota = idRota;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

//    @Override
//    public String toString() {
//        return "Viagem{" +
//                "id=" + id +
//                ", horaPartida=" + horaPartida +
//                ", horaChegada=" + horaChegada +
//                ", dataSaida=" + dataSaida +
//                ", dataChegada=" + dataChegada +
//                ", carga=" + carga +
//                ", veiculo=" + veiculo +
//                ", motorista=" + motorista +
//                ", rotas=" + rotas +
//                ", frete=" + frete +
//                '}';
//    }
}
