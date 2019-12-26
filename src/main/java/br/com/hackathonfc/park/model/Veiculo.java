package br.com.hackathonfc.park.model;

import br.com.hackathonfc.park.dto.VeiculoDTO;
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

	public Veiculo(VeiculoDTO veiculoDTO) {
		this.marca = veiculoDTO.getMarca();
		this.modelo = veiculoDTO.getModelo();
		this.cor = veiculoDTO.getCor();
		this.placa = veiculoDTO.getPlaca();
		this.tipoVeiculo = veiculoDTO.getTipoVeiculo();
	}
}
