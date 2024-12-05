package br.fateczl.carometro.service.services;

import java.util.List;

import br.fateczl.carometro.model.entities.Comentario;
import br.fateczl.carometro.model.enums.Enum_Tipos;

public interface IComentarioService {
	
	Comentario inserir(Comentario comentario) throws ClassNotFoundException;

	Comentario buscar(String raDoAluno, Enum_Tipos tipo) throws ClassNotFoundException;

	Comentario atualizar(String raDoAluno, Enum_Tipos tipo, Comentario comentarioAtualizado) throws ClassNotFoundException;

	Comentario deletar(String raDoAluno, Enum_Tipos tipo) throws ClassNotFoundException;

	List<Comentario> buscarTodosPorAluno(String raDoAluno) throws ClassNotFoundException;
}