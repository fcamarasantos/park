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
		
		private LocalDateTime dataInicio;
		
		private LocalDateTime dataSaida;
		
		private boolean livre;
		
		public Vaga() {
			
		}

		public Vaga(Long id, LocalDateTime dataInicio,
				LocalDateTime dataSaida, boolean livre) {
			this.id = id;
			this.dataInicio = dataInicio;
			this.dataSaida = dataSaida;
			this.livre = livre;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Vaga other = (Vaga) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		public Long getId() {
			return id;
		}

		public Estacionamento getEstacionamento() {
			return estacionamento;
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
