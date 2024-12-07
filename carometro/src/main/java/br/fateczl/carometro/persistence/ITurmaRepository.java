package br.fateczl.carometro.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fateczl.carometro.model.entities.Turma;
import br.fateczl.carometro.model.enums.Enum_TurnosCursos;
import br.fateczl.carometro.model.primarykeysclass.TurmaId;

@Repository
public interface ITurmaRepository extends JpaRepository<Turma, TurmaId>{
	
	Optional<Turma> findByTurmaIdCodigoCursoAndTurmaIdAnoAndTurmaIdSemestreAndTurmaIdTurno(String codigoCurso, Integer ano, Integer semestre, Enum_TurnosCursos turno);

}
