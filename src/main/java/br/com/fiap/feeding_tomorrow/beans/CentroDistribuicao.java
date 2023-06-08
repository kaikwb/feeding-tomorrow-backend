package br.com.fiap.feeding_tomorrow.beans;

public class CentroDistribuicao {
    private Integer idCentro;
    private String nome;
    private String endereco;
    private String responsavel;
    private Integer capacidadeMaxima;

    public CentroDistribuicao() {
    }

    public CentroDistribuicao(Integer idCentro, String nome, String endereco, String responsavel, Integer capacidadeMaxima) {
        this.idCentro = idCentro;
        this.nome = nome;
        this.endereco = endereco;
        this.responsavel = responsavel;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public Integer getId_centro() {
        return idCentro;
    }

    public void setId_centro(Integer idCentro) {
        this.idCentro = idCentro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Integer getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(Integer capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }
}

