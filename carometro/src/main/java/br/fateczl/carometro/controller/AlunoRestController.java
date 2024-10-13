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

import br.fateczl.carometro.model.entities.Aluno;
import br.fateczl.carometro.service.implementations.AlunoServiceImp;

@RestController
@RequestMapping("/alunos")
public class AlunoRestController {

	@Autowired
	private AlunoServiceImp alunoService;

	/*
	 * @Autowired private HistoricoServiceImp historicoService;
	 * 
	 * @Autowired private ComentarioServiceImp comentarioService;
	 */

	@GetMapping
	public ResponseEntity<Iterable<Aluno>> buscarTodosOsAlunos() {
		return ResponseEntity.ok(alunoService.buscarTodos());
	}

	@GetMapping("/{ra}")
	public ResponseEntity<Aluno> buscarPorId(@PathVariable String ra) throws ClassNotFoundException {
		return ResponseEntity.ok(alunoService.buscar(ra));
	}

	@PostMapping
	public ResponseEntity<Aluno> inserirAluno(@RequestBody Aluno aluno) throws ClassNotFoundException {

		Aluno novoAluno = alunoService.inserir(aluno);
		/*
		 * 
		 * if (aluno.getComentarios() != null) { for (String comentario :
		 * aluno.getComentarios().keySet()) {
		 * System.err.println(aluno.getComentarios().get(comentario));
		 * 
		 * 
		 * comentarioService.inserir(aluno.getComentarios().get(comentario)); } }
		 * 
		 * // Inserir históricos, se existirem if (aluno.getHistorico() != null) {
		 * 
		 * historicoService.inserir(aluno.getHistorico());
		 * 
		 * }
		 */

		return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);

	}

	@PutMapping("/{ra}")
	public ResponseEntity<Aluno> atualizarAluno(@PathVariable String ra, @RequestBody Aluno novosDados)
			throws ClassNotFoundException {
		Aluno alunoAtualizado = alunoService.atualizar(ra, novosDados);
		return ResponseEntity.ok(alunoAtualizado);
	}

	@DeleteMapping("/{name}")
	public ResponseEntity<Aluno> deletarAluno(@PathVariable String name) throws ClassNotFoundException {
		alunoService.deletar(name);
		return ResponseEntity.ok().build();
	}

}
