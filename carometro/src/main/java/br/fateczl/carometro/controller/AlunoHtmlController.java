package br.fateczl.carometro.controller;
 
import java.util.ArrayList;
 
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
 
import br.fateczl.carometro.model.entities.Aluno;
import br.fateczl.carometro.model.entities.Curso;
import br.fateczl.carometro.model.entities.Turma;
import br.fateczl.carometro.service.implementations.AlunoServiceImp;
import br.fateczl.carometro.service.implementations.CursoServiceImp;
import br.fateczl.carometro.service.implementations.TurmaServiceImp;
import jakarta.validation.Valid;
 
@Controller
public class AlunoHtmlController {
 
    @Autowired
    private AlunoServiceImp alunoService;
    
    @Autowired
    private TurmaServiceImp turmaService;
    
    @Autowired
    private CursoServiceImp cursoService;
 
    @GetMapping("/alunoGet/{ra}")
    public String alunoGet(@ModelAttribute("ra") String ra, Model model) {
        try {
            Aluno aluno = alunoService.buscar(ra);
            model.addAttribute("a", aluno);
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return "alunoGet";
    }
    
    @GetMapping("/alunoPost")
    public String alunoPost(Model model) {
    	Aluno aluno = new Aluno();
        model.addAttribute("aluno", aluno);
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
    public String alunoPost(@ModelAttribute("aluno") Aluno aluno) {
    	
    	alunoService.inserir(aluno);
    	return "aluno_inserido";
    }
    
    @GetMapping("/home")
    public String home(Model model) {
    	model.addAttribute("message", "Isso é um Teste");
		return "home";
    	
    }
    
    
}
 