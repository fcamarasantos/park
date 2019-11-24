package br.com.hackathonfc.park.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.hackathonfc.park.model.Veiculo;
import br.com.hackathonfc.park.repository.VeiculoRepository;

public class VeiculoForm {
	
	@NotNull @NotEmpty
	private String marca;
	
	@NotNull @NotEmpty
	private String modelo;
	
	@NotNull @NotEmpty
	private String cor;
	
	@NotNull @NotEmpty
	private String placa;
	
	public Veiculo converter(VeiculoRepository veiculoRepository) {
		return new Veiculo(marca, modelo, cor, placa);
	}
	
	public Veiculo atualizar(Long id, VeiculoRepository veiculoRepository) {
		Veiculo veiculo = veiculoRepository.getOne(id);
		
		veiculo.setMarca(this.marca);
		veiculo.setModelo(this.modelo);
		veiculo.setCor(this.cor);
		veiculo.setPlaca(this.placa);
		
		return veiculo;
	}

}
