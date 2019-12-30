package br.com.hackathonfc.park.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.hackathonfc.park.model.Estacionamento;
import br.com.hackathonfc.park.model.Vaga;
import br.com.hackathonfc.park.model.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VagaDTO {

	private Long id;

	@NotNull
	private Estacionamento estacionamento;

	@NotNull
	private LocalDateTime dataInicio;

	@NotNull
	private LocalDateTime dataSaida;

	@NotNull
	private boolean livre;

	private Veiculo veiculo;

	public VagaDTO(Vaga vaga) {
		this.estacionamento = vaga.getEstacionamento();
		this.dataInicio = vaga.getDataInicio();
		this.dataSaida = vaga.getDataSaida();
		this.livre = vaga.isLivre();
	}
}
