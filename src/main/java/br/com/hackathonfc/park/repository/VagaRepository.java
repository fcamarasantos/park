package br.com.hackathonfc.park.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hackathonfc.park.model.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Long> {

}
