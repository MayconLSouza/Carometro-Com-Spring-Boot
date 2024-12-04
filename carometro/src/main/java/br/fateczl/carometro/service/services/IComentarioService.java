package br.fateczl.carometro.service.services;

import java.util.List;

import br.fateczl.carometro.model.entities.Comentario;

public interface IComentarioService {
	
	Comentario inserir(Comentario comentario) throws ClassNotFoundException;

	Comentario buscar(String raDoAluno, String tipo) throws ClassNotFoundException;

	Comentario atualizar(String raDoAluno, String tipo, Comentario comentarioAtualizado) throws ClassNotFoundException;

	Comentario deletar(String raDoAluno, String tipo) throws ClassNotFoundException;

	List<Comentario> buscarTodosPorAluno(String raDoAluno) throws ClassNotFoundException;
}