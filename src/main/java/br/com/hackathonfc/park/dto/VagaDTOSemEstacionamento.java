package br.com.hackathonfc.park.dto;

import br.com.hackathonfc.park.model.TipoVaga;
import br.com.hackathonfc.park.model.TipoVeiculo;
import br.com.hackathonfc.park.model.Vaga;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VagaDTOSemEstacionamento {

    @Id
    private Long id;

    private boolean livre;

    private Long veiculo_id;

    private TipoVaga tipoVaga;

    public VagaDTOSemEstacionamento(Vaga vaga){
        this.id = vaga.getId();
        this.livre = vaga.isLivre();
        this.veiculo_id = vaga.getVeiculo().get(vaga.getVeiculo().size() - 1).getId();
        this.tipoVaga = vaga.getTipoVaga();
    }
}
