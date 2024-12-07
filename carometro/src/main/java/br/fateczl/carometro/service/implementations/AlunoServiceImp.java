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
        if(!aluno.getNome().isBlank()) {
        	alunoAtualizado.setNome(aluno.getNome());
        }
        try {
        	if(!aluno.getCurso().getCodigo().isBlank()) {
                alunoAtualizado.setCurso(aluno.getCurso());
            }
        }catch (Exception e) {
			aluno.setCurso(alunoAtualizado.getCurso());// TODO: handle exception
		}
        try {
        	if(!aluno.getSemestreConclusao().toString().isBlank()) {
                alunoAtualizado.setSemestreConclusao(aluno.getSemestreConclusao());
            }
        }catch (Exception e) {
			aluno.setSemestreConclusao(alunoAtualizado.getSemestreConclusao());// TODO: handle exception
		}
        //TODO: Acrescentar o Atributo imagem após inserí-lo na classe Aluno
        if(!aluno.getLinks().isEmpty()) {
            alunoAtualizado.setLinks(aluno.getLinks());
        }

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
    public List<Aluno> buscarTodos() throws ClassNotFoundException {
    	List<Aluno> alunos = repository.findAll();
    	if(!alunos.isEmpty()) {
    		return alunos;
    	} else {
    		throw new ClassNotFoundException("Não existem Alunos");
    	}
    }
}
