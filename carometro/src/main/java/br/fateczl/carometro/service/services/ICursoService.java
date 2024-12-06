package br.fateczl.carometro.service.services;

import java.util.List;

import br.fateczl.carometro.model.entities.Curso;

public interface ICursoService {

	public Curso inserir (Curso curso);
	public Curso buscar (String codigo) throws ClassNotFoundException;
	public Curso atualizar (String codigo, Curso curso) throws ClassNotFoundException;
	public Curso deletar (String codigo);
	public List<Curso> buscarTodos() throws ClassNotFoundException;
	
}
