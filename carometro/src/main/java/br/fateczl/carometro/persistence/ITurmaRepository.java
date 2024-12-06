package br.fateczl.carometro.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fateczl.carometro.model.entities.Turma;
import br.fateczl.carometro.model.primarykeysclass.TurmaId;

public interface ITurmaRepository extends JpaRepository<Turma, TurmaId>{
	
	Optional<Turma> findByTurmIdCodigoCursoAndTurmIdAnoAndTurmIdSemestre(String codigoCurso, Integer ano, Integer semestre);

}
