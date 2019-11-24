package br.com.hackathonfc.park.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hackathonfc.park.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
