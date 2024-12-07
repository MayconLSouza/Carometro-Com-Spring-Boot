package br.fateczl.carometro.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fateczl.carometro.model.entities.Historico;

@Repository
public interface IHistoricoRepository extends JpaRepository<Historico, String> {
	Optional<Historico> findByHistoricoIdAlunoRaAndHistoricoIdIdHistorico(String alunoRa, Long idHistorico);
}