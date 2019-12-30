package br.com.hackathonfc.park.service;

import br.com.hackathonfc.park.dto.VagaDTO;
import br.com.hackathonfc.park.dto.VagaDTOSemEstacionamento;
import br.com.hackathonfc.park.exception.EstacionamentoNotFound;
import br.com.hackathonfc.park.exception.VagaNotFound;
import br.com.hackathonfc.park.mapper.VagaMAP;
import br.com.hackathonfc.park.model.Vaga;
import br.com.hackathonfc.park.repository.VagaRepository;
import br.com.hackathonfc.park.repository.VeiculoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    private VagaMAP vagaMAP;

    public List<VagaDTOSemEstacionamento> listar(Long id) throws EstacionamentoNotFound {
        List<Vaga> vagas = vagaRepository.findAllFromEstacionamento(id);
        return vagaMAP.toDTOSemEstacionamento(vagas);
    }

    public ResponseEntity<VagaDTO> cadastrar(VagaDTO vagaDTO) {
        try {
            Vaga vaga = vagaRepository.save(vagaMAP.fromDTO(vagaDTO));
            return ResponseEntity.ok(vagaMAP.toDTO(vaga));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<VagaDTO> atualizar(Long id, VagaDTO vagaDTO) throws VagaNotFound{
        Optional<Vaga> checkVaga = vagaRepository.findById(id);

        if(checkVaga.isPresent()){
            Vaga vaga = vagaRepository.getOne(id);

            vaga.setLivre(vagaDTO.isLivre());
            vaga.setVeiculo(veiculoRepository.findById(vagaDTO.getVeiculo_id()).get());

            return ResponseEntity.ok(vagaMAP.toDTO(vaga));
        }
        else {
            throw new VagaNotFound();
        }
    }

    public ResponseEntity<VagaDTO> remover(Long id) throws VagaNotFound{
        Optional<Vaga> checkVaga = vagaRepository.findById(id);

        if(checkVaga.isPresent()){
            vagaRepository.deleteById(id);

            return ResponseEntity.ok().build();
        }
        else {
            throw new VagaNotFound();
        }
    }
}
