package br.com.hackathonfc.park.bo;

import br.com.hackathonfc.park.dto.EstacionamentoDTO;
import br.com.hackathonfc.park.dto.VagaDTO;
import br.com.hackathonfc.park.model.Estacionamento;
import br.com.hackathonfc.park.service.EstacionamentoService;
import br.com.hackathonfc.park.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstacionamentoBO {

    @Autowired
    private EstacionamentoService estacionamentoService;

    @Autowired
    private VagaService vagaService;

    public Page<EstacionamentoDTO> listarEstacionamentos(Pageable paginacao){
        return estacionamentoService.listar(paginacao);
    }

    public List<VagaDTO> listarVagas(Long id){
        return vagaService.listar(id);
    }

    public ResponseEntity<EstacionamentoDTO> cadastrar(List<EstacionamentoDTO> estacionamentos){
        return estacionamentoService.cadastrar(estacionamentos);
    }

    public ResponseEntity<Estacionamento> atualizar(Long id, EstacionamentoDTO estacionamentoDTO){
        return estacionamentoService.atualizar(id, estacionamentoDTO);
    }

    public ResponseEntity<Estacionamento> deletar(Long id){
        return estacionamentoService.deletar(id);
    }
}
