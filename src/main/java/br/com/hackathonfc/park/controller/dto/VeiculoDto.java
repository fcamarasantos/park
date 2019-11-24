package br.com.hackathonfc.park.controller.dto;

public class VeiculoDto {
	
	private Long id;
	
	private String marca;
	
	private String cor;
	
	private String placa;
	
	public VeiculoDto(Long id, String marca, String cor, String placa) {
		super();
		this.id = id;
		this.marca = marca;
		this.cor = cor;
		this.placa = placa;
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
