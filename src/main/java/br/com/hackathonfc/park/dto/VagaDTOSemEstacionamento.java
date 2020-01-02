package br.com.hackathonfc.park.dto;

import br.com.hackathonfc.park.model.Vaga;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VagaDTOSemEstacionamento {

    @Id
    private Long id;

    private boolean livre;

    private Long veiculo_id;

    public VagaDTOSemEstacionamento(Vaga vaga){
        this.id = vaga.getId();
        this.livre = vaga.isLivre();
        this.veiculo_id = vaga.getVeiculo().getId();
    }
}
