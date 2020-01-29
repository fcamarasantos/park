package br.com.hackathonfc.park.model;

import br.com.hackathonfc.park.dto.VeiculoDTO;
import br.com.hackathonfc.park.enums.TipoVeiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String marca;
	
	private String modelo;
	
	private String cor;
	
	private String placa;
	
	@Enumerated(EnumType.STRING)
	private TipoVeiculo tipoVeiculo = TipoVeiculo.MOTO;

	@OneToOne
	private Vaga vaga;

	public Veiculo(VeiculoDTO veiculoDTO, Vaga vaga){
		this.id = veiculoDTO.getId();
		this.marca = veiculoDTO.getMarca();
		this.modelo = veiculoDTO.getModelo();
		this.cor = veiculoDTO.getCor();
		this.placa = veiculoDTO.getPlaca();
		this.tipoVeiculo = veiculoDTO.getTipoVeiculo();
		this.vaga = vaga;
	}

	public Veiculo(String marca, String modelo, String cor, String placa, TipoVeiculo tipoVeiculo, Vaga vaga){
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.tipoVeiculo = tipoVeiculo;
		this.vaga = vaga;
	}
}
