package br.com.hackathonfc.park.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.hackathonfc.park.model.Estacionamento;
import br.com.hackathonfc.park.repository.EstacionamentoRepository;

public class EstacionamentoForm {
	
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull 
	private int cnpj;
	
	@NotNull @NotEmpty
	private String endereco;
	
	@NotNull 
	private int telefone;
	
	@NotNull 
	private int vagasCarros;
	
	@NotNull 
	private int vagasMotos;
	
	@NotNull 
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

	public int getVagasCarros() {
		return vagasCarros;
	}

	public int getVagasMotos() {
		return vagasMotos;
	}
	
	public Double getPrecoHora() {
		return precoHora;
	}
	
	public Estacionamento converter() {
		return new Estacionamento(nome, cnpj, endereco, telefone, vagasMotos, vagasCarros, precoHora);
	}
	
	public Estacionamento atualizar(Long id, EstacionamentoRepository estacionamentoRepository) {
		Estacionamento estacionamento = estacionamentoRepository.getOne(id);
		estacionamento.setNome(nome);
		estacionamento.setCnpj(cnpj);
		estacionamento.setEndereco(endereco);
		estacionamento.setTelefone(telefone);
		estacionamento.setVagasCarros(vagasCarros);
		estacionamento.setVagasMotos(vagasMotos);
		estacionamento.setPrecoHora(precoHora);
		return estacionamento;
	}
	
}
