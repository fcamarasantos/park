package br.com.hackathonfc.park.mapper;

import br.com.hackathonfc.park.dto.EstacionamentoDTO;
import br.com.hackathonfc.park.model.Estacionamento;
import br.com.hackathonfc.park.model.User;
import br.com.hackathonfc.park.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstacionamentoMAP {

    @Autowired
    private static UserRepository userRepository;

    public static List<Estacionamento> fromDTO(List<EstacionamentoDTO> estacionamentos){
        return estacionamentos.stream().map(e -> {
            return new Estacionamento(e, userRepository.findById(e.getUserId()).get());
        }).collect(Collectors.toList());
    }

    public static Estacionamento fromDTO(EstacionamentoDTO estacionamentoDTO){
        return new Estacionamento(estacionamentoDTO, userRepository.findById(estacionamentoDTO.getUserId()).get());
    }

    public static List<EstacionamentoDTO> toDTO(Page<Estacionamento> estacionamentos){
        return estacionamentos.stream().map(e -> {
            return new EstacionamentoDTO(e, e.getUser());
        }).collect(Collectors.toList());
    }

    public static EstacionamentoDTO toDTO(Estacionamento estacionamento) {
        return new EstacionamentoDTO(estacionamento, estacionamento.getUser());
    }
}
