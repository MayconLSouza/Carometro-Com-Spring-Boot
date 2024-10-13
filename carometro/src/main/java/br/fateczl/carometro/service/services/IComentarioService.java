package br.fateczl.carometro.service.services;


import br.fateczl.carometro.model.entities.Comentario;


public interface IComentarioService {
	public Comentario inserir(Comentario comentario);
	public Comentario buscar(Long id) throws ClassNotFoundException;
	public Comentario atualizar(Long id, Comentario aluno) throws ClassNotFoundException;
	public void deletar(Long id);
	public Iterable<Comentario> buscarTodos();
}
