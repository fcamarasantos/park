package br.com.hackathonfc.park.dto;

import br.com.hackathonfc.park.enums.TipoVaga;
import br.com.hackathonfc.park.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VagaDTO {

	@Id
	private Long id;

	@NotNull
	private boolean livre;

	private Long veiculo_id;

	@NotNull
	private TipoVaga tipoVaga;

	public VagaDTO(Vaga vaga) {
		this.id = vaga.getId();
		this.livre = vaga.isLivre();
		this.veiculo_id = vaga.getVeiculo().getId();
		this.tipoVaga = vaga.getTipoVaga();
	}
}
