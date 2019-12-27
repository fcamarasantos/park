package br.com.hackathonfc.park.dto;

import br.com.hackathonfc.park.model.Estacionamento;
import br.com.hackathonfc.park.model.Vaga;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VagaDTOSemEstacionamento {

    private Long id;

    private LocalDateTime dataInicio;

    private LocalDateTime dataSaida;

    private boolean livre;

    public VagaDTOSemEstacionamento(Vaga vaga){
        this.id = vaga.getId();
        this.dataInicio = vaga.getDataInicio();
        this.dataSaida = vaga.getDataSaida();
        this.livre = vaga.isLivre();
    }
}
