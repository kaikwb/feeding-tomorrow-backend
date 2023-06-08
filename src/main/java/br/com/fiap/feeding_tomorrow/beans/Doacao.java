package br.com.fiap.feeding_tomorrow.beans;

public class Doacao {
	private Integer idDoacao;
	private Integer idDoador;
	private Integer idReceptor;
	private String dataDoacao;
	private String status;
	
	public Doacao(){
	}

	public Doacao(Integer idDoacao, Integer idDoador, Integer idReceptor, String dataDoacao, String status) {
		this.idDoacao = idDoacao;
		this.idDoador = idDoador;
		this.idReceptor = idReceptor;
		this.dataDoacao = dataDoacao;
		this.status = status;
	}

	public Integer getId_doacao() {
		return idDoacao;
	}

	public void setId_doacao(Integer idDoacao) {
		this.idDoacao = idDoacao;
	}

	public Integer getIdDoador() {
		return idDoador;
	}

	public void setIdDoador(Integer idDoador) {
		this.idDoador = idDoador;
	}

	public Integer getIdReceptor() {
		return idReceptor;
	}

	public void setIdReceptor(Integer idReceptor) {
		this.idReceptor = idReceptor;
	}

	public String getDataDoacao() {
		return dataDoacao;
	}

	public void setDataDoacao(String dataDoacao) {
		this.dataDoacao = dataDoacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
