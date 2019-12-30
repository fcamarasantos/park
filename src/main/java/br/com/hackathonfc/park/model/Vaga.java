package br.com.hackathonfc.park.model;

import br.com.hackathonfc.park.dto.VagaDTO;
import br.com.hackathonfc.park.repository.EstacionamentoRepository;
import br.com.hackathonfc.park.repository.VagaRepository;
import br.com.hackathonfc.park.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

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

		private boolean livre;

		@OneToOne(mappedBy = "vaga", cascade = CascadeType.ALL, orphanRemoval = true)
		private Veiculo veiculo;

    	public Vaga(VagaDTO vagaDTO, EstacionamentoRepository estacionamentoRepository, VeiculoRepository veiculoRepository) {
			this.estacionamento = estacionamentoRepository.findById(vagaDTO.getEstacionamento_id()).get();
			this.veiculo = veiculoRepository.findById(vagaDTO.getVeiculo_id()).get();
			this.livre = vagaDTO.isLivre();
    	}
}
