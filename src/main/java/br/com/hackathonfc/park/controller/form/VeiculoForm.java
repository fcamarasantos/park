package br.com.hackathonfc.park.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.hackathonfc.park.model.TipoVeiculo;
import br.com.hackathonfc.park.model.Vaga;
import br.com.hackathonfc.park.model.Veiculo;
import br.com.hackathonfc.park.repository.VagaRepository;
import br.com.hackathonfc.park.repository.VeiculoRepository;

public class VeiculoForm {
	
	private String marca;
	
	
	private String modelo;
	
	
	private String cor;
	
	
	private String placa;
	
	
	private TipoVeiculo tipoVeiculo;
	
	
	private Long vagaId;
	
	public Veiculo converter(VagaRepository vagaRepository) {
		Optional<Vaga> vaga = vagaRepository.findById(vagaId);
		
		if(vaga.isPresent())
			return new Veiculo(marca, modelo, cor, placa, tipoVeiculo, vaga.get());
		
		return null;
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
