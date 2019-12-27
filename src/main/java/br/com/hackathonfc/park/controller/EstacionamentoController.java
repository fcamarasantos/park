package br.com.hackathonfc.park.controller;

import java.util.List;

import javax.validation.Valid;

import br.com.hackathonfc.park.bo.EstacionamentoBO;
import br.com.hackathonfc.park.dto.VagaDTOSemEstacionamento;
import br.com.hackathonfc.park.exception.CnpjFound;
import br.com.hackathonfc.park.exception.EstacionamentoNotFound;
import br.com.hackathonfc.park.exception.NomeFound;
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
import org.springframework.web.bind.annotation.RestController;

import br.com.hackathonfc.park.dto.VagaDTO;
import br.com.hackathonfc.park.dto.EstacionamentoDTO;
import br.com.hackathonfc.park.model.Estacionamento;

@RestController
@RequestMapping("/estacionamentos")
public class EstacionamentoController {

	@Autowired
	private EstacionamentoBO estacionamentoBO;

	@CrossOrigin
	@GetMapping("/{id}")
	public EstacionamentoDTO detalhar(@PathVariable Long id){
		return estacionamentoBO.detalharEstacionamento(id);
	}

	@CrossOrigin
	@GetMapping
	public Page<EstacionamentoDTO> listar(@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao){
		return estacionamentoBO.listarEstacionamentos(paginacao);
	}
	
	@CrossOrigin
	@GetMapping("/{id}/vagas")
	public List<VagaDTOSemEstacionamento> listarVagas(@PathVariable Long id) {
		return estacionamentoBO.listarVagas(id);
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<List<Estacionamento>> cadastrar(@RequestBody List<EstacionamentoDTO> estacionamentoDTO) throws NomeFound, CnpjFound {
		return estacionamentoBO.cadastrar(estacionamentoDTO);
	}
	
	@CrossOrigin
	@PutMapping("/{id}") 
	public ResponseEntity<Estacionamento> atualizar(@PathVariable Long id, @RequestBody @Valid EstacionamentoDTO estacionamentoDTO) throws EstacionamentoNotFound {
		return estacionamentoBO.atualizar(id, estacionamentoDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Estacionamento> remover(@PathVariable Long id) throws EstacionamentoNotFound {
		return estacionamentoBO.deletar(id);
	}
	
}
