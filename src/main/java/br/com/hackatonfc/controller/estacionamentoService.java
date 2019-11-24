package br.com.hackatonfc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;
import br.com.hackatonfc.dtos.EstacionamentoDto;
import br.com.hackatonfc.entities.Estacionamento;
import br.com.hackatonfc.repositories.EstacionamentoRepository;
import br.com.hackatonfc.services.exceptions.EstacionamentoServiceException;

@Service
public class estacionamentoService {
	@Autowired
	private EstacionamentoRepository viagemRepository;

	public List<Estacionamento> listar() {
		return estacionamentoRepository.findAll();
	}

	public Estacionamento salvar(EstacionamentoDto estacionamentoDto) {

		Estacionamento estacionamento = new Estacionamento();

		estacionamento.setLocalDeDestino(EstacionamentoDto.getNomeEstacionamento());
		estacionamento.setDataPartida(EstacionamentoDto.getCnpj());
		estacionamento.setDataRetorno(EstacionamentoDto.getEndereco());
		estacionamento.setAcompanhante(EstacionamentoDto.getTelefone());
		estacionamento.setAcompanhante(EstacionamentoDto.vagasCarro());
		estacionamento.setAcompanhante(EstacionamentoDto.vagasMoto());
		return estacionamentoRepository.save(estacionamento);
	}

	public Estacionamento buscar(Long id) {
		Estacionamento viagem = estacionamentoRepository.findOne(id);

		if (viagem == null) {
			throw new EstacionamentoServiceException("Não existe esta viagem cadastrada");
		}
		return estacionamento;
	}
}
