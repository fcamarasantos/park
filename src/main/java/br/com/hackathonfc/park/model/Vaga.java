package br.com.hackathonfc.park.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Vaga {

		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@ManyToOne
		private Estacionamento estacionamento;
		
		@OneToOne
		private Veiculo carro;
		
		private LocalDateTime dataInicio;
		
		private LocalDateTime dataSaida;
		
		private boolean livre;
		
		public Vaga() {
			
		}

		public Vaga(Long id, Estacionamento estacionamento, Veiculo carro, LocalDateTime dataInicio,
				LocalDateTime dataSaida, boolean livre) {
			this.id = id;
			this.estacionamento = estacionamento;
			this.carro = carro;
			this.dataInicio = dataInicio;
			this.dataSaida = dataSaida;
			this.livre = livre;
		}

		public Long getId() {
			return id;
		}

		public Estacionamento getEstacionamento() {
			return estacionamento;
		}

		public Veiculo getCarro() {
			return carro;
		}

		public LocalDateTime getDataInicio() {
			return dataInicio;
		}

		public LocalDateTime getDataSaida() {
			return dataSaida;
		}

		public boolean isLivre() {
			return livre;
		}
		
		
		
		
		
		
}
