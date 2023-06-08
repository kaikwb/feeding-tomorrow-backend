package br.com.fiap.feeding_tomorrow.beans;

public class Alimento {
    private Integer idAlimento;
    private String nome;
    private String tipo;
    private String validade;

    public Alimento() {
    }

    public Alimento(Integer idAlimento, String nome, String tipo, String validade) {
        this.idAlimento = idAlimento;
        this.nome = nome;
        this.tipo = tipo;
        this.validade = validade;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public Integer getId_alimento() {
        return idAlimento;
    }

    public void setId_alimento(Integer idAlimento) {
        this.idAlimento = idAlimento;
    }
}
