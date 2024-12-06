package br.fateczl.carometro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.fateczl.carometro.model.entities.Aluno;
import br.fateczl.carometro.service.implementations.AlunoServiceImp;

@Controller
public class AlunoHtmlController {

    @Autowired
    private AlunoServiceImp alunoService;

    @GetMapping("/alunoGet")
    public String alunoGet(Model model) {
        try {
            Aluno aluno = alunoService.buscar("1110482227778");
            model.addAttribute("a", aluno);
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return "alunoGet";
    }
    
    @GetMapping("/alunoPost")
    public String alunoPost(Model model) {
    	/*Aluno aluno = new Aluno();
        alunoService.inserir(aluno);*/
		model.addAttribute("message", "Aluno Cadastrado!");
        return "alunoPost";
    }
}