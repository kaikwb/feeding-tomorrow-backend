package br.com.fiap.feeding_tomorrow.beans;

public class Doador {
    private Integer idDoador;
    private String nome;
    private String email;
    private String telefone;

    public Doador() {
    }

    public Doador(Integer idDoador, String nome, String email, String telefone) {
        super();
        this.idDoador = idDoador;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Integer getId_doador() {
        return idDoador;
    }

    public void setId_doador(Integer idDoador) {
        this.idDoador = idDoador;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
