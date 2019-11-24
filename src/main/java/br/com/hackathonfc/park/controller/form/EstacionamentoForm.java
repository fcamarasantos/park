package br.com.hackathonfc.park.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.hackathonfc.park.model.Estacionamento;

public class EstacionamentoForm {
	
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private int cnpj;
	
	@NotNull @NotEmpty
	private String endereco;
	
	@NotNull @NotEmpty
	private int telefone;
	
	@NotNull @NotEmpty
	private int vagasCarro;
	
	@NotNull @NotEmpty
	private int vagasMoto;
	
	@NotNull @NotEmpty
	private Double precoHora;

	public String getNome() {
		return nome;
	}

	public int getCnpj() {
		return cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public int getTelefone() {
		return telefone;
	}

	public int getVagasCarro() {
		return vagasCarro;
	}

	public int getVagasMoto() {
		return vagasMoto;
	}
	
	public Double getPrecoHora() {
		return precoHora;
	}
	
	public Estacionamento converter() {
		return new Estacionamento(nome, cnpj, endereco, telefone, vagasMoto, vagasCarro, precoHora);
	}
	
}
