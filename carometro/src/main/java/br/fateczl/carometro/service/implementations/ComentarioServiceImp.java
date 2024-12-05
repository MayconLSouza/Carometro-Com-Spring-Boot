package br.fateczl.carometro.service.implementations;
 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fateczl.carometro.model.entities.Aluno;
import br.fateczl.carometro.model.entities.Comentario;
import br.fateczl.carometro.model.enums.Enum_Tipos;
import br.fateczl.carometro.persistence.IAlunoRepository;
import br.fateczl.carometro.persistence.IComentarioRepository;
import br.fateczl.carometro.service.services.IComentarioService;
 
@Service
public class ComentarioServiceImp implements IComentarioService {
 
	@Autowired
	IComentarioRepository repositoryComentario;
	
	@Autowired
	IAlunoRepository repositoryAluno;
	
	@Override
	public Comentario inserir(Comentario comentario) {
		return repositoryComentario.save(comentario);
	}
 
	@Override
	public Comentario buscar(String ra, Enum_Tipos tipo) throws ClassNotFoundException {
		 return repositoryComentario.findByAlunoRaAndTipo(ra, tipo).orElseThrow(() -> new ClassNotFoundException("Comentário Inexistente"));
	}

	@Override
	public Comentario atualizar(String ra, Enum_Tipos tipo, Comentario comentario) throws ClassNotFoundException {
		Comentario comentarioAtualizado = repositoryComentario.findByAlunoRaAndTipo(ra, tipo).orElseThrow(()-> new ClassNotFoundException("Comentario Inexistente"));
		Aluno aluno = repositoryAluno.findById(ra).orElseThrow(() -> new ClassNotFoundException("Aluno Inexistente"));
		comentarioAtualizado.setAluno(aluno);
		comentarioAtualizado.setData(comentario.getData());
		comentarioAtualizado.setDescricao(comentario.getDescricao());
		comentarioAtualizado.setTipo(comentario.getTipo());
		
		return repositoryComentario.save(comentarioAtualizado);
	}
 
	@Override
	public Comentario deletar(String ra, Enum_Tipos tipo) {
		Optional<Comentario> validaComentario = repositoryComentario.findByAlunoRaAndTipo(ra, tipo);
        if (validaComentario.isPresent()) {
            repositoryComentario.delete(validaComentario.get());
            return validaComentario.get();
        }else{
            throw new IllegalArgumentException("Aluno Inexistente no Banco de Dados");
        }
		
	}
 
	@Override
	public List<Comentario> buscarTodosPorAluno(String RaDoAluno) throws ClassNotFoundException{
		Aluno aluno = repositoryAluno.findById(RaDoAluno).orElseThrow(() -> new ClassNotFoundException("Aluno Inexistente"));
		if(!aluno.getComentarios().isEmpty()) {
			return aluno.getComentarios();
			
		}else {
			throw new ClassNotFoundException("Não existem comentários neste Aluno");
		}
	}


}