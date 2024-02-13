package br.com.vollclinica.repository;

import br.com.vollclinica.entities.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository  extends JpaRepository<Consulta, Long> {
}
