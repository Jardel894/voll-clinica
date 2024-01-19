package br.com.vollclinica.repository;

import br.com.vollclinica.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository  extends JpaRepository<Medico, Long> {

}
