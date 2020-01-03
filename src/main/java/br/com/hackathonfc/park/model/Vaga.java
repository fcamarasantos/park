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
import java.util.Arrays;
import java.util.List;

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

		@Enumerated(EnumType.STRING)
		private TipoVaga tipoVaga = TipoVaga.CARRO;

		@OneToOne(mappedBy = "vaga", cascade = CascadeType.ALL, orphanRemoval = true)
		private Veiculo veiculo;

    	public Vaga(VagaDTO vagaDTO, Veiculo veiculo, Estacionamento estacionamento) {
			this.veiculo = veiculo;
			this.livre = vagaDTO.isLivre();
			this.estacionamento = estacionamento;
			this.tipoVaga = vagaDTO.getTipoVaga();
    	}
}
