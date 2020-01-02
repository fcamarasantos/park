package br.com.hackathonfc.park.controller;

import br.com.hackathonfc.park.dto.VeiculoDTO;
import br.com.hackathonfc.park.exception.PlacaFound;
import br.com.hackathonfc.park.exception.UnmatchedType;
import br.com.hackathonfc.park.exception.VeiculoNotFound;
import br.com.hackathonfc.park.model.Veiculo;
import br.com.hackathonfc.park.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estacionamentos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/{id}/veiculos")
    public List<VeiculoDTO> listarVeiculos(@PathVariable Long id){
        return veiculoService.listarVeiculos(id);
    }

    @GetMapping("/{id}/veiculos/todos")
    public List<VeiculoDTO> listarTodosOsVeiculos(@PathVariable Long id){
        return veiculoService.listarTodosOsVeiculos(id);
    }

    @GetMapping("/{id}/veiculos/{id2}")
    public List<VeiculoDTO> listarVeiculosDeUmaVaga(@PathVariable Long id2) {
        return veiculoService.listarVeiculosDeUmaVaga(id2);
    }

    @PostMapping("/{id}/veiculos")
    public ResponseEntity<VeiculoDTO> cadastrarVeiculo(@RequestBody @Valid VeiculoDTO veiculoDTO) throws PlacaFound, UnmatchedType {
        return veiculoService.cadastrarVeiculo(veiculoDTO);
    }

    @PutMapping("/{id}/veiculos/{id2}")
    @Transactional
    public ResponseEntity<VeiculoDTO> atualizarVeiculo(@PathVariable Long id2, @RequestBody @Valid VeiculoDTO veiculoDTO) throws VeiculoNotFound {
        return veiculoService.atualizarVeiculo(id2, veiculoDTO);
    }

    @DeleteMapping("/{id}/veiculos/{id2}")
    @Transactional
    public ResponseEntity<VeiculoDTO> removerVeiculo(@PathVariable Long id2) throws VeiculoNotFound {
        return veiculoService.removerVeiculo(id2);
    }
}
