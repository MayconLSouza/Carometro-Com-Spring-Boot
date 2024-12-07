package br.fateczl.carometro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import br.fateczl.carometro.service.services.IComentarioService;

@Controller
public class ComentarioHtmlController {

	@Autowired
	IComentarioService serviceComentario;

	@GetMapping("/comentario_home")
	public String comentarioHome() {
		return "comentario_home";
	}

	@GetMapping("/comentarioGet")
	public String comentarioGet(@ModelAttribute("ra") String ra) throws ClassNotFoundException {
		serviceComentario.buscarTodosPorAluno(ra);
		return "comentarioGet";
	}



}
