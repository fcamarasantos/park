package br.com.hackathonfc.park.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.hackathonfc.park.model.Estacionamento;
import br.com.hackathonfc.park.repository.EstacionamentoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstacionamentoDTO {
	
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

	public EstacionamentoDTO(Estacionamento estacionamento) {
		this.nome = estacionamento.getNome();
		this.cnpj = estacionamento.getCnpj();
		this.endereco = estacionamento.getEndereco();
		this.telefone = estacionamento.getTelefone();
		this.vagasCarros = estacionamento.getVagasCarros();
		this.vagasMotos = estacionamento.getVagasMotos();
		this.precoHora = estacionamento.getPrecoHora();
	}
}
