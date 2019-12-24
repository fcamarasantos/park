package br.com.hackathonfc.park.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.hackathonfc.park.model.Estacionamento;
import br.com.hackathonfc.park.model.Vaga;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VagaDTO {
	
	private Long id;

	private Estacionamento estacionamento;
	
	private LocalDateTime dataInicio;
	
	private LocalDateTime dataSaida;
	
	private boolean livre;

	public VagaDTO(Vaga vaga) {
		this.estacionamento = vaga.getEstacionamento();
		this.dataInicio = vaga.getDataInicio();
		this.dataSaida = vaga.getDataSaida();
		this.livre = vaga.isLivre();
	}
}
