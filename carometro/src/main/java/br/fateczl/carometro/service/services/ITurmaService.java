package br.fateczl.carometro.service.services;

import java.util.List;

import br.fateczl.carometro.model.entities.Turma;
import br.fateczl.carometro.model.enums.Enum_TurnosCursos;

public interface ITurmaService {
	
	public Turma inserir(Turma turma) throws ClassNotFoundException;

	public Turma buscar(String codigoCurso, Integer ano, Integer semestre, Enum_TurnosCursos turno) throws ClassNotFoundException;
		
	public Turma deletar(String codigoCurso, Integer ano, Integer semestre, Enum_TurnosCursos turno) throws ClassNotFoundException;
	
	public List<Turma> buscarTodasAsTurmasExistentes() throws ClassNotFoundException;
}