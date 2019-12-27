package br.com.hackathonfc.park.service;

import br.com.hackathonfc.park.dto.EstacionamentoDTO;
import br.com.hackathonfc.park.exception.CnpjFound;
import br.com.hackathonfc.park.exception.EstacionamentoNotFound;
import br.com.hackathonfc.park.exception.NomeFound;
import br.com.hackathonfc.park.mapper.EstacionamentoMAP;
import br.com.hackathonfc.park.model.Estacionamento;
import br.com.hackathonfc.park.repository.EstacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class EstacionamentoService {

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    private EstacionamentoMAP estacionamentoMAP = new EstacionamentoMAP();

    public Page<EstacionamentoDTO> listar(Pageable paginacao){

        List<EstacionamentoDTO> estacionamentos = estacionamentoMAP.toDTO(estacionamentoRepository.findAll(paginacao));

        return new PageImpl<EstacionamentoDTO>(estacionamentos);

    }

    public ResponseEntity<EstacionamentoDTO> cadastrar(EstacionamentoDTO estacionamentoDTO)
        throws CnpjFound, NomeFound {

        boolean isCnpjPresent = validateCnpj(estacionamentoDTO.getCnpj());
        boolean isNomePresent = validateNome(estacionamentoDTO.getNome());

        if (isCnpjPresent){
            throw new CnpjFound();
        } else if(isNomePresent){
                throw new NomeFound();
        }

        try {
            EstacionamentoDTO estacionamento = estacionamentoMAP.toDTO(estacionamentoRepository.save(estacionamentoMAP.fromDTO(estacionamentoDTO)));
            return ResponseEntity.ok(estacionamento);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<EstacionamentoDTO> atualizar(Long id, EstacionamentoDTO estacionamentoDTO)
        throws EstacionamentoNotFound {

        Optional<Estacionamento> checkEstacionamento = estacionamentoRepository.findById(id);

        if (checkEstacionamento.isPresent()){
            Estacionamento estacionamento = estacionamentoRepository.getOne(id);

            estacionamento.setNome(estacionamentoDTO.getNome());
            estacionamento.setCnpj(estacionamentoDTO.getCnpj());
            estacionamento.setEndereco(estacionamentoDTO.getEndereco());
            estacionamento.setPrecoHora(estacionamentoDTO.getPrecoHora());
            estacionamento.setTelefone(estacionamentoDTO.getTelefone());
            estacionamento.setVagasCarros(estacionamentoDTO.getVagasCarros());
            estacionamento.setVagasMotos(estacionamentoDTO.getVagasMotos());

            return ResponseEntity.ok(estacionamentoMAP.toDTO(estacionamento));
        } else{
            throw new EstacionamentoNotFound();
        }

    }

    public ResponseEntity<Estacionamento> deletar(Long id)
        throws EstacionamentoNotFound {

        Optional<Estacionamento> checkEstacionamento = estacionamentoRepository.findById(id);

        if (checkEstacionamento.isPresent()) {
            try{
                estacionamentoRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }
            catch(Exception e){
                System.out.println(e);
            }
        } else {
            throw new EstacionamentoNotFound();
        }

        return ResponseEntity.notFound().build();
    }

    public EstacionamentoDTO detalhar(Long id) {
        return estacionamentoMAP.toDTO(estacionamentoRepository.findById(id).get());
    }

    public boolean validateCnpj(@NotNull int cnpj){
        return estacionamentoRepository.findByCnpj(cnpj).isPresent();
    }

    private boolean validateNome(String nome) {
        return estacionamentoRepository.findByNome(nome).isPresent();
    }
}
