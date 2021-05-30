package Model;

import java.time.LocalDate;

public class Viagem {


    private long id;
    private int horaPartida;
    private int horaChegada;
    private int minutoPartida;
    private int minutoChegada;
    private LocalDate dataSaida;
    private LocalDate dataChegada;
    private int idCarga;
    private int idVeiculo;
    private int idMotorista;
    private int idRota;
    private double frete;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(int horaPartida) {
        this.horaPartida = horaPartida;
    }

    public int getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(int horaChegada) {
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

    public int getMinutoPartida() {
        return minutoPartida;
    }

    public void setMinutoPartida(int minutoPartida) {
        this.minutoPartida = minutoPartida;
    }

    public int getMinutoChegada() {
        return minutoChegada;
    }

    public void setMinutoChegada(int minutoChegada) {
        this.minutoChegada = minutoChegada;
    }

    public Viagem() {

    }
    }

