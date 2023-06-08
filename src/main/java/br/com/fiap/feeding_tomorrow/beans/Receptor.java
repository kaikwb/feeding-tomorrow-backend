package br.com.fiap.feeding_tomorrow.beans;

public class Receptor {
    private Integer idReceptor;
    private String nome;
    private String email;
    private String telefone;

    public Receptor() {
    }

    public Receptor(Integer idReceptor, String nome, String email, String telefone) {
        super();
        this.idReceptor = idReceptor;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Integer getId_receptor() {
        return idReceptor;
    }

    public void setId_receptor(Integer idReceptor) {
        this.idReceptor = idReceptor;
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
