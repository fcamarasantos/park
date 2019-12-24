package br.com.hackathonfc.park.mapper;

import br.com.hackathonfc.park.dto.VagaDTO;
import br.com.hackathonfc.park.model.Vaga;
import br.com.hackathonfc.park.model.Veiculo;

import java.util.List;
import java.util.stream.Collectors;

public class VagaMAP {

    public List<Vaga> fromDTO(List<VagaDTO> vagas){
        return vagas.stream().map(Vaga::new).collect(Collectors.toList());
    }

    public List<VagaDTO> toDTO(List<Vaga> vagas){
        return vagas.stream().map(VagaDTO::new).collect(Collectors.toList());
    }
}
