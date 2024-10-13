package br.fateczl.carometro.service.implementations;

import br.fateczl.carometro.model.entities.Aluno;
import br.fateczl.carometro.persistence.IAlunoRepository;
import br.fateczl.carometro.service.services.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunoServiceImp implements IAlunoService {

    @Autowired
    IAlunoRepository repository;

    @Override
    public Aluno inserir(Aluno aluno) {
    	System.err.println("reposytory");
        Optional<Aluno> validaAluno = repository.findById(aluno.getRa());
        if (validaAluno.isPresent()) {
            throw new IllegalArgumentException("Aluno Já Presente no Banco de Dados");
        }else{
 
            return repository.save(aluno);
        }
    }

    @Override
    public Aluno buscar(String RA) throws ClassNotFoundException {
        return repository.findById(RA).orElseThrow(ClassNotFoundException::new);
    }

    @Override
    public Aluno atualizar(String ra, Aluno aluno) throws ClassNotFoundException {
        Aluno alunoAtualizado = repository.findById(ra).orElseThrow(() -> new ClassNotFoundException("Aluno Inexistente"));
        alunoAtualizado.setNome(aluno.getNome());
        alunoAtualizado.setCurso(aluno.getCurso());
        alunoAtualizado.setFoto(aluno.getFoto());
        alunoAtualizado.setHistorico(aluno.getHistorico());
        alunoAtualizado.setSemestreConclusao(aluno.getSemestreConclusao());
        alunoAtualizado.setComentarios(aluno.getComentarios());
        alunoAtualizado.setLinks(aluno.getLinks());

        return repository.save(alunoAtualizado);
    }

    @Override
    public void deletar(String RA) {
        Optional<Aluno> validaAluno = repository.findById(RA);
        if (validaAluno.isPresent()) {
            repository.deleteById(RA);
        }else{
            throw new IllegalArgumentException("Aluno Inexistente no Banco de Dados");
        }
    }

    @Override
    public Iterable<Aluno> buscarTodos() {
        return repository.findAll();
    }
}
