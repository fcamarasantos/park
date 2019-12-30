package br.com.hackathonfc.park.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.hackathonfc.park.model.TipoVeiculo;
import br.com.hackathonfc.park.model.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDTO {

	private Long id;

	@NotEmpty
	private String marca;

	@NotEmpty
	private String modelo;

	@NotEmpty
	private String cor;

	@NotEmpty
	private String placa;

	@NotNull
	private TipoVeiculo tipoVeiculo;

	@NotNull
	private Long vagaId;

	public VeiculoDTO(Veiculo veiculo) {
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.cor = veiculo.getCor();
		this.placa = veiculo.getPlaca();
		this.tipoVeiculo = veiculo.getTipoVeiculo();
		this.vagaId = veiculo.getVaga().getId();
	}
}
