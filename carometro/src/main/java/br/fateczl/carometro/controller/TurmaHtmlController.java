package br.fateczl.carometro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.fateczl.carometro.model.entities.Curso;
import br.fateczl.carometro.model.entities.Turma;
import br.fateczl.carometro.model.enums.Enum_TurnosCursos;
import br.fateczl.carometro.model.primarykeysclass.TurmaId;
import br.fateczl.carometro.service.implementations.AlunoServiceImp;
import br.fateczl.carometro.service.implementations.CursoServiceImp;
import br.fateczl.carometro.service.implementations.TurmaServiceImp;

@Controller
public class TurmaHtmlController {

	@Autowired
	private TurmaServiceImp turmaService;

	@Autowired
	private CursoServiceImp cursoService;

	@Autowired
	private AlunoServiceImp alunoService;

	@GetMapping("/turmaHome")
	public String home() {
		return "turmaHome";
	}

	@GetMapping("/turmaPost")
	public String turmaPost(Model model) throws ClassNotFoundException {
		TurmaId turmaId = new TurmaId();
		model.addAttribute("turmaId", turmaId);

		List<Curso> cursos = cursoService.buscarTodos(); 
	    model.addAttribute("cursos", cursos);
	    
	    model.addAttribute("turnos", Enum_TurnosCursos.values());

		return "turmaPost";
	}

	@PostMapping("/turmaPost")
	public String turmaPost(@ModelAttribute("turmaId") TurmaId turmaId) throws ClassNotFoundException {
//		System.out.println("Codigo curso: " + turmaId.getCodigoCurso());
		System.out.println(turmaId.toString());
		Curso curso = cursoService.buscar(turmaId.getCodigoCurso());
		Turma turma = new Turma();
		turma.setTurmaId(turmaId);
		turma.setCurso(curso);
		turmaService.inserir(turma);
		return "turma_inserida";
	}

}
