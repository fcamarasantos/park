package br.com.hackathonfc.park.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hackathonfc.park.model.Estacionamento;

public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Long>{
	
}
