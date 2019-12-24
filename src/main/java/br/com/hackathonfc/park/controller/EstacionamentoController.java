package br.com.hackathonfc.park.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.com.hackathonfc.park.bo.EstacionamentoBO;
import br.com.hackathonfc.park.service.EstacionamentoService;
import br.com.hackathonfc.park.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.hackathonfc.park.dto.VagaDTO;
import br.com.hackathonfc.park.dto.EstacionamentoDTO;
import br.com.hackathonfc.park.model.Estacionamento;
import br.com.hackathonfc.park.model.Vaga;
import br.com.hackathonfc.park.repository.EstacionamentoRepository;
import br.com.hackathonfc.park.repository.VagaRepository;

@RestController
@RequestMapping("/estacionamentos")
public class EstacionamentoController {

	@Autowired
	private EstacionamentoBO estacionamentoBO;

	@CrossOrigin
	@GetMapping
	public Page<EstacionamentoDTO> listar(@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao){
		return estacionamentoBO.listarEstacionamentos(paginacao);
	}
	
	@CrossOrigin
	@GetMapping("/{id}/vagas")
	public List<VagaDTO> listarVagas(@PathVariable Long id) {
		return estacionamentoBO.listarVagas(id);
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<EstacionamentoDTO> cadastrar(@RequestBody List<EstacionamentoDTO> estacionamentoDTO) {
		return estacionamentoBO.cadastrar(estacionamentoDTO);
	}
	
	@CrossOrigin
	@PutMapping("/{id}") 
	public ResponseEntity<Estacionamento> atualizar(@PathVariable Long id, @RequestBody @Valid EstacionamentoDTO estacionamentoDTO){
		return estacionamentoBO.atualizar(id, estacionamentoDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
		return estacionamentoBO.deletar(id);
	}
	
}
