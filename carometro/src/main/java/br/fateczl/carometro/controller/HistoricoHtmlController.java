package br.fateczl.carometro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.fateczl.carometro.model.entities.Historico;
import br.fateczl.carometro.service.implementations.AlunoServiceImp;
import br.fateczl.carometro.service.implementations.HistoricoServiceImp;

@Controller
@RequestMapping("/historico")
public class HistoricoHtmlController {

	@Autowired
	private HistoricoServiceImp historicoService;

	@Autowired
	private AlunoServiceImp alunoService;

	// HOME
	@GetMapping("/historicoHome")
	public String alunoHome(Model model) {
		model.addAttribute("message", "Isso é um Teste");
		return "historico/historicoHome";

	}

	// POST COMMANDS
	@GetMapping("/historicoPost")
	public String inserirHistorico(Model model) {
		Historico historico = new Historico();
		model.addAttribute("historico", historico);

		return "historico/historicoPost";
	}

	@PostMapping("/historicoPost")
	public String inserirAluno(@ModelAttribute Historico historico) {
		try {
			historico.setAluno(alunoService.buscar(historico.toRa()));
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
		historicoService.inserir(historico);
		return "historico/historico_inserido";
	}

	// DELETE
	@GetMapping("/historicoDelete")
	public String historicoDelete(Model model) {
		Historico historico = new Historico();
		model.addAttribute("historico", historico);
		return "historico/historicoDelete";
	}

	@PostMapping("/historicoDelete")
	public String historicoDelete(@ModelAttribute Historico historico, Model model) throws ClassNotFoundException {
		historicoService.deletar(historico.getHistoricoId().getAlunoRa(), historico.getHistoricoId().getIdHistorico());
		model.addAttribute("model", model);
		model.addAttribute("historico", historico);
		return "historico/historico_deletado";
	}

	// LIST COMMANDS
	@GetMapping("/historicoList")
	public String consultarHistorico(Model model) {
		Historico historico = new Historico();
		model.addAttribute(historico);
		return "historico/historicoList";
	}

	@GetMapping("/historico_consulta")
	public String consultarHistoricoPorRaeId(@RequestParam String ra, Model model) {
		List<Historico> historicos = new ArrayList<>();
		try {
			historicos = historicoService.buscarTodosPorAluno(ra);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		model.addAttribute("historicos", historicos);
		return "historico/historico_consulta";
	}

	// PUT COMMANDS
	@GetMapping("/historicoPut")
	public String atualizarHistorico(Model model) {
		Historico historico = new Historico();
		model.addAttribute("historico", historico);

		return "historico/historicoPut";
	}
	
	@PostMapping("/historico_atualizado")
	public String historicoAtualizado(@ModelAttribute Historico historico) throws ClassNotFoundException {
		try {
			historico.setAluno(alunoService.buscar(historico.toRa()));
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
		historicoService.atualizar(historico.getHistoricoId().getAlunoRa(), historico.getHistoricoId().getIdHistorico(), historico);
		return "historico/historico_atualizado";
	}

}
