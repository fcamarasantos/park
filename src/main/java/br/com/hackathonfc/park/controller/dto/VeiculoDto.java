package br.com.hackathonfc.park.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.hackathonfc.park.model.Veiculo;

public class VeiculoDto {
	
	private Long id;
	
	private String marca;
	
	private String cor;
	
	private String placa;
	
	public VeiculoDto(Veiculo veiculo) {
		super();
		this.id = veiculo.getId();
		this.marca = veiculo.getMarca();
		this.cor = veiculo.getCor();
		this.placa = veiculo.getPlaca();
	}
	
	public static List<VeiculoDto> converter(List<Veiculo> veiculos) {
		return veiculos.stream().map(VeiculoDto::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getCor() {
		return cor;
	}

	public String getPlaca() {
		return placa;
	}

}
