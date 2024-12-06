package br.fateczl.carometro.controller;

import java.util.List;

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

import br.fateczl.carometro.model.entities.Turma;
import br.fateczl.carometro.service.services.ITurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaRestController {

	@Autowired
	ITurmaService turmaService;

	@GetMapping()
	public ResponseEntity<List<Turma>> buscarTodasAsTurmas() throws ClassNotFoundException {
		return ResponseEntity.ok(turmaService.buscarTodasAsTurmasExistentes());
	}

	@GetMapping("/{codigoCurso}/{ano}/{semestre}")
	public ResponseEntity<Turma> buscarTurma(@PathVariable String codigoCurso, @PathVariable int ano, @PathVariable int semestre) throws ClassNotFoundException {
		return ResponseEntity.ok(turmaService.buscar(codigoCurso, ano, semestre));
	}

	@PostMapping
	public ResponseEntity<Turma> inserirTurma(@RequestBody Turma turma) throws ClassNotFoundException {
		Turma novaTurma = turmaService.inserir(turma);
		return ResponseEntity.status(HttpStatus.CREATED).body(novaTurma);
	}

	@PutMapping("/{codigoCurso}/{ano}/{semestre}")
	public ResponseEntity<Turma> atualizarTurma(@PathVariable String codigoCurso, @PathVariable Integer ano, @PathVariable Integer semestre, @RequestBody Turma novosDados) throws ClassNotFoundException {
		Turma turmaAtualizada = turmaService.atualizar(codigoCurso, ano, semestre, novosDados);
		return ResponseEntity.ok(turmaAtualizada);
	}

	@DeleteMapping("/{codigoCurso}/{ano}/{semestre}")
	public ResponseEntity<Turma> deletarTurma(@PathVariable String codigoCurso, @PathVariable Integer ano, @PathVariable Integer semestre) throws ClassNotFoundException {
		Turma turma = turmaService.deletar(codigoCurso, ano, semestre);
		return ResponseEntity.ok(turma);
	}

}
