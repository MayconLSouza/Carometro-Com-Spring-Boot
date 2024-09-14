package br.fateczl.carometro.service.services;

import br.fateczl.carometro.model.entities.Aluno;

public interface IAlunoService {
    public Aluno inserir(Aluno aluno);
    public Aluno buscar(String RA) throws ClassNotFoundException;
    public Aluno atualizar(String ra, Aluno aluno) throws ClassNotFoundException;
    public void deletar(String RA);
    public Iterable<Aluno> buscarTodos();
}
