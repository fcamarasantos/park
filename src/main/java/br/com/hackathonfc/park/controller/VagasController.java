package br.com.hackathonfc.park.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hackathonfc.park.controller.dto.VagaDto;
import br.com.hackathonfc.park.model.Vaga;
import br.com.hackathonfc.park.repository.VagaRepository;

@RestController
@RequestMapping("/vagas")
public class VagasController {
	
	@Autowired
	private VagaRepository vagaRepository;
	
	public List<VagaDto> lista() {
		List<Vaga> vagas = vagaRepository.findAll();
		return VagaDto.converter(vagas;)
	}

}
