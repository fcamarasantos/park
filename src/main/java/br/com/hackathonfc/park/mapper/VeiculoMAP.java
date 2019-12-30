package br.com.hackathonfc.park.mapper;

import br.com.hackathonfc.park.dto.VeiculoDTO;
import br.com.hackathonfc.park.model.Veiculo;
import br.com.hackathonfc.park.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VeiculoMAP {

    @Autowired
    private static VagaRepository vagaRepository;

    public static List<VeiculoDTO> toDTO(List<Veiculo> veiculos) {
        return veiculos.stream().map(VeiculoDTO::new).collect(Collectors.toList());
    }

    public static VeiculoDTO toDTO(Veiculo veiculo){
        return new VeiculoDTO(veiculo);
    }

    public static List<Veiculo> fromDTO(List<VeiculoDTO> veiculos){
        return veiculos.stream().map(v -> {return new Veiculo(v, vagaRepository);} ).collect(Collectors.toList());
    }

    public static Veiculo fromDTO(VeiculoDTO veiculoDTO){
        return new Veiculo(veiculoDTO, vagaRepository);
    }
}
