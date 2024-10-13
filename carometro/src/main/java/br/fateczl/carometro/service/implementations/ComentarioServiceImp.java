package br.fateczl.carometro.service.implementations;
 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fateczl.carometro.model.entities.Comentario;
import br.fateczl.carometro.persistence.IComentarioRepository;
import br.fateczl.carometro.service.services.IComentarioService;
 
@Service
public class ComentarioServiceImp implements IComentarioService {
 
	@Autowired
	IComentarioRepository repository;
	
	@Override
	public Comentario inserir(Comentario comentario) {
            return repository.save(comentario);
	}
 
	@Override
	public Comentario buscar(Long id) throws ClassNotFoundException {
		 return repository.findById(id).orElseThrow(ClassNotFoundException::new);
	}

	@Override
	public Comentario atualizar(Long id, Comentario comentario) throws ClassNotFoundException {
		Comentario comentarioAtualizado = repository.findById(id).orElseThrow(()-> new ClassNotFoundException("Comentario Inexistente"));
		comentarioAtualizado.setData(comentario.getData());
		comentarioAtualizado.setDescricao(comentario.getDescricao());
		comentarioAtualizado.setTipo(comentario.getTipo());
		
		return repository.save(comentarioAtualizado);
	}
 
	@Override
	public void deletar(Long id) {
		Optional<Comentario> validaComentario = repository.findById(id);
        if (validaComentario.isPresent()) {
            repository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Aluno Inexistente no Banco de Dados");
        }
		
	}
 
	@Override
	public Iterable<Comentario> buscarTodos() {
		return repository.findAll();
	}

}