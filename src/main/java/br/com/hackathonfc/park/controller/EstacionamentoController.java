package br.com.hackathonfc.park.controller;

import java.net.URI;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.hackathonfc.park.controller.dto.VagaDto;
import br.com.hackathonfc.park.controller.form.AtualizacaoEstacionamentoForm;
import br.com.hackathonfc.park.controller.form.EstacionamentoForm;
import br.com.hackathonfc.park.model.Estacionamento;
import br.com.hackathonfc.park.model.Vaga;
import br.com.hackathonfc.park.repository.EstacionamentoRepository;
import br.com.hackathonfc.park.repository.VagaRepository;

@RestController
@RequestMapping("/estacionamentos")
public class EstacionamentoController {
	
	@Autowired
	private EstacionamentoRepository estacionamentoRepository;
	
	@Autowired
	private VagaRepository vagaRepository;
	
	
	@RequestMapping(value="/cadastro", method=RequestMethod.POST )
	   public String form(){
	   return"cadastro";
	}
	
	

	
	
	@CrossOrigin
	@GetMapping
	public Page<Estacionamento> listar(@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao){
		
		Page<Estacionamento> estacionamentos;
		
		estacionamentos = estacionamentoRepository.findAll(paginacao);
		
		return estacionamentos;
	}
	
	@CrossOrigin
	@GetMapping("/{id}/vagas")
	public List<VagaDto> listarVagas(@PathVariable Long id) {
		List<Vaga> vagas = vagaRepository.findAllFromEstacionamento(id);
		return VagaDto.converter(vagas);	
	}
	
	@CrossOrigin
	@PostMapping
	@Transactional
	public ResponseEntity<Estacionamento> cadastrar(@RequestBody EstacionamentoForm estacionamentoForm,
			UriComponentsBuilder uriBuilder) {
		Estacionamento estacionamento = estacionamentoForm.converter();
		estacionamentoRepository.save(estacionamento);
		
		int vagasTotal = estacionamento.getVagasCarros() + estacionamento.getVagasMotos();
		
		for(int i = 0; i < vagasTotal; i++) {
			Vaga vaga = new Vaga(estacionamento, null, null, true);
			vagaRepository.save(vaga);
		}
		
		URI uri = uriBuilder.path("/estacionamentos/{id}").buildAndExpand(estacionamento.getId()).toUri();
		return ResponseEntity.created(uri).body(estacionamento);
	}
	
	@CrossOrigin
	@PutMapping("/{id}") 
	@Transactional
	public ResponseEntity<Estacionamento> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoEstacionamentoForm form){
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
