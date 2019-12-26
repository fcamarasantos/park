package br.com.hackathonfc.park.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.com.hackathonfc.park.mapper.VeiculoMAP;
import br.com.hackathonfc.park.service.VeiculoService;
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

import br.com.hackathonfc.park.dto.VeiculoDTO;
import br.com.hackathonfc.park.model.Veiculo;
import br.com.hackathonfc.park.repository.VagaRepository;
import br.com.hackathonfc.park.repository.VeiculoRepository;

@RestController
@RequestMapping("/estacionamentos/{id}/vagas")
public class VagaController {
		
	@Autowired
	private VeiculoService veiculoService;

	@CrossOrigin
	@GetMapping("/{id}")
	public List<VeiculoDTO> listarVeiculo(@PathVariable Long id) {
		return veiculoService.listarVeiculo(id);
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<List<Veiculo>> cadastrarVeiculo(@RequestBody @Valid List<VeiculoDTO> veiculoDTO) {
		return veiculoService.cadastrarVeiculo(veiculoDTO);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<VeiculoDTO> atualizarVeiculo(@PathVariable Long id, @RequestBody @Valid VeiculoDTO veiculoDTO) {
		return veiculoService.atualizarVeiculo(id, veiculoDTO);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<VeiculoDTO> removerVeiculo(@PathVariable Long id) {
		return veiculoService.removerVeiculo(id);
	}
}
