package br.com.hackathonfc.park.mapper;

import br.com.hackathonfc.park.dto.VagaDTO;
import br.com.hackathonfc.park.dto.VagaDTOSemEstacionamento;
import br.com.hackathonfc.park.model.Vaga;
import br.com.hackathonfc.park.model.Veiculo;
import br.com.hackathonfc.park.repository.EstacionamentoRepository;
import br.com.hackathonfc.park.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VagaMAP {

    @Autowired
    private static EstacionamentoRepository estacionamentoRepository;

    @Autowired
    private static VeiculoRepository veiculoRepository;

    public static List<Vaga> fromDTO(List<VagaDTO> vagas){
        return vagas.stream().map(v -> {return new Vaga(v, estacionamentoRepository, veiculoRepository);} ).collect(Collectors.toList());
    }

    public static Vaga fromDTO(VagaDTO vagaDTO){
        return new Vaga(vagaDTO, estacionamentoRepository, veiculoRepository);
    }

    public static List<VagaDTO> toDTO(List<Vaga> vagas){
        return vagas.stream().map(VagaDTO::new).collect(Collectors.toList());
    }

    public static VagaDTO toDTO(Vaga vaga){
        return new VagaDTO(vaga);
    }

    public static List<VagaDTOSemEstacionamento> toDTOSemEstacionamento(List<Vaga> vagas){
        return vagas.stream().map(VagaDTOSemEstacionamento::new).collect(Collectors.toList());
    }
}
