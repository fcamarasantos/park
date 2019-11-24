package br.com.hackathonfc.park.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.hackathonfc.park.model.Vaga;

public class VagaDto {
	
	private Long id;
	
	private LocalDateTime entrada;
	
	private LocalDateTime saida;
	
	private boolean livre;

	public VagaDto(Vaga vaga) {
		super();
		this.id = vaga.getId();
		this.entrada = vaga.getDataInicio();
		this.saida = vaga.getDataSaida();
		this.livre = vaga.isLivre();
	}
	
	public static List<VagaDto> converter(List<Vaga> vagas) {
		return vagas.stream().map(VagaDto::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public boolean isLivre() {
		return livre;
	}
	
}
