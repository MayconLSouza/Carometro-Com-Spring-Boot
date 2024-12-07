package br.fateczl.carometro.controller;
 
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< Updated upstream
=======
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
>>>>>>> Stashed changes
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
	
	private java.util.List<Aluno> alunos = new ArrayList<>();

	
	//GET COMMANDS
	@GetMapping("/alunoGet")
	public String consultarAluno(Model model) {
		Aluno aluno = new Aluno();
		model.addAttribute(aluno);
		return "alunoGet";
	}
	
	@GetMapping("/aluno_consulta")
	public String consultarAlunoPorRa(@RequestParam String ra, Model model){
		Aluno aluno = new Aluno();
		try {
			aluno = alunoService.buscar(ra);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
		model.addAttribute("aluno", aluno);
		return "aluno_consulta";
	}

	//POST COMMANDS
	@GetMapping("/alunoPost")
	public String inserirAluno(Model model) {
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
	public String inserirAluno(@ModelAttribute("aluno") @RequestParam String link1, @RequestParam String link2,
			@RequestParam String link3, Aluno aluno) {
		links.add(link1);
		links.add(link2);
		links.add(link3);
		aluno.setLinks(links);
		alunoService.inserir(aluno);
		links.clear();
		return "aluno_inserido";
	}

	//DELETE COMMANDS
	@GetMapping("/alunoDelete")
	public String deletarAluno(Model model) {
		Aluno aluno = new Aluno();
		model.addAttribute(aluno);
		return "alunoDelete";
	}
	
	@PostMapping("/alunoDelete")
	public String deletarAlunoPorRa(@RequestParam String ra, Model model){
		Aluno aluno = new Aluno();
		aluno = alunoService.deletar(ra);
		model.addAttribute("message","Deletado");
		return "alunoDelete";
	}
	
	//LIST ALL
	@GetMapping("/alunoList")
	public String listarTodosOsAluno(Model model){
		Aluno aluno = new Aluno();
		try {
			alunos = alunoService.buscarTodos();
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
		model.addAttribute("alunos",alunos);
		model.addAttribute("links", links);
		return "alunoList";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("message", "Isso é um Teste");
		return "home";

	}

}

