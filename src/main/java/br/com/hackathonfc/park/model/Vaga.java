package br.com.hackathonfc.park.model;

import br.com.hackathonfc.park.dto.VagaDTO;
import br.com.hackathonfc.park.enums.TipoVaga;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaga {

		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private boolean livre = true;

        @Enumerated(EnumType.STRING)
		private TipoVaga tipoVaga = TipoVaga.CARRO;

        @ManyToOne
        private Estacionamento estacionamento;

		@OneToOne(mappedBy = "vaga", cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, orphanRemoval = true)
		private Veiculo veiculo;

    	public Vaga(VagaDTO vagaDTO, Veiculo veiculo, Estacionamento estacionamento) {
			this.veiculo = veiculo;
			this.livre = vagaDTO.isLivre();
			this.estacionamento = estacionamento;
			this.tipoVaga = vagaDTO.getTipoVaga();
    	}

    	public Vaga(Estacionamento estacionamento, TipoVaga tipoVaga){
    		this.veiculo = null;
    		this.livre = true;
    		this.estacionamento = estacionamento;
    		this.tipoVaga = tipoVaga;
		}

		public Vaga(Estacionamento estacionamento, Boolean livre, TipoVaga tipoVaga, Veiculo veiculo){
    		this.estacionamento = estacionamento;
    		this.livre = livre;
    		this.tipoVaga = tipoVaga;
    		this.veiculo = veiculo;
		}
}
