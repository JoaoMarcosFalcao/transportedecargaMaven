package Model;

import java.util.ArrayList;

public class Rota {

    private long id;
    private String cidadeSaida;
    private String cidadeChegada;
    private double distancia;
    private String cidadeParadas;
    //private ArrayList<String> cidadesRotas;

    public Rota() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCidadeSaida() {
        return cidadeSaida;
    }

    public void setCidadeSaida(String cidadeSaida) {
        this.cidadeSaida = cidadeSaida;
    }

    public String getCidadeChegada() {
        return cidadeChegada;
    }

    public void setCidadeChegada(String cidadeChegada) {
        this.cidadeChegada = cidadeChegada;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getCidadeParadas() {
        return cidadeParadas;
    }

    public void setCidadeParadas(String cidadeParadas) {
        this.cidadeParadas = cidadeParadas;
    }

//    public ArrayList<String> getCidadesRotas() {
//        return cidadesRotas;
//    }
//
//    public void setCidadesRotas(ArrayList<String> cidadesRotas) {
//        this.cidadesRotas = cidadesRotas;
    }

