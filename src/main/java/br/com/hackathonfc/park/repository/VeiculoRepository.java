package br.com.hackathonfc.park.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.hackathonfc.park.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	@Query("SELECT v FROM Veiculo v WHERE v.vaga.id = :id")
	List<Veiculo> findByVagaId(@Param("id") Long id);

    Optional<Veiculo> findByPlaca(String placa);
}
