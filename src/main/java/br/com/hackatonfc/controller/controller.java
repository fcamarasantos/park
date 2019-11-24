package br.com.hackatonfc.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.hackatonfc.dtos.EstacionamentoDto;
import br.com.hackatonfc.entities.Estacionamento;
import br.com.hackatonfc.responses.Response;

@RestController
@RequestMapping("/api/estacionamento")

public class controller {
	@Autowired
	private estacionamentoService estacionamentoService;

	@PostMapping(path = "/new")
	public ResponseEntity<Response> cadastrar(@Valid @RequestBody EstacionamentoDto estacionamentoDto, BindingResult result) {
		Response response = new Response();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Estacionamento estacionamentoSalva = this.estacionamentoService.salvar(estacionamentoDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(estacionamentoDto.getId())
				.toUri();
		response.setData(estacionamentoSalva);
		return ResponseEntity.created(location).body(response);
	}
	
	@GetMapping
	public ResponseEntity<List<Estacionamento>> listar() {
		List<Estacionamento> estacionamento = (List<Estacionamento>) estacionamentoService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(estacionamento);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response> buscar(@PathVariable("id") Long id) {
  
		Estacionamento viagem = viagemService.buscar(id);
		Response response = new Response();
		response.setData(viagem);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
