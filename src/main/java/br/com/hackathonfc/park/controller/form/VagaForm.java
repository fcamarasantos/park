package br.com.hackathonfc.park.controller.form;

import java.time.LocalDateTime;

import br.com.hackathonfc.park.model.Vaga;

public class VagaForm {
	
	private LocalDateTime dataInicio;
	
	private LocalDateTime dataSaida;
	
	private boolean livre;
	
	public Vaga converter() {
		return new Vaga(dataInicio, dataSaida, livre);
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public LocalDateTime getDataSaida() {
		return dataSaida;
	}

	public boolean isLivre() {
		return livre;
	}
	
}
