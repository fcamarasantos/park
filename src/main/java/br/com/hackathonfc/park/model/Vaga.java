package br.com.hackathonfc.park.model;

import br.com.hackathonfc.park.dto.VagaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaga {

		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@ManyToOne
		private Estacionamento estacionamento;
		
		private LocalDateTime dataInicio;
		
		private LocalDateTime dataSaida;
		
		private boolean livre;

		@OneToOne(mappedBy = "vaga", cascade = CascadeType.ALL, orphanRemoval = true)
		private Veiculo veiculo;

    	public Vaga(VagaDTO vagaDTO) {
			this.estacionamento = vagaDTO.getEstacionamento();
			this.dataInicio = vagaDTO.getDataInicio();
			this.dataSaida = vagaDTO.getDataSaida();
			this.livre = vagaDTO.isLivre();
    	}
}
