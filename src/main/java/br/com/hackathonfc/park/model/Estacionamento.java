package br.com.hackathonfc.park.model;

import br.com.hackathonfc.park.dto.EstacionamentoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estacionamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String cnpj;
	
	private String endereco;
	
	private int telefone;
	
	private int vagasMotos;
	
	private int vagasCarros;
	
	private Double precoHora;
	
	@OneToMany(mappedBy = "estacionamento", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<Vaga> vagas = new ArrayList<>();

    public Estacionamento(EstacionamentoDTO estacionamentoDTO) {
		this.nome = estacionamentoDTO.getNome();
		this.cnpj = estacionamentoDTO.getCnpj();
		this.endereco = estacionamentoDTO.getEndereco();
		this.telefone = estacionamentoDTO.getTelefone();
		this.vagasCarros = estacionamentoDTO.getVagasCarros();
		this.vagasMotos = estacionamentoDTO.getVagasMotos();
		this.precoHora = estacionamentoDTO.getPrecoHora();
    }

	public Estacionamento(String s, String s1, String s2, int i, int i1, int i2, double v) {
    	this.nome = s;
    	this.cnpj = s1;
    	this.endereco = s2;
    	this.telefone = i;
    	this.vagasMotos = i1;
    	this.vagasCarros = i2;
    	this.precoHora = v;
	}
}
