package br.com.hackathonfc.park.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.hackathonfc.park.model.Estacionamento;
import br.com.hackathonfc.park.model.Vaga;
import br.com.hackathonfc.park.model.Veiculo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
	private Long estacionamento_id;

	private Long veiculo_id;

	@NotNull
	private LocalDateTime dataInicio;

	@NotNull
	private LocalDateTime dataSaida;

	@NotNull
	private boolean livre;


	public VagaDTO(Vaga vaga) {
		this.estacionamento_id = vaga.getEstacionamento().getId();
		this.livre = vaga.isLivre();
		this.veiculo_id = vaga.getVeiculo().getId();
	}
}
