package br.fateczl.carometro.controller;
 
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.fateczl.carometro.model.entities.Aluno;
import br.fateczl.carometro.model.entities.Curso;
import br.fateczl.carometro.model.entities.Turma;
import br.fateczl.carometro.service.implementations.AlunoServiceImp;
import br.fateczl.carometro.service.implementations.CursoServiceImp;
import br.fateczl.carometro.service.implementations.TurmaServiceImp;
 
@Controller
public class AlunoHtmlController {

	@Autowired
	private AlunoServiceImp alunoService;

	@Autowired
	private TurmaServiceImp turmaService;

	@Autowired
	private CursoServiceImp cursoService;

	private ArrayList<String> links = new ArrayList<>();

	@GetMapping("/alunoGet")
	public String alunoGet(Model model) {
		Aluno aluno = new Aluno();
		model.addAttribute(aluno);
		return "alunoGet";
	}
	
	/*@GetMapping("/alunoGet")
	public String alunoPost(@RequestParam String ra, Model model){
		Aluno aluno = new Aluno();
		try {
			aluno = alunoService.buscar(ra);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
		model.addAttribute("aluno", aluno);
		return "aluno_consulta";
	}*/

	@GetMapping("/alunoPost")
	public String alunoPost(Model model) {
		Aluno aluno = new Aluno();
		model.addAttribute("aluno", aluno);
		model.addAttribute("links", links);
		try {
			java.util.List<Turma> listTurma = turmaService.buscarTodasAsTurmasExistentes();
			model.addAttribute("listTurma", listTurma);
			java.util.List<Curso> listCurso = cursoService.buscarTodos();
			model.addAttribute("listCurso", listCurso);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}

		return "alunoPost";
	}

	@PostMapping("/alunoPost")
	public String alunoPost(@ModelAttribute("aluno") @RequestParam String link1, @RequestParam String link2,
			@RequestParam String link3, Aluno aluno) {
		links.add(link1);
		links.add(link2);
		links.add(link3);
		aluno.setLinks(links);
		alunoService.inserir(aluno);
		return "aluno_inserido";
	}

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("message", "Isso é um Teste");
		return "home";

	}

}

