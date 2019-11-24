package br.com.hackatonfc.dtos;

import java.io.Serializable;

public class EstacionamentoDto implements Serializable  {
	private static final long serialVersionUID = -8105241933692707649L;

	private Long id;
	private String cnpj;
	private String endereco;
	private String telefone;
	private String vagasCarro;
	private String vagasMoto;
	private String nomeEstacionamento;

	public void EstacioanamentoDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomeEstacionamento() {
		return nomeEstacionamento;
	}

	public void setNomeEstacionamento(String nomeEstacionamento) {
		this.nomeEstacionamento = nomeEstacionamento;
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTelefone() {
		return endereco;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	public String getVagasCarro() {
		return getVagasCarro();
	}

	public void setVagasCarro(String vagasCarro) {
		this.vagasCarro = vagasCarro;
	}
	
	public String getVagasMoto() {
		return getVagasMoto();
	}

	public void setVagasMoto(String vagasMoto) {
		this.vagasMoto = vagasMoto;
	}
	
	@Override
	public String toString() {
		return "Estacionamento [id=" + id + ", nomeEstacionamento=" + nomeEstacionamento + ", cnpj=" + cnpj
				+ ", endereco=" + endereco + ", telefone=" + telefone + ", vagasCarro="+ vagasCarro + ", vagasMoto= "+ vagasMoto +  "]";
	}
}
