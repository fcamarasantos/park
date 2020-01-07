package br.com.hackathonfc.park.dto;

import br.com.hackathonfc.park.enums.TipoVaga;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VagaDTOSemEstacionamento {

    @Id
    private Long id;

    private boolean livre;

    private Long veiculo_id;

    private TipoVaga tipoVaga;
}
