package br.com.hackathonfc.park.mapper;

import br.com.hackathonfc.park.dto.VeiculoDTO;
import br.com.hackathonfc.park.model.Veiculo;

import java.util.List;
import java.util.stream.Collectors;

public class VeiculoMAP {

    public List<VeiculoDTO> toDTO(List<Veiculo> veiculos) {
        return veiculos.stream().map(VeiculoDTO::new).collect(Collectors.toList());
    }

    public List<Veiculo> fromDTO(List<VeiculoDTO> veiculos){
        return veiculos.stream().map(Veiculo::new).collect(Collectors.toList());
    }
}
