package br.com.hackathonfc.park.service;

import br.com.hackathonfc.park.dto.VagaDTO;
import br.com.hackathonfc.park.dto.VagaDTOSemEstacionamento;
import br.com.hackathonfc.park.exception.EstacionamentoNotFound;
import br.com.hackathonfc.park.exception.VagaNotFound;
import br.com.hackathonfc.park.exception.VeiculoNotFound;
import br.com.hackathonfc.park.mapper.VagaMAP;
import br.com.hackathonfc.park.model.Estacionamento;
import br.com.hackathonfc.park.model.Vaga;
import br.com.hackathonfc.park.model.Veiculo;
import br.com.hackathonfc.park.repository.VagaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private EstacionamentoService estacionamentoService;

    private VagaMAP vagaMAP;

    public List<VagaDTOSemEstacionamento> listar(Long id) throws EstacionamentoNotFound {
        Optional<Estacionamento> checkEstacionamento = estacionamentoService.retornarEstacionamento(id);
        List<Vaga> vagas;

        if(checkEstacionamento.isPresent()){
            vagas = vagaRepository.findAllFromEstacionamento(id);
        } else{
            throw new EstacionamentoNotFound();
        }

        return vagaMAP.toDTOSemEstacionamento(vagas);
    }

    public ResponseEntity<VagaDTO> cadastrar(VagaDTO vagaDTO, Long id) {
        try {
            Estacionamento estacionamento = estacionamentoService.retornarEstacionamento(id).get();
            Optional<Veiculo> checkVeiculo = veiculoService.retornarVeiculo(vagaDTO.getVeiculo_id());
            Veiculo veiculo;

            if (!checkVeiculo.isPresent()) {
                veiculo = null;
            } else{
                veiculo = checkVeiculo.get();
            }

            Vaga vaga = vagaRepository.save(vagaMAP.fromDTO(vagaDTO, estacionamento, veiculo));
            return ResponseEntity.ok(vagaMAP.toDTO(vaga));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<VagaDTO> atualizar(Long id, VagaDTO vagaDTO) throws VagaNotFound, VeiculoNotFound {
        Optional<Vaga> checkVaga = vagaRepository.findById(id);
        Veiculo veiculo = new Veiculo();

        if(checkVaga.isPresent()){
            Vaga vaga = vagaRepository.getOne(id);

            if (vagaDTO.getVeiculo_id() != null) {

                Optional<Veiculo> checkVeiculo = veiculoService.retornarVeiculo(vagaDTO.getVeiculo_id());

                if (checkVeiculo.isPresent()){
                    veiculo = checkVeiculo.get();
                }
            }

            vaga.setLivre(vagaDTO.isLivre());
            vaga.setVeiculo(veiculo);

            vagaRepository.save(vaga);

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

    public VagaDTO detalhar(Long id) throws VagaNotFound{
        Optional<Vaga> checkVaga = vagaRepository.findById(id);
        Vaga vaga;

        if (checkVaga.isPresent()){
            vaga = checkVaga.get();
        } else {
            throw new VagaNotFound();
        }

        return vagaMAP.toDTO(vaga);
    }

    public List<Vaga> listarDeUmEstacionamento(Long id) throws EstacionamentoNotFound{
        Optional<Estacionamento> estacionamento = estacionamentoService.retornarEstacionamento(id);

        if (estacionamento.isPresent()){
            return vagaRepository.findAllFromEstacionamento(id);
        }
        else {
            throw new EstacionamentoNotFound();
        }
    }

    public Optional<Vaga> retornarVaga(Long id) throws VagaNotFound{
        Optional<Vaga> vaga = vagaRepository.findById(id);

        if (vaga.isPresent()){
            return vagaRepository.findById(id);
        }
        else {
            throw new VagaNotFound();
        }
    }

    public Vaga cadastrarVaga(Vaga vaga, Long id){
        try {
            Optional<Estacionamento> estacionamento = estacionamentoService.retornarEstacionamento(id);

            if (estacionamento.isPresent()) {
                return vagaRepository.save(vaga);
            } else {
                throw new EstacionamentoNotFound();
            }
        }
        catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }
}
