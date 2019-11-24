package br.com.hackathonfc.park.controller.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.hackathonfc.park.model.Estacionamento;
import br.com.hackathonfc.park.repository.EstacionamentoRepository;

public class AtualizacaoEstacionamentoForm {
	
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private int cnpj;
	
	@NotNull @NotEmpty
	private String endereco;
	
	@NotNull @NotEmpty
	private int telefone;
	
	@NotNull @NotEmpty
	private int vagasCarros;
	
	@NotNull @NotEmpty
	private int vagasMotos;
	
	@NotNull @NotEmpty
	private Double precoHora;
			
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getVagasCarros() {
		return vagasCarros;
	}

	public void setVagasCarros(int vagasCarros) {
		this.vagasCarros = vagasCarros;
	}

	public int getVagasMotos() {
		return vagasMotos;
	}

	public void setVagasMotos(int vagasMotos) {
		this.vagasMotos = vagasMotos;
	}

	public Double getPrecoHora() {
		return precoHora;
	}

	public void setPrecoHora(Double precoHora) {
		this.precoHora = precoHora;
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
