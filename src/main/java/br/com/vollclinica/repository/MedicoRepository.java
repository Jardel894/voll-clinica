package br.com.vollclinica.repository;

import br.com.vollclinica.entities.Medico;
import br.com.vollclinica.enums.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository  extends JpaRepository<Medico, Long> {


    List<Medico> findByEspecialidade(Especialidade especialidade);
}
