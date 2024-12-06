package br.fateczl.carometro.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fateczl.carometro.model.entities.Aluno;
import br.fateczl.carometro.persistence.IAlunoRepository;
import br.fateczl.carometro.service.services.IAlunoService;

@Service
public class AlunoServiceImp implements IAlunoService {

    @Autowired
    IAlunoRepository repository;

    @Override
    public Aluno inserir(Aluno aluno) {
        Optional<Aluno> validaAluno = repository.findById(aluno.getRa());
        if (validaAluno.isPresent()) {
            throw new IllegalArgumentException("Aluno Já Presente no Banco de Dados");
        }else{
            return repository.save(aluno);
        }
    }

    @Override
    public Aluno buscar(String ra) throws ClassNotFoundException {
        return repository.findById(ra).orElseThrow(() -> new ClassNotFoundException("Aluno Inexistente"));
    }

    @Override
    public Aluno atualizar(String ra, Aluno aluno) throws ClassNotFoundException {
        Aluno alunoAtualizado = repository.findById(ra).orElseThrow(() -> new ClassNotFoundException("Aluno Inexistente"));
        alunoAtualizado.setNome(aluno.getNome());
        /*alunoAtualizado.setCurso(aluno.getCurso());*/
        alunoAtualizado.setSemestreConclusao(aluno.getSemestreConclusao());
        //TODO: Acrescentar o Atributo imagem após inserí-lo na classe Aluno
        alunoAtualizado.setLinks(aluno.getLinks());

        return repository.save(alunoAtualizado);
    }

    @Override
    public Aluno deletar(String RA) {
        Optional<Aluno> validaAluno = repository.findById(RA);
        if (validaAluno.isPresent()) {
            repository.deleteById(RA);
            return validaAluno.get();
        }else{
            throw new IllegalArgumentException("Aluno Inexistente no Banco de Dados");
        }
    }

    @Override
    public List<Aluno> buscarTodos() {
        return repository.findAll();
    }
}
