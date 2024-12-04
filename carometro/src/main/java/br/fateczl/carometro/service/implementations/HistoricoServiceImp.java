package br.fateczl.carometro.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fateczl.carometro.model.entities.Aluno;
import br.fateczl.carometro.model.entities.Historico;
import br.fateczl.carometro.persistence.IAlunoRepository;
import br.fateczl.carometro.persistence.IHistoricoRepository;
import br.fateczl.carometro.service.services.IHistoricoService;

@Service
public class HistoricoServiceImp implements IHistoricoService {

	@Autowired
	IHistoricoRepository repositoryHistorico;

	@Autowired
	IAlunoRepository repositoryAluno;

	@Override
	public Historico inserir(Historico historico) {
		return repositoryHistorico.save(historico);

	}

	@Override
	public Historico buscar(String ra, Long id) throws ClassNotFoundException {
		return repositoryHistorico.findByAlunoRaAndIdHistorico(ra, id)
				.orElseThrow(() -> new ClassNotFoundException("Histórico Inexistente"));
	}

	@Override
	public Historico atualizar(String ra, Long id, Historico historico) throws ClassNotFoundException {
		Historico historicoAtualizado = repositoryHistorico.findByAlunoRaAndIdHistorico(ra, id)
				.orElseThrow(() -> new ClassNotFoundException("Historico Inexistente"));
		historicoAtualizado.setAtividade(historico.getAtividade());
		historicoAtualizado.setEmpresa(historico.getEmpresa());
		historicoAtualizado.setTempoEmpresaEmAnos(historico.getTempoEmpresaEmAnos());
		return repositoryHistorico.save(historicoAtualizado);
	}

	@Override
	public Historico deletar(String ra, Long id) {
		Optional<Historico> validaHistorico = repositoryHistorico.findByAlunoRaAndIdHistorico(ra, id);
		if (validaHistorico.isPresent()) {
			repositoryHistorico.delete(validaHistorico.get());
			return validaHistorico.get();

		} else {
			throw new IllegalArgumentException("Aluno Inexistente no Banco de Dados");
		}

	}

	@Override
	public List<Historico> buscarTodosPorAluno(String ra) throws ClassNotFoundException {
		Aluno aluno = repositoryAluno.findById(ra).orElseThrow(() -> new ClassNotFoundException("Aluno Inexistente"));
		if(!aluno.getHistoricos().isEmpty()) {			
			return repositoryHistorico.findAll();
		}else {
			throw new ClassNotFoundException("Não existem históricos neste Aluno");
		}
		
	}

}