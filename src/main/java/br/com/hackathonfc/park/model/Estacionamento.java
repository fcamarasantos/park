package br.com.hackathonfc.park.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estacionamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private int cnpj;
	
	private String endereco;
	
	private int telefone;
	
	private int vagasMotos;
	
	private int vagasCarros;
	
	private Double precoHora;
	
	@OneToMany(mappedBy = "estacionamento")
	private List<Vaga> vagas = new ArrayList<>();
	
	public Estacionamento() {
		
	}
	
	public Estacionamento(String nome, int cnpj, String endereco, int telefone, int vagasMotos, int vagasCarros, Double precoHora) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
		this.vagasMotos = vagasMotos;
		this.vagasCarros = vagasCarros;
		this.precoHora = precoHora;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacionamento other = (Estacionamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public int getVagasMotos() {
		return vagasMotos;
	}
	public void setVagasMotos(int vagasMotos) {
		this.vagasMotos = vagasMotos;
	}
	public int getVagasCarros() {
		return vagasCarros;
	}
	public void setVagasCarros(int vagasCarros) {
		this.vagasCarros = vagasCarros;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Double getPrecoHora() {
		return precoHora;
	}

	public void setPrecoHora(Double precoHora) {
		this.precoHora = precoHora;
	}

}
