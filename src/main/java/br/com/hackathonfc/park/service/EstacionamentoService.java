package br.com.hackathonfc.park.service;

import br.com.hackathonfc.park.dto.EstacionamentoDTO;
import br.com.hackathonfc.park.mapper.EstacionamentoMAP;
import br.com.hackathonfc.park.model.Estacionamento;
import br.com.hackathonfc.park.repository.EstacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstacionamentoService {

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    @Autowired
    private EstacionamentoMAP estacionamentoMAP;

    public Page<EstacionamentoDTO> listar(Pageable paginacao){

        List<EstacionamentoDTO> estacionamentos = estacionamentoMAP.toDTO(estacionamentoRepository.findAll(paginacao));

        return new PageImpl<>(estacionamentos);

    }

    public ResponseEntity<EstacionamentoDTO> cadastrar(List<EstacionamentoDTO> estacionamentoDTO){
        try {
            EstacionamentoDTO estacionamento = (EstacionamentoDTO) estacionamentoRepository.saveAll(estacionamentoMAP.fromDTO(estacionamentoDTO));
            return ResponseEntity.ok().body(estacionamento);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Estacionamento> atualizar(Long id, EstacionamentoDTO estacionamentoDTO){
        Optional<Estacionamento> checkEstacionamento = estacionamentoRepository.findById(id);

        if (checkEstacionamento.isPresent()){
            Estacionamento estacionamento = checkEstacionamento.get();

            estacionamento.setNome(estacionamentoDTO.getNome());
            estacionamento.setCnpj(estacionamentoDTO.getCnpj());
            estacionamento.setEndereco(estacionamentoDTO.getEndereco());
            estacionamento.setPrecoHora(estacionamentoDTO.getPrecoHora());
            estacionamento.setTelefone(estacionamentoDTO.getTelefone());
            estacionamento.setVagasCarros(estacionamentoDTO.getVagasCarros());
            estacionamento.setVagasMotos(estacionamentoDTO.getVagasMotos());

            return ResponseEntity.ok(estacionamento);
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Estacionamento> deletar(Long id){
        Optional<Estacionamento> checkEstacionamento = estacionamentoRepository.findById(id);

        if (checkEstacionamento.isPresent()) {
            estacionamentoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
