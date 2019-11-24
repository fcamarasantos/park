package br.com.hackathonfc.park.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.hackathonfc.park.controller.form.AtualizacaoEstacionamentoForm;
import br.com.hackathonfc.park.controller.form.EstacionamentoForm;
import br.com.hackathonfc.park.model.Estacionamento;
import br.com.hackathonfc.park.repository.EstacionamentoRepository;

@RestController
@RequestMapping("/estacionamentos")
public class EstacionamentoController {
	
	@Autowired
	private EstacionamentoRepository estacionamentoRepository;
	
	@CrossOrigin
	@GetMapping
	public Page<Estacionamento> listar(@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao){
		
		Page<Estacionamento> estacionamentos;
		
		estacionamentos = estacionamentoRepository.findAll(paginacao);
		
		return estacionamentos;
	}
	
	@CrossOrigin
	@PostMapping
	@Transactional
	public ResponseEntity<Estacionamento>  cadastrar(@RequestBody EstacionamentoForm form, UriComponentsBuilder uriBuilder) {
		Estacionamento estacionamento = form.converter();
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(estacionamento.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new Estacionamento());
	}
	
	@CrossOrigin
	@PutMapping("/{id}") 
	@Transactional
	public ResponseEntity<Estacionamento> atualizar(@PathVariable Long id, @RequestBody @Valid EstacionamentoForm form){
		Optional<Estacionamento> optional = estacionamentoRepository.findById(id);
		
		if(optional.isPresent()) {
			Estacionamento estacionamento = form.atualizar(id, estacionamentoRepository);
			return ResponseEntity.ok(estacionamento);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Estacionamento> optional = estacionamentoRepository.findById(id);
		
		if (optional.isPresent()) {
			estacionamentoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
