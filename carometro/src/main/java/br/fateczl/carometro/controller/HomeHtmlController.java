package br.fateczl.carometro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeHtmlController {

	@GetMapping()
	public String home(Model model) {
		model.addAttribute("message", "Isso é um Teste");
		return "home";

	}
}
