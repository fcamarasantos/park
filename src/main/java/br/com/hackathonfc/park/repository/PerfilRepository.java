package br.com.hackathonfc.park.repository;

import br.com.hackathonfc.park.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
