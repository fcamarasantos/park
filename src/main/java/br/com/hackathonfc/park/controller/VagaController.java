package br.com.hackathonfc.park.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.hackathonfc.park.controller.dto.VeiculoDto;
import br.com.hackathonfc.park.controller.form.VeiculoForm;
import br.com.hackathonfc.park.model.Veiculo;
import br.com.hackathonfc.park.repository.VagaRepository;
import br.com.hackathonfc.park.repository.VeiculoRepository;

@RestController
@RequestMapping("/estacionamentos/{id}/vagas")
public class VagaController {
		
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private VagaRepository vagaRepository;
		
	@CrossOrigin
	@GetMapping("/{id}")
	public List<VeiculoDto> listarVeiculo(@PathVariable Long id) {
		List<Veiculo> veiculos = veiculoRepository.findByVagaId(id);
		return VeiculoDto.converter(veiculos);
	}
	
	@CrossOrigin
	@PostMapping
	@Transactional
	public ResponseEntity<VeiculoDto> cadastrarVeiculo(@RequestBody VeiculoForm form, UriComponentsBuilder uriBuilder) {
		Veiculo veiculo = form.converter(vagaRepository);		
		veiculoRepository.save(veiculo);
		
		URI uri = uriBuilder.path("/vagas/{id}").buildAndExpand(veiculo.getId()).toUri();
		return ResponseEntity.created(uri).body(new VeiculoDto(veiculo));
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VeiculoDto> atualizarVeiculo(@PathVariable Long id, @RequestBody @Valid VeiculoForm form) {
		Optional<Veiculo> optional = veiculoRepository.findById(id);
		if(optional.isPresent()) {
			Veiculo veiculo = form.atualizar(id, veiculoRepository);
			return ResponseEntity.ok(new VeiculoDto(veiculo));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> removerVeiculo(@PathVariable Long id) {		
		Optional<Veiculo> optional = veiculoRepository.findById(id);
		if(optional.isPresent()) {
			veiculoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
