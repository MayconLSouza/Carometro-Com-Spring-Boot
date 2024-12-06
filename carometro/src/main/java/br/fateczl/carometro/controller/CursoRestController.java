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

import br.fateczl.carometro.model.entities.Curso;
import br.fateczl.carometro.service.services.ICursoService;

@RestController
@RequestMapping("/curso")
public class CursoRestController {

	@Autowired
	ICursoService cursoService;
	
	@GetMapping
	public ResponseEntity<Iterable<Curso>> buscarTodosOsCursos() throws ClassNotFoundException {
		return ResponseEntity.ok(cursoService.buscarTodos());
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Curso> buscarPorId(@PathVariable String codigo) throws ClassNotFoundException {
		return ResponseEntity.ok(cursoService.buscar(codigo));
	}
	
	@PostMapping
	public ResponseEntity<Curso> inserirCurso(@RequestBody Curso curso) throws ClassNotFoundException {
		Curso novoCurso = cursoService.inserir(curso);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoCurso);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Curso> atualizarCurso(@PathVariable String codigo, @RequestBody Curso novosDados) throws ClassNotFoundException {
		Curso cursoAtualizado = cursoService.atualizar(codigo, novosDados);
		return ResponseEntity.ok(cursoAtualizado);
	}
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Curso> deletarCurso(@PathVariable String codigo) throws ClassNotFoundException {
		Curso cursoDeletado = cursoService.deletar(codigo);
		return ResponseEntity.ok(cursoDeletado);
	}
	
}
