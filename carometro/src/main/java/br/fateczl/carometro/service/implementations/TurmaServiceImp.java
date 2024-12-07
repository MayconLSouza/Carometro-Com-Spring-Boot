package br.fateczl.carometro.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fateczl.carometro.model.entities.Turma;
import br.fateczl.carometro.model.enums.Enum_TurnosCursos;
import br.fateczl.carometro.persistence.ITurmaRepository;
import br.fateczl.carometro.service.services.ITurmaService;

@Service
public class TurmaServiceImp implements ITurmaService{

	@Autowired
	ITurmaRepository repositoryTurma;
	
	@Override
	public Turma inserir(Turma turma) throws ClassNotFoundException {
		return repositoryTurma.save(turma);
	}

	@Override
	public Turma buscar(String codigoCurso, Integer ano, Integer semestre, Enum_TurnosCursos turno) throws ClassNotFoundException {
		return repositoryTurma.findByTurmaIdCodigoCursoAndTurmaIdAnoAndTurmaIdSemestreAndTurmaIdTurno(codigoCurso, ano, semestre, turno).orElseThrow(() -> new ClassNotFoundException("Turma Inexistente"));
	}

	@Override
	public Turma deletar(String codigoCurso, Integer ano, Integer semestre, Enum_TurnosCursos turno) throws ClassNotFoundException {
		Optional<Turma> validaTurma = repositoryTurma.findByTurmaIdCodigoCursoAndTurmaIdAnoAndTurmaIdSemestreAndTurmaIdTurno(codigoCurso, ano, semestre, turno);
		if(validaTurma.isPresent()) {
			repositoryTurma.delete(validaTurma.get());
			return validaTurma.get();
		}else{
            throw new IllegalArgumentException("Turma Inexistente no Banco de Dados");
        }
	}

	@Override
	public List<Turma> buscarTodasAsTurmasExistentes() throws ClassNotFoundException {
		List<Turma> turmas = repositoryTurma.findAll();
		if(!turmas.isEmpty()) {
			return turmas;
		}else {
			throw new ClassNotFoundException("Não existem Turmas");
		}
	}

}
