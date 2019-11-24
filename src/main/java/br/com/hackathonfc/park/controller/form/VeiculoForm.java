package br.com.hackathonfc.park.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.hackathonfc.park.model.TipoVeiculo;
import br.com.hackathonfc.park.model.Vaga;
import br.com.hackathonfc.park.model.Veiculo;
import br.com.hackathonfc.park.repository.VagaRepository;
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
	
	@NotNull
	private TipoVeiculo tipoVeiculo;
	
	@NotNull
	private Long vagaId;
	
	public Veiculo converter(VagaRepository vagaRepository) {
		Vaga vaga = vagaRepository.getOne(vagaId);
		return new Veiculo(marca, modelo, cor, placa, tipoVeiculo, vaga);
	}
	
	public Veiculo atualizar(Long id, VeiculoRepository veiculoRepository) {
		Veiculo veiculo = veiculoRepository.getOne(id);
		
		veiculo.setMarca(this.marca);
		veiculo.setModelo(this.modelo);
		veiculo.setCor(this.cor);
		veiculo.setPlaca(this.placa);
		veiculo.setTipoVeiculo(this.tipoVeiculo);
		
		return veiculo;
	}

}
