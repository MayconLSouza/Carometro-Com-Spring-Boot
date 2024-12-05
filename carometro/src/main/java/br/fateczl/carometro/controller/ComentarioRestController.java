package br.fateczl.carometro.controller;

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

import br.fateczl.carometro.model.entities.Comentario;
import br.fateczl.carometro.model.enums.Enum_Tipos;
import br.fateczl.carometro.service.services.IComentarioService;

@RestController
@RequestMapping("comentario")
public class ComentarioRestController {

	@Autowired
	IComentarioService comentarioService;

	@GetMapping("/{raAluno}")
	public ResponseEntity<Iterable<Comentario>> buscarTodosOsComentariosDoAluno(@PathVariable String raAluno)
			throws ClassNotFoundException {
		return ResponseEntity.ok(comentarioService.buscarTodosPorAluno(raAluno));
	}

	@PostMapping
	public ResponseEntity<Comentario> inserirAluno(@RequestBody Comentario comentario) throws ClassNotFoundException {
		
		Comentario novoComentario = comentarioService.inserir(comentario);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoComentario);
	}

	@PutMapping("/{ra}/{tipo}")
	public ResponseEntity<Comentario> atualizarAluno(@PathVariable String ra, @PathVariable String tipo, @RequestBody Comentario novosDados)throws ClassNotFoundException {
		Comentario comentarioAtualizado = comentarioService.atualizar(ra, Enum_Tipos.valueOf(tipo), novosDados);
		return ResponseEntity.ok(comentarioAtualizado);
	}

	@DeleteMapping("/{ra}/{tipo}")
	public ResponseEntity<Comentario> deletarAluno(@PathVariable String ra, @PathVariable String tipo) throws ClassNotFoundException {
		Comentario comentario = comentarioService.deletar(ra, Enum_Tipos.valueOf(tipo));
		return ResponseEntity.ok(comentario);
	}

}
