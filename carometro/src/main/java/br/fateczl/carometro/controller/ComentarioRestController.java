/*package br.fateczl.carometro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fateczl.carometro.model.entities.Aluno;
import br.fateczl.carometro.model.entities.Comentario;
import br.fateczl.carometro.service.services.IComentarioService;

@RestController
@RequestMapping("comentario")
public class ComentarioRestController {

	@Autowired
	IComentarioService comentarioService;

	@GetMapping
	public ResponseEntity<Iterable<Comentario>> buscarTodosOsComentariosDoAluno() {
		return ResponseEntity.ok(comentarioService.buscarTodos());
	}

	@GetMapping("/{raAluno}")
	public ResponseEntity<Comentario> buscarPorId(@PathVariable String raAluno) throws ClassNotFoundException {
		return ResponseEntity.ok(comentarioService.buscar(null));
	}

	@PostMapping
	public ResponseEntity<Comentario> inserirAluno(@RequestBody Comentario comentario) throws ClassNotFoundException {
		Comentario novoComentario = comentarioService.inserir(comentario);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoComentario);
	}

	@PutMapping("/{ra}")
	public ResponseEntity<Comentario> atualizarAluno(@PathVariable String ra, @RequestBody Comentario novosDados)
			throws ClassNotFoundException {
		Comentario comentarioAtualizado = comentarioService.atualizar(ra, novosDados);
		return ResponseEntity.ok(comentarioAtualizado);
	}

	@DeleteMapping("/{name}")
	public ResponseEntity<Comentario> deletarAluno(@PathVariable String RA) throws ClassNotFoundException {
		comentarioService.deletar(RA);
		return ResponseEntity.ok().build();
	}

}
*/