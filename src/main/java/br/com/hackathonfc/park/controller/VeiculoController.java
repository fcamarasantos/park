package br.com.hackathonfc.park.controller;

import br.com.hackathonfc.park.dto.VeiculoDTO;
import br.com.hackathonfc.park.exception.PlacaFound;
import br.com.hackathonfc.park.exception.VeiculoNotFound;
import br.com.hackathonfc.park.model.Veiculo;
import br.com.hackathonfc.park.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estacionamentos/{id}/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/{id}")
    public List<VeiculoDTO> listarVeiculo(@PathVariable Long id) {
        return veiculoService.listarVeiculo(id);
    }

    @PostMapping
    public ResponseEntity<List<Veiculo>> cadastrarVeiculo(@RequestBody @Valid List<VeiculoDTO> veiculoDTO) throws PlacaFound {
        return veiculoService.cadastrarVeiculo(veiculoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoDTO> atualizarVeiculo(@PathVariable Long id, @RequestBody @Valid VeiculoDTO veiculoDTO) throws VeiculoNotFound {
        return veiculoService.atualizarVeiculo(id, veiculoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VeiculoDTO> removerVeiculo(@PathVariable Long id) throws VeiculoNotFound {
        return veiculoService.removerVeiculo(id);
    }
}
