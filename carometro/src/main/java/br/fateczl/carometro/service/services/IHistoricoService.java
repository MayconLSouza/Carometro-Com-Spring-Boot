package br.fateczl.carometro.service.services;
 
import br.fateczl.carometro.model.entities.Historico;
 
public interface IHistoricoService {
	public Historico inserir(Historico historico);
	public Historico buscar(Long id) throws ClassNotFoundException;
	public Historico atualizar(Long id, Historico aluno) throws ClassNotFoundException;
	public void deletar(Long id);
	public Iterable<Historico> buscarTodos();
}
 