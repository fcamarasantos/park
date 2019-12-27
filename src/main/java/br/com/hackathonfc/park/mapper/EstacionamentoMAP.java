package br.com.hackathonfc.park.mapper;

import br.com.hackathonfc.park.dto.EstacionamentoDTO;
import br.com.hackathonfc.park.model.Estacionamento;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstacionamentoMAP {

    public static List<Estacionamento> fromDTO(List<EstacionamentoDTO> estacionamentos){
        return estacionamentos.stream().map(Estacionamento::new).collect(Collectors.toList());
    }

    public static Estacionamento fromDTO(EstacionamentoDTO estacionamentoDTO){
        return new Estacionamento(estacionamentoDTO);
    }

    public static List<EstacionamentoDTO> toDTO(Page<Estacionamento> estacionamentos){
        return estacionamentos.stream().map(EstacionamentoDTO::new).collect(Collectors.toList());
    }

    public static List<EstacionamentoDTO> toDTO(List<Estacionamento> estacionamentos){
        return estacionamentos.stream().map(EstacionamentoDTO::new).collect(Collectors.toList());
    }

    public static EstacionamentoDTO toDTO(Estacionamento estacionamento) {
        return new EstacionamentoDTO(estacionamento);
    }
}
