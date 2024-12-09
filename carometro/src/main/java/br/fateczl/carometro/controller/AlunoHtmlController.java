package br.fateczl.carometro.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import br.fateczl.carometro.model.entities.Aluno;
import br.fateczl.carometro.model.entities.Curso;
import br.fateczl.carometro.model.entities.Turma;
import br.fateczl.carometro.service.implementations.AlunoServiceImp;
import br.fateczl.carometro.service.implementations.CursoServiceImp;
import br.fateczl.carometro.service.implementations.TurmaServiceImp;

@Controller
@RequestMapping("/aluno")
public class AlunoHtmlController {

	private static String caminhoImagens = "C:\\PastaImagensCarometro\\";

	@Autowired
	private AlunoServiceImp alunoService;

	@Autowired
	private TurmaServiceImp turmaService;

	@Autowired
	private CursoServiceImp cursoService;

	private ArrayList<String> links = new ArrayList<>();

	// GET COMMANDS
	@GetMapping("/alunoGet")
	public String consultarAluno(Model model) {
		Aluno aluno = new Aluno();
		model.addAttribute(aluno);
		return "aluno/alunoGet";
	}

	@GetMapping("/alunoConsulta")
	public String consultarAlunoPorRa(@RequestParam String ra, Model model) {
		Aluno aluno = new Aluno();
		try {
			aluno = alunoService.buscar(ra);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
		model.addAttribute("aluno", aluno);
		return "aluno/alunoConsulta";
	}

	// POST COMMANDS
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

		return "aluno/alunoPost";
	}

	// Retornando a Imagem
	@GetMapping("/mostrarImagem/{imagem}")
	@ResponseBody
	public byte[] retornaImagem(@PathVariable("imagem") String imagem) throws IOException {
		if (imagem != null && !imagem.trim().isEmpty()) {
			File imagemArquivo = new File(caminhoImagens + imagem);
			if (imagemArquivo.exists()) {
				return Files.readAllBytes(imagemArquivo.toPath());
			}
		}
		throw new IOException("Imagem não encontrada ou inválida.");
	}

	@PostMapping("/alunoPost")
	public String inserirAluno(@ModelAttribute("aluno") @RequestParam String link1, @RequestParam String link2,
			@RequestParam String link3, Aluno aluno, @RequestParam("imagemAluno") MultipartFile arquivoImagem) {
		links.add(link1);
		links.add(link2);
		links.add(link3);
		aluno.setLinks(links);

		// Tratamento da imagem
		if (!arquivoImagem.isEmpty()) {
			try {
				// Gerar caminho completo para o arquivo
				String nomeArquivo = aluno.getRa() + "_" + arquivoImagem.getOriginalFilename();
				Path caminhoDaImagem = Paths.get(caminhoImagens + nomeArquivo);

				// Salvar o arquivo no disco
				byte[] bytesDaImagem = arquivoImagem.getBytes();
				Files.write(caminhoDaImagem, bytesDaImagem);

				// Armazena apenas o nome do arquivo
				aluno.setCaminhoFoto(nomeArquivo);

			} catch (IOException e) {
				System.err.println("Erro ao salvar a imagem:");
				e.printStackTrace();
			}
		} else {
			System.out.println("Nenhuma imagem foi fornecida.");
			aluno.setCaminhoFoto(null);
		}

		alunoService.inserir(aluno);
		links.clear();
		return "aluno/alunoInserido";
	}

	// DELETE COMMANDS
	@GetMapping("/alunoDelete")
	public String deletarAluno(Model model) {
		Aluno aluno = new Aluno();
		model.addAttribute(aluno);
		return "aluno/alunoDelete";
	}

	@PostMapping("/alunoDelete")
	public String deletarAlunoPorRa(@RequestParam String ra, Model model) {
		@SuppressWarnings("unused")
		Aluno aluno = new Aluno();
		aluno = alunoService.deletar(ra);
		model.addAttribute("message", "Deletado");
		return "aluno/alunoDelete";
	}

	// PUT COMMANDS
	@GetMapping("/alunoPut")
	public String alunoPut(Model model) {
		@SuppressWarnings("unused")
		Aluno aluno = new Aluno();
		model.addAttribute("aluno", new Aluno());
		try {
			java.util.List<Turma> listTurma = turmaService.buscarTodasAsTurmasExistentes();
			model.addAttribute("listTurma", listTurma);
			java.util.List<Curso> listCurso = cursoService.buscarTodos();
			model.addAttribute("listCurso", listCurso);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
		return "aluno/alunoPut";
	}

	@PostMapping("/alunoPut")
	public String alunoPut(@RequestParam("ra") String ra, 
	                       @ModelAttribute("aluno") Aluno aluno,
	                       @RequestParam String link1, 
	                       @RequestParam String link2, 
	                       @RequestParam String link3, 
	                       @RequestParam("imagemAluno") MultipartFile arquivoImagem,
	                       Model model) {
	    if (!link1.isBlank()) {
	        links.add(link1);
	    }
	    if (!link2.isBlank()) {
	        links.add(link2);
	    }
	    if (!link3.isBlank()) {
	        links.add(link3);
	    }
	    aluno.setLinks(links);

	    try {
	        // Buscar o aluno existente no banco
	        Aluno alunoExistente = alunoService.buscar(ra);

	        // Se uma nova imagem foi enviada, tratar a atualização da imagem
	        if (arquivoImagem != null ||  !arquivoImagem.isEmpty()) {
	            String nomeArquivo = ra + "_" + arquivoImagem.getOriginalFilename();
	            Path caminhoDaImagem = Paths.get(caminhoImagens + nomeArquivo);

	            try {
	                byte[] bytesDaImagem = arquivoImagem.getBytes();
	                Files.write(caminhoDaImagem, bytesDaImagem);
	                aluno.setCaminhoFoto(caminhoDaImagem.toString());
	            } catch (IOException e) {
	                System.err.println("Erro ao salvar a imagem:");
	                e.printStackTrace();
	            }
	        } else {
	            // Manter a foto atual do aluno
	            aluno.setCaminhoFoto(alunoExistente.getCaminhoFoto());
	        }

	        alunoService.atualizarComLink(ra, aluno, links);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        return "redirect:/alunoGet?error=alunoNaoEncontrado";
	    } catch (NullPointerException e) {
	        System.err.println(e.getMessage());
	    }

	    try {
	        aluno = alunoService.buscar(ra);
	    } catch (ClassNotFoundException e) {
	        System.err.println(e.getMessage());
	    }

	    model.addAttribute("aluno", aluno);
	    model.addAttribute("links", links = (ArrayList<String>) aluno.getLinks());
	    return "aluno/alunoAtualizado";
	}


	// LIST ALL
	@GetMapping("/alunoList")
	public String listarTodosOsAluno(Model model) {
		@SuppressWarnings("unused")
		Aluno aluno = new Aluno();
		List<Aluno> alunos = new ArrayList<>();
		try {
			alunos = alunoService.buscarTodos();
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
		model.addAttribute("alunos", alunos);
		model.addAttribute("links", links);
		return "aluno/alunoList";
	}

	@GetMapping("/alunoHome")
	public String alunoHome(Model model) {
		model.addAttribute("message", "Isso é um Teste");
		return "aluno/alunoHome";

	}

}
