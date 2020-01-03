package br.com.hackathonfc.park.service;

import br.com.hackathonfc.park.dto.VagaDTO;
import br.com.hackathonfc.park.dto.VagaDTOSemEstacionamento;
import br.com.hackathonfc.park.exception.EstacionamentoNotFound;
import br.com.hackathonfc.park.exception.VagaNotFound;
import br.com.hackathonfc.park.mapper.VagaMAP;
import br.com.hackathonfc.park.model.Estacionamento;
import br.com.hackathonfc.park.model.Vaga;
import br.com.hackathonfc.park.model.Veiculo;
import br.com.hackathonfc.park.repository.EstacionamentoRepository;
import br.com.hackathonfc.park.repository.VagaRepository;
import br.com.hackathonfc.park.repository.VeiculoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    private VagaMAP vagaMAP;

    public List<VagaDTOSemEstacionamento> listar(Long id) throws EstacionamentoNotFound {
        Optional<Estacionamento> checkEstacionamento = estacionamentoRepository.findById(id);
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
            Estacionamento estacionamento = estacionamentoRepository.findById(id).get();
            Optional<Veiculo> checkVeiculo = veiculoRepository.findById(vagaDTO.getVeiculo_id());
            Veiculo veiculo;

            if (!checkVeiculo.isPresent()) {
                veiculo = null;
            } else{
                veiculo = veiculoRepository.getOne(vagaDTO.getVeiculo_id());
            }

            Vaga vaga = vagaRepository.save(vagaMAP.fromDTO(vagaDTO, estacionamento, veiculo));
            return ResponseEntity.ok(vagaMAP.toDTO(vaga));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<VagaDTO> atualizar(Long id, VagaDTO vagaDTO) throws VagaNotFound{
        Optional<Vaga> checkVaga = vagaRepository.findById(id);
        Veiculo veiculo = new Veiculo();

        if(checkVaga.isPresent()){
            Vaga vaga = vagaRepository.getOne(id);

            if (vagaDTO.getVeiculo_id() != null) {

                Optional<Veiculo> checkVeiculo = veiculoRepository.findById(vagaDTO.getVeiculo_id());

                if (checkVeiculo.isPresent()){
                    veiculo = veiculoRepository.getOne(vagaDTO.getVeiculo_id());
                }
            }

            vaga.setLivre(vagaDTO.isLivre());
            vaga.setVeiculo(veiculo);

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
}
