package br.fateczl.carometro.service.services;

import java.util.List;

import br.fateczl.carometro.model.entities.Historico;

public interface IHistoricoService {

	public Historico inserir(Historico historico);

	public Historico buscar(String raDoAluno, Long id) throws ClassNotFoundException;

	public Historico atualizar(String raDoAluno, Long id, Historico aluno) throws ClassNotFoundException;

	public Historico deletar(String raDoAluno, Long id) throws ClassNotFoundException;

	public List<Historico> buscarTodosPorAluno(String raDoAluno) throws ClassNotFoundException;

}
