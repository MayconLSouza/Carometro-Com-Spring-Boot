package br.fateczl.carometro.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fateczl.carometro.model.entities.Curso;
import br.fateczl.carometro.persistence.ICursoRepository;
import br.fateczl.carometro.service.services.ICursoService;

@Service
public class CursoServiceImp implements ICursoService {
	
	@Autowired
	ICursoRepository repository;

	@Override
	public Curso inserir(Curso curso) {
		Optional<Curso> validaCurso = repository.findByCodigo(curso.getCodigo());
		if (validaCurso.isPresent()) {
			throw new IllegalArgumentException("Curso já presente no Banco de Dados");
		} else {
			return repository.save(curso);
		}
	}

	@Override
	public Curso buscar(String codigo) throws ClassNotFoundException {
		return repository.findByCodigo(codigo).orElseThrow(() -> new ClassNotFoundException("Curso Inexistente"));
	}

	@Override
	public Curso atualizar(String codigo, Curso curso) throws ClassNotFoundException {
		Curso cursoAtualizado = repository.findByCodigo(codigo).orElseThrow(() -> new ClassNotFoundException("Curso Inexistente"));
		cursoAtualizado.setNome(curso.getNome());
		cursoAtualizado.setCoordenador(curso.getCoordenador());
		cursoAtualizado.setAtivo(curso.isAtivo());
		cursoAtualizado.setTurmas(curso.getTurmas());
		return repository.save(cursoAtualizado);
	}

	@Override
	public Curso deletar(String codigo) {
		Optional<Curso> validaCurso = repository.findByCodigo(codigo);
		if(validaCurso.isPresent()) {
			repository.deleteById(codigo);
			return validaCurso.get();
		} else {
			throw new IllegalArgumentException("Curso Inexistente no Banco de Dados");
		}
	}

	@Override
	public List<Curso> buscarTodos() throws ClassNotFoundException {
		List<Curso> cursos = repository.findAll();
		if(!cursos.isEmpty()) {
			return cursos;
		} else {
			throw new ClassNotFoundException("Não existem Cursos");
		}
	}

}
