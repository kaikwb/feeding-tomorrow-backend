package br.com.fiap.feeding_tomorrow.beans;

public class Voluntario {
    private Integer idVoluntario;
    private String nome;
    private String email;
    private String telefone;

    public Voluntario() {
    }

    public Voluntario(Integer idVoluntario, String nome, String email, String telefone) {
        this.idVoluntario = idVoluntario;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Integer getId_voluntario() {
        return idVoluntario;
    }

    public void setId_voluntario(Integer idVoluntario) {
        this.idVoluntario = idVoluntario;
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
