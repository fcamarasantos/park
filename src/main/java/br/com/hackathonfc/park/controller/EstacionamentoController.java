package br.com.hackathonfc.park.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.hackathonfc.park.repository.*;
import br.com.hackathonfc.park.model.Estacionamento;

@RestController
public class EstacionamentoController {
	
	@Autowired
	private EstacionamentoRepository estacionamentoRepository;
	
	@CrossOrigin
	@GetMapping("/estacionamentos")
	public Page<Estacionamento> listar(@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao){
		
		Page<Estacionamento> estacionamentos;
		
		estacionamentos = estacionamentoRepository.findAll(paginacao);
		
		return estacionamentos;
	}
	
	@CrossOrigin
	@PostMapping("/estacionamento")
	public ResponseEntity<Estacionamento>  cadastrar() {
		
	}
	
}
