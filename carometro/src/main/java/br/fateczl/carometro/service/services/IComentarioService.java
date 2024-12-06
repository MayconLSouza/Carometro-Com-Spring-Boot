package br.fateczl.carometro.service.services;

import java.util.List;

import br.fateczl.carometro.model.entities.Comentario;
import br.fateczl.carometro.model.enums.Enum_Tipos;

public interface IComentarioService {
	
	public Comentario inserir(Comentario comentario) throws ClassNotFoundException;

	public Comentario buscar(String raDoAluno, Enum_Tipos tipo) throws ClassNotFoundException;

	public Comentario atualizar(String raDoAluno, Enum_Tipos tipo, Comentario comentarioAtualizado) throws ClassNotFoundException;

	public Comentario deletar(String raDoAluno, Enum_Tipos tipo) throws ClassNotFoundException;

	public List<Comentario> buscarTodosPorAluno(String raDoAluno) throws ClassNotFoundException;
}