package br.com.hackathonfc.park.service;

import br.com.hackathonfc.park.dto.VagaDTO;
import br.com.hackathonfc.park.mapper.VagaMAP;
import br.com.hackathonfc.park.model.Vaga;
import br.com.hackathonfc.park.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    private VagaMAP vagaMAP = new VagaMAP();

    public List<VagaDTO> listar(Long id){
        List<Vaga> vagas = vagaRepository.findAllFromEstacionamento(id);
        return vagaMAP.toDTO(vagas);
    }
}
