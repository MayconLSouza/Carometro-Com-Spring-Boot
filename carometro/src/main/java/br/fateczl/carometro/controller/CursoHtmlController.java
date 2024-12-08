package br.fateczl.carometro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.fateczl.carometro.model.entities.Curso;
import br.fateczl.carometro.service.services.ICursoService;

@Controller
public class CursoHtmlController {

	@Autowired
	ICursoService cursoService;

	@GetMapping("/curso_home")
	public String cursoHome() {
		return "curso_home";
	}

	@PostMapping("/cursoPost")
	public String cursoPost(@ModelAttribute("curso") Curso curso, Model model) {
		cursoService.inserir(curso);
		model.addAttribute("curso", curso);
		return "cursoInserido";
	}

	@GetMapping("/cursoPost")
	public String cursoPost(Model model) {
		model.addAttribute("curso", new Curso());
		return "cursoPost";
	}

	// **GET**: Lista todos os cursos
	@GetMapping("/cursoGet")
	public String cursoGet(Model model) throws ClassNotFoundException {
		List<Curso> cursos = cursoService.buscarTodos();
		model.addAttribute("cursos", cursos);
		return "cursoGet";
	}

	// **PUT**: Atualiza um curso existente
	@GetMapping("/cursoPut")
	public String cursoPut(Model model) {
		model.addAttribute("curso", new Curso());
		return "cursoPut";
	}

	@PostMapping("/cursoPut")
	public String cursoPut(@RequestParam("codigo") String codigo, @ModelAttribute("curso") Curso curso, Model model) {
		try {
			cursoService.atualizar(codigo, curso);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return "redirect:/cursoGet?error=CursoNaoEncontrado";
		}
		model.addAttribute("curso", curso);
		return "cursoAtualizado";
	}

	// **DELETE**: Remove um curso pelo codigo
	@GetMapping("/cursoDelete")
	public String cursoDeleteForm(Model model) {
		model.addAttribute("curso", new Curso()); // Inicializa o formulário
		return "cursoDelete";
	}

	@PostMapping("/cursoDelete")
	public String cursoDelete(@RequestParam("codigo") String codigo, Model model) {
		cursoService.deletar(codigo);
		model.addAttribute("message", "Deletado");
		return "cursoDelete";
	}
}