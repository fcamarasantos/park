package br.com.hackathonfc.park.mapper;

import br.com.hackathonfc.park.dto.VagaDTO;
import br.com.hackathonfc.park.dto.VagaDTOSemEstacionamento;
import br.com.hackathonfc.park.model.Vaga;
import br.com.hackathonfc.park.model.Veiculo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VagaMAP {

    public static List<Vaga> fromDTO(List<VagaDTO> vagas){
        return vagas.stream().map(Vaga::new).collect(Collectors.toList());
    }

    public static List<VagaDTO> toDTO(List<Vaga> vagas){
        return vagas.stream().map(VagaDTO::new).collect(Collectors.toList());
    }

    public static List<VagaDTOSemEstacionamento> toDTOSemEstacionamento(List<Vaga> vagas){
        return vagas.stream().map(VagaDTOSemEstacionamento::new).collect(Collectors.toList());
    }
}
