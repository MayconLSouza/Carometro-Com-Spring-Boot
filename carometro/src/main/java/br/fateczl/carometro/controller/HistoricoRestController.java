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

import br.fateczl.carometro.model.entities.Historico;
import br.fateczl.carometro.service.services.IHistoricoService;

@RestController
@RequestMapping("historico")
public class HistoricoRestController {

	@Autowired
	IHistoricoService historicoService;
	
	@GetMapping("/{raAluno}")
	public ResponseEntity<List<Historico>> buscarTodosOsHistoricosDoAluno(@PathVariable String raAluno)throws ClassNotFoundException {
		return ResponseEntity.ok(historicoService.buscarTodosPorAluno(raAluno));
	}

	@PostMapping
	public ResponseEntity<Historico> inserirAluno(@RequestBody Historico historico) throws ClassNotFoundException {
		
		Historico novoHistorico = historicoService.inserir(historico);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoHistorico);
	}

	@PutMapping("/{ra}/{id}")
	public ResponseEntity<Historico> atualizarAluno(@PathVariable String ra, @PathVariable Long id, @RequestBody Historico novosDados)throws ClassNotFoundException {
		Historico historicoAtualizado = historicoService.atualizar(ra, id, novosDados);
		return ResponseEntity.ok(historicoAtualizado);
	}

	@DeleteMapping("/{ra}/{id}")
	public ResponseEntity<Historico> deletarAluno(@PathVariable String ra, @PathVariable Long id) throws ClassNotFoundException {
		Historico historico = historicoService.deletar(ra, id); 
		return ResponseEntity.ok(historico);
	}
	
}
