package Model;

public class Carga {

    private long id;
    private double peso;
    private double altura;
    private double comprimento;
    private double largura;
    private double pesoOcupada;
    private TipoCarga tipoCarga;

    public Carga() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getPesoOcupada() {
        return pesoOcupada;
    }

    public void setPesoOcupada(double pesoOcupada) {
        this.pesoOcupada = pesoOcupada;
    }

    public TipoCarga getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(TipoCarga tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

}
