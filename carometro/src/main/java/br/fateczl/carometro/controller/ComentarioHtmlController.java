package br.fateczl.carometro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.fateczl.carometro.model.entities.Aluno;
import br.fateczl.carometro.model.entities.Comentario;
import br.fateczl.carometro.model.enums.Enum_Tipos;
import br.fateczl.carometro.service.services.IAlunoService;
import br.fateczl.carometro.service.services.IComentarioService;

@Controller
@RequestMapping("/comentario")
public class ComentarioHtmlController {

	@Autowired
	IComentarioService serviceComentario;
	@Autowired
	IAlunoService serviceAluno;

	// HOME
	@GetMapping("/comentario_home")
	public String comentarioHome() {
		return "comentario/comentario_home";
	}

	// GET
	@GetMapping("/comentarioShowGet")
	public String comentarioShowGet(Model model) throws ClassNotFoundException {
		model.addAttribute(new Comentario());
		return "comentario/comentarioShowGet";
	}

	@GetMapping("/comentarioGet")
	public String buscarComentariosPorRa(@RequestParam("ra") String ra, Model model) throws ClassNotFoundException {
		List<Comentario> comentarios = serviceComentario.buscarTodosPorAluno(ra);
		model.addAttribute("comentarios", comentarios);

		return "comentario/comentarioGet";
	}

	// DELETE - Formulário
	@GetMapping("/comentarioDelete")
	public String comentarioDeleteForm(Model model) throws ClassNotFoundException {
		model.addAttribute("tipos", Enum_Tipos.values());
		return "comentario/comentarioDelete";
	}

	// DELETE - Processamento
	@PostMapping("/comentarioDelete")
	public String comentarioDelete(@RequestParam("ra") String ra, @RequestParam("tipo") Enum_Tipos tipo, Model model)
			throws ClassNotFoundException {
		serviceComentario.deletar(ra, tipo);
		return "redirect:/comentario/comentario_home"; // Redireciona para a página inicial após deletar
	}
	
	// POST
	@GetMapping("/comentarioPost")
	public String comentarioPost(Model model) throws ClassNotFoundException {
		Comentario comentario = new Comentario();
		model.addAttribute("comentario", comentario);
		
		// Buscar lista de alunos e tipos disponíveis
        List<Aluno> alunos = serviceAluno.buscarTodos();
        model.addAttribute("alunos", alunos);
        
		model.addAttribute("tipos", Enum_Tipos.values());
		
		return "comentario/comentarioPost";
	}
	
	@PostMapping("/comentarioPost")
    public String comentarioPost(@ModelAttribute Comentario comentario, Model model) throws ClassNotFoundException {
        serviceComentario.inserir(comentario);
        model.addAttribute("comentario", comentario);
        return "comentario/comentario_inserido";
    }
	
	// PUT
	@GetMapping("/comentarioPut")
	public String comentarioPut(Model model) throws ClassNotFoundException {
		Comentario comentario = new Comentario();
		model.addAttribute("comentario", comentario);
		
		// Buscar lista de alunos e tipos disponíveis
        List<Aluno> alunos = serviceAluno.buscarTodos();
        model.addAttribute("alunos", alunos);
        
		model.addAttribute("tipos", Enum_Tipos.values());
		
		return "comentario/comentarioPut";
	}
	
	@PostMapping("/comentarioPut")
    public String comentarioPut(@ModelAttribute Comentario comentario, Model model) throws ClassNotFoundException {
        serviceComentario.atualizar(comentario.getAluno().getRa(), comentario.getTipo(), comentario);
        model.addAttribute("comentario", comentario);
        return "comentario/comentario_atualizado";
    }
	
}
