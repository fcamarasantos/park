package br.com.hackathonfc.park.mapper;

import br.com.hackathonfc.park.dto.VeiculoDTO;
import br.com.hackathonfc.park.model.Veiculo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VeiculoMAP {

    public static List<VeiculoDTO> toDTO(List<Veiculo> veiculos) {
        return veiculos.stream().map(VeiculoDTO::new).collect(Collectors.toList());
    }

    public static List<Veiculo> fromDTO(List<VeiculoDTO> veiculos){
        return veiculos.stream().map(Veiculo::new).collect(Collectors.toList());
    }

    public static VeiculoDTO toDTO(Veiculo veiculo) {
        return new VeiculoDTO(veiculo);
    }
}
