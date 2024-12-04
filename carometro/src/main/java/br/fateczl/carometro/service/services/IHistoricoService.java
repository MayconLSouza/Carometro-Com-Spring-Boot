package br.fateczl.carometro.service.services;

import java.util.List;

import br.fateczl.carometro.model.entities.Historico;

public interface IHistoricoService {

	Historico inserir(Historico historico);

	Historico buscar(String raDoAluno, Long id) throws ClassNotFoundException;

	Historico atualizar(String raDoAluno, Long id, Historico aluno) throws ClassNotFoundException;

	Historico deletar(String raDoAluno, Long id) throws ClassNotFoundException;

	List<Historico> buscarTodosPorAluno(String raDoAluno) throws ClassNotFoundException;

}
