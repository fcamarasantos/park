package br.com.hackathonfc.park.service;

import br.com.hackathonfc.park.dto.VeiculoDTO;
import br.com.hackathonfc.park.exception.*;
import br.com.hackathonfc.park.mapper.VeiculoMAP;
import br.com.hackathonfc.park.enums.TipoVaga;
import br.com.hackathonfc.park.enums.TipoVeiculo;
import br.com.hackathonfc.park.model.Vaga;
import br.com.hackathonfc.park.model.Veiculo;
import br.com.hackathonfc.park.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private VagaService vagaService;

    private VeiculoMAP veiculoMAP = new VeiculoMAP();

    public List<VeiculoDTO> listarTodosOsVeiculos() throws EstacionamentoNotFound {
        List<Veiculo> veiculos = veiculoRepository.findAll();

        return veiculoMAP.toDTO(veiculos);
    }

    public List<VeiculoDTO> listarVeiculosDoEstacionamento(Long id) throws EstacionamentoNotFound {
        List<Vaga> vagas = vagaService.listarDeUmEstacionamento(id);

        List<VeiculoDTO> veiculos = new ArrayList<VeiculoDTO>();

        for (Vaga vaga : vagas) {
            Veiculo veiculo = vaga.getVeiculo();
            veiculos.add(new VeiculoDTO(veiculo));
        }

        return veiculos;
    }

    public List<VeiculoDTO> listarVeiculosDeUmaVaga(Long id) {
        return veiculoMAP.toDTO(veiculoRepository.findByVagaId(id));
    }

    public ResponseEntity<VeiculoDTO> cadastrarVeiculo(VeiculoDTO veiculoDTO)
            throws PlacaFound, UnmatchedType, VagaNotFound {

        Vaga vaga = new Vaga();

        Optional<Vaga> checkVaga = vagaService.retornarVaga(veiculoDTO.getVagaId());

        boolean isPlacaFound = ValidatePlaca(veiculoDTO.getPlaca());

        if (checkVaga.isPresent()) {
            boolean isTypeValid = ValidadeType(veiculoDTO.getTipoVeiculo(), checkVaga.get().getTipoVaga());

            if (isTypeValid) {
                vaga = checkVaga.get();
            }
            else {
                throw new UnmatchedType();
            }
        }

        if (isPlacaFound == true) throw new PlacaFound();

        try{
            vaga.setLivre(false);
            Veiculo veiculo = veiculoRepository.save(veiculoMAP.fromDTO(veiculoDTO, vaga));
            return ResponseEntity.ok(veiculoMAP.toDTO(veiculo));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<VeiculoDTO> atualizarVeiculo(Long id, VeiculoDTO veiculoDTO)
            throws VeiculoNotFound, VagaNotFound {

        Optional<Veiculo> optional = veiculoRepository.findById(id);

        if(optional.isPresent()) {
            Veiculo veiculo = veiculoRepository.getOne(id);

            veiculo.setCor(veiculoDTO.getCor());
            veiculo.setMarca(veiculoDTO.getMarca());
            veiculo.setModelo(veiculoDTO.getModelo());
            veiculo.setPlaca(veiculoDTO.getPlaca());
            veiculo.setTipoVeiculo(veiculoDTO.getTipoVeiculo());
            veiculo.setVaga(vagaService.retornarVaga(veiculoDTO.getVagaId()).get());

            return ResponseEntity.ok(veiculoMAP.toDTO(veiculo));
        } else {
            throw new VeiculoNotFound();
        }
    }

    public ResponseEntity<VeiculoDTO> removerVeiculo(@PathVariable Long id)
            throws VeiculoNotFound, VagaNotFound {
        Optional<Veiculo> optional = veiculoRepository.findById(id);

        if(optional.isPresent()) {
            Vaga vaga = vagaService.retornarVaga(optional.get().getVaga().getId()).get();
            vaga.setLivre(true);
            veiculoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            throw new VeiculoNotFound();
        }
    }

    public Optional<Veiculo> retornarVeiculo(Long id) throws VeiculoNotFound{
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);

        if(veiculo.isPresent())
            return veiculo;
        else
            throw new VeiculoNotFound();
    }

    private boolean ValidatePlaca(String placa){
        return veiculoRepository.findByPlaca(placa).isPresent();
    }

    private boolean ValidadeType(TipoVeiculo tipoVeiculo, TipoVaga tipoVaga) {
        return tipoVeiculo.toString().equals(tipoVaga.toString());
    }
}
