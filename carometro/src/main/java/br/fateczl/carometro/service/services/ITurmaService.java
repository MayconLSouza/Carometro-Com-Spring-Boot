package br.fateczl.carometro.service.services;

import java.util.List;

import br.fateczl.carometro.model.entities.Turma;

public interface ITurmaService {
	
	public Turma inserir(Turma turma) throws ClassNotFoundException;
	
	public Turma buscar(String codigoCurso, Integer ano, Integer semestre) throws ClassNotFoundException;
	
	public Turma atualizar(String codigoCurso, Integer ano, Integer semestre, Turma turmaAtualizada) throws ClassNotFoundException;
	
	public Turma deletar(String codigoCurso, Integer ano, Integer semestre) throws ClassNotFoundException;
	
	public List<Turma> buscarTodasAsTurmasExistentes() throws ClassNotFoundException;
}