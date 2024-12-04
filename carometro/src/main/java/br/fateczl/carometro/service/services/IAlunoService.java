package br.fateczl.carometro.service.services;

import java.util.List;

import br.fateczl.carometro.model.entities.Aluno;

public interface IAlunoService {
	
	public Aluno inserir(Aluno aluno);

	public Aluno buscar(String RA) throws ClassNotFoundException;

	public Aluno atualizar(String ra, Aluno aluno) throws ClassNotFoundException;

	public Aluno deletar(String RA);

	public List<Aluno> buscarTodos();
}
