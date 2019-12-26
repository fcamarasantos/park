package br.com.hackathonfc.park.service;

import br.com.hackathonfc.park.dto.EstacionamentoDTO;
import br.com.hackathonfc.park.dto.VeiculoDTO;
import br.com.hackathonfc.park.exception.CnpjFound;
import br.com.hackathonfc.park.exception.NomeFound;
import br.com.hackathonfc.park.exception.PlacaFound;
import br.com.hackathonfc.park.exception.VeiculoNotFound;
import br.com.hackathonfc.park.mapper.VeiculoMAP;
import br.com.hackathonfc.park.model.Veiculo;
import br.com.hackathonfc.park.repository.VagaRepository;
import br.com.hackathonfc.park.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private VagaRepository vagaRepository;

    private VeiculoMAP veiculoMAP = new VeiculoMAP();

    public List<VeiculoDTO> listarVeiculo(@PathVariable Long id) {
        return veiculoMAP.toDTO(veiculoRepository.findByVagaId(id));
    }

    public ResponseEntity<List<Veiculo>> cadastrarVeiculo(List<VeiculoDTO> veiculosDTO)
        throws PlacaFound {
        
        boolean isPlacaPresent;

        for (VeiculoDTO veiculoDTO : veiculosDTO) {
            isPlacaPresent = validatePlaca(veiculoDTO.getPlaca());

            if (isPlacaPresent) {
                throw new PlacaFound();
            }
        }
        
        List<Veiculo> veiculos = veiculoMAP.fromDTO(veiculosDTO);

        try{
            veiculoRepository.saveAll(veiculos);
            return ResponseEntity.ok(veiculos);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<VeiculoDTO> atualizarVeiculo(Long id, VeiculoDTO veiculoDTO)
        throws VeiculoNotFound {

        Optional<Veiculo> optional = veiculoRepository.findById(id);

        if(optional.isPresent()) {
            Veiculo veiculo = veiculoRepository.getOne(id);

            veiculo.setCor(veiculoDTO.getCor());
            veiculo.setMarca(veiculoDTO.getMarca());
            veiculo.setModelo(veiculoDTO.getModelo());
            veiculo.setPlaca(veiculoDTO.getPlaca());
            veiculo.setTipoVeiculo(veiculoDTO.getTipoVeiculo());
            veiculo.setVaga(vagaRepository.findById(veiculoDTO.getVagaId()).get());

            return ResponseEntity.ok(veiculoMAP.toDTO(veiculo));
        } else {
            throw new VeiculoNotFound();
        }
    }

    public ResponseEntity<VeiculoDTO> removerVeiculo(@PathVariable Long id)
        throws VeiculoNotFound {
        Optional<Veiculo> optional = veiculoRepository.findById(id);

        if(optional.isPresent()) {
            veiculoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            throw new VeiculoNotFound();
        }
    }

    private boolean validatePlaca(String placa) {
        return veiculoRepository.findByPlaca(placa).isPresent();
    }
}
