package br.com.hackathonfc.park.mapper;

import br.com.hackathonfc.park.dto.EstacionamentoDTO;
import br.com.hackathonfc.park.dto.VagaDTO;
import br.com.hackathonfc.park.model.Estacionamento;
import br.com.hackathonfc.park.model.Vaga;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class EstacionamentoMAP {

    public List<Estacionamento> fromDTO(List<EstacionamentoDTO> estacionamentos){
        return estacionamentos.stream().map(Estacionamento::new).collect(Collectors.toList());
    }

    public List<EstacionamentoDTO> toDTO(Page<Estacionamento> estacionamentos){
        return estacionamentos.stream().map(EstacionamentoDTO::new).collect(Collectors.toList());
    }

}
