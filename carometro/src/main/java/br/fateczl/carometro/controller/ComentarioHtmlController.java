package br.fateczl.carometro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.fateczl.carometro.model.entities.Comentario;
import br.fateczl.carometro.model.enums.Enum_Tipos;
import br.fateczl.carometro.service.services.IComentarioService;

@Controller
public class ComentarioHtmlController {

	@Autowired
	IComentarioService serviceComentario;

	// HOME
	@GetMapping("/comentario_home")
	public String comentarioHome() {
		return "comentario_home";
	}

// GET
	@GetMapping("/comentarioShowGet")
	public String comentarioShowGet(Model model) throws ClassNotFoundException {
		model.addAttribute(new Comentario());
		return "comentarioShowGet";
	}

	@GetMapping("/comentarioGet")
	public String buscarComentariosPorRa(@RequestParam("ra") String ra, Model model) throws ClassNotFoundException {
		List<Comentario> comentarios = serviceComentario.buscarTodosPorAluno(ra);
		model.addAttribute("comentarios", comentarios);

		return "comentarioGet";
	}

	// DELETE - Formulário
	@GetMapping("/comentarioDelete")
	public String comentarioDeleteForm(Model model) throws ClassNotFoundException {
		model.addAttribute("tipos", Enum_Tipos.values());
		return "comentarioDelete";
	}

	// DELETE - Processamento
	@PostMapping("/comentarioDelete")
	public String comentarioDelete(@RequestParam("ra") String ra, @RequestParam("tipo") Enum_Tipos tipo, Model model)
			throws ClassNotFoundException {
		serviceComentario.deletar(ra, tipo);
		return "redirect:/comentario_home"; // Redireciona para a página inicial após deletar
	}
}
