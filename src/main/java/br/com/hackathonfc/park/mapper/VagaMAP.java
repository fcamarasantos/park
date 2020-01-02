package br.com.hackathonfc.park.mapper;

import br.com.hackathonfc.park.dto.VagaDTO;
import br.com.hackathonfc.park.dto.VagaDTOSemEstacionamento;
import br.com.hackathonfc.park.model.Estacionamento;
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
    private static VeiculoRepository veiculoRepository;

    public static Vaga fromDTO(VagaDTO vagaDTO, Estacionamento estacionamento, Veiculo veiculo){
        return new Vaga(vagaDTO, veiculo, estacionamento);
    }

    public static List<VagaDTO> toDTO(List<Vaga> vagas){
        return vagas.stream().map(v -> {
            Long id = retornarVeiculoId(v.getId());
            return new VagaDTO(v, id);
        }).collect(Collectors.toList());
    }

    public static VagaDTO toDTO(Vaga vaga){
        try {
            Long id = retornarVeiculoId(vaga.getId());
            return new VagaDTO(vaga, id);
        }
        catch(Exception e){
            return new VagaDTO(vaga.getId(), vaga.isLivre(), null, vaga.getTipoVaga());
        }
    }

    public static List<VagaDTOSemEstacionamento> toDTOSemEstacionamento(List<Vaga> vagas){
        return vagas.stream().map(v -> {
            Long id;
            if (v.getVeiculo() == null){
                id = null;
            } else {
                id = retornarVeiculoId(v.getId());
            }

            return new VagaDTOSemEstacionamento(v.getId(), v.isLivre(), id, v.getTipoVaga());
        }).collect(Collectors.toList());
    }

    private static Long retornarVeiculoId(Long id){
        List<Veiculo> veiculos = veiculoRepository.findByVagaId(id);
        return veiculos.get(veiculos.size()-1).getId();
    }
}
