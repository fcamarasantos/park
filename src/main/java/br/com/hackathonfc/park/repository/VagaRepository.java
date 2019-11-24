package br.com.hackathonfc.park.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.hackathonfc.park.model.Vaga;
import br.com.hackathonfc.park.model.Veiculo;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
	
	@Query("SELECT v FROM Vaga v WHERE v.estacionamento.id = :id")
	List<Vaga> findAllFromEstacionamento(@Param("id") Long id);	

}
