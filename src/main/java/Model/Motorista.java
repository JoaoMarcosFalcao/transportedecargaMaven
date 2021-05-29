package Model;

import java.time.LocalDate;

public class Motorista {

    private long id;
    private String nome;
    private String email;
    private int idTelefone;
    private int idEndereco;
    private String CNH;
    private LocalDate validadeCHN;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }


    public Motorista() {


    }

    public String getCNH() {
        return CNH;
    }

    public void setCNH(String CNH) {
        this.CNH = CNH;
    }

    public LocalDate getValidadeCHN() {
        return validadeCHN;
    }

    public void setValidadeCHN(LocalDate validadeCHN) {
        this.validadeCHN = validadeCHN;
    }

    public void setValidadeCHN(int i, int i1, int i2) {
    }
}
