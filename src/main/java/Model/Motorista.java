package Model;

import java.time.LocalDate;

public class Motorista {

    private long id;
    private String nome;
    private String email;
    private Telefone telefone;
    private Endereco endereco;
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

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
}
