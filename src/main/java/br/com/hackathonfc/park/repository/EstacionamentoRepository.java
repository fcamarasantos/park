package br.com.hackathonfc.park.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import br.com.hackathonfc.park.model.Estacionamento;

import java.util.Optional;

public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Long>{
	
	Estacionamento findById(long id);

    Optional<Estacionamento> findByCnpj(Integer cnpj);

    Optional<Estacionamento> findByNome(String nome);
}
