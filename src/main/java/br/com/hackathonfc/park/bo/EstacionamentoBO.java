package br.com.hackathonfc.park.bo;

import br.com.hackathonfc.park.dto.EstacionamentoDTO;
import br.com.hackathonfc.park.dto.VagaDTO;
import br.com.hackathonfc.park.dto.VagaDTOSemEstacionamento;
import br.com.hackathonfc.park.exception.CnpjFound;
import br.com.hackathonfc.park.exception.EstacionamentoNotFound;
import br.com.hackathonfc.park.exception.NomeFound;
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

    public ResponseEntity<EstacionamentoDTO> cadastrar(EstacionamentoDTO estacionamento) throws NomeFound, CnpjFound {
        return estacionamentoService.cadastrar(estacionamento);
    }

    public ResponseEntity<EstacionamentoDTO> atualizar(Long id, EstacionamentoDTO estacionamentoDTO) throws EstacionamentoNotFound {
        return estacionamentoService.atualizar(id, estacionamentoDTO);
    }

    public ResponseEntity<Estacionamento> deletar(Long id) throws EstacionamentoNotFound {
        return estacionamentoService.deletar(id);
    }

    public EstacionamentoDTO detalharEstacionamento(Long id) throws EstacionamentoNotFound {
        return estacionamentoService.detalhar(id);
    }
}
