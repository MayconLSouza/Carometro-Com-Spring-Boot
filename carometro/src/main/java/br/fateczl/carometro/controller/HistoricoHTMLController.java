package br.fateczl.carometro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.fateczl.carometro.model.entities.Aluno;
import br.fateczl.carometro.model.entities.Curso;
import br.fateczl.carometro.model.entities.Historico;
import br.fateczl.carometro.model.entities.Turma;
import br.fateczl.carometro.model.primarykeysclass.HistoricoId;
import br.fateczl.carometro.service.implementations.AlunoServiceImp;
import br.fateczl.carometro.service.implementations.HistoricoServiceImp;

@Controller
public class HistoricoHTMLController {

	@Autowired
	private HistoricoServiceImp historicoService;
	
	@Autowired
	private AlunoServiceImp alunoService;
	
	// GET COMMANDS
		@GetMapping("/historicoGet")
		public String consultarHistorico(Model model) {
			Historico historico = new Historico();
			model.addAttribute(historico);
			return "historicoGet";
		}

		@GetMapping("/historicoConsulta")
		public String consultarHistoricoPorRaeId(@RequestParam String ra, @RequestParam String Id, Model model) {
			Historico historico = new Historico();
			try {
				historico = historicoService.buscar(ra, Long.parseLong(Id));
			}catch (Exception e) {
				System.err.println(e.getMessage());
			}
			model.addAttribute("historico", historico);
			return "historico_consulta";
		}
		
		// POST COMMANDS
		@GetMapping("/historicoPost")
		public String inserirHistorico(Model model) {
			Historico historico = new Historico();
			model.addAttribute("historico", historico);
			
			
			
			return "historicoPost";
		}

		@PostMapping("/historicoPost")
		public String inserirAluno(@ModelAttribute Historico historico/*, @RequestParam String ra, @RequestParam Long idHistorico*/) {
			/*HistoricoId historicoId = new HistoricoId();
			historicoId.setAlunoRa(ra);
			historicoId.setIdHistorico(idHistorico);*/
			try {
				historico.setAluno(alunoService.buscar(historico.toRa()));
			} catch (ClassNotFoundException e) {
				System.err.println(e.getMessage());
			}
			historicoService.inserir(historico);
			return "historico_inserido";
		}
		
		@GetMapping("/historicoHome")
		public String alunoHome(Model model) {
			model.addAttribute("message", "Isso é um Teste");
			return "historicoHome";

		}

}
