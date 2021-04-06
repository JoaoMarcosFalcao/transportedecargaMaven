package Model;

public class Veiculo {

    private long id;
    private String modelo;
    private String marca;
    private double ano;
    private String placa;
    private String RENAVAM;
    private double capacidade;

    public Veiculo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getAno() {
        return ano;
    }

    public void setAno(double ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRENAVAM() {
        return RENAVAM;
    }

    public void setRENAVAM(String RENAVAM) {
        this.RENAVAM = RENAVAM;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }
}
