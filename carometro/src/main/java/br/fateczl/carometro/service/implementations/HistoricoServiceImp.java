package br.fateczl.carometro.service.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fateczl.carometro.model.entities.Historico;
import br.fateczl.carometro.persistence.IHistoricoRepository;
import br.fateczl.carometro.service.services.IHistoricoService;

@Service
public class HistoricoServiceImp implements IHistoricoService {

	@Autowired
	IHistoricoRepository repository;

	@Override
	public Historico inserir(Historico historico) {

		return repository.save(historico);

	}

	@Override
	public Historico buscar(Long id) throws ClassNotFoundException {
		return repository.findById(id).orElseThrow(ClassNotFoundException::new);
	}

	@Override
	public Historico atualizar(Long id, Historico historico) throws ClassNotFoundException {
		Historico historicoAtualizado = repository.findById(id)
				.orElseThrow(() -> new ClassNotFoundException("Historico Inexistente"));
		historicoAtualizado.setAtividade(historico.getAtividade());
		historicoAtualizado.setEmpresa(historico.getEmpresa());
		historicoAtualizado.setTempoEmpresa(historico.getTempoEmpresa());
		return repository.save(historicoAtualizado);
	}

	@Override
	public void deletar(Long id) {
		Optional<Historico> validaHistorico = repository.findById(id);
		if (validaHistorico.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new IllegalArgumentException("Aluno Inexistente no Banco de Dados");
		}

	}

	@Override
	public Iterable<Historico> buscarTodos() {
		return repository.findAll();
	}

}