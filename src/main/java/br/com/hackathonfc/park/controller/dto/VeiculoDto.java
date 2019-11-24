package br.com.hackathonfc.park.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.hackathonfc.park.model.TipoVeiculo;
import br.com.hackathonfc.park.model.Veiculo;

public class VeiculoDto {
	
	private Long id;
	
	private TipoVeiculo tipoVeiculo;
	
	private String modelo;
	
	private String marca;
	
	private String cor;
	
	private String placa;
	
	public VeiculoDto(Veiculo veiculo) {
		this.id = veiculo.getId();
		this.tipoVeiculo = veiculo.getTipoVeiculo();
		this.modelo = veiculo.getModelo();
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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

}
