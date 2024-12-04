package br.fateczl.carometro.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fateczl.carometro.model.entities.Historico;

public interface IHistoricoRepository extends JpaRepository<Historico, String> {
	Optional<Historico> findByAlunoRaAndIdHistorico(String RaDoAluno, Long id);
}