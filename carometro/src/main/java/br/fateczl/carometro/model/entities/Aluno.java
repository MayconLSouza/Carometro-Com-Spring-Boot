package br.fateczl.carometro.model.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Aluno implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	private String ra;
	private String nome;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_curso_aluno", referencedColumnName = "codigo", nullable = false)
	
	@JsonBackReference("aluno-curso")
	private Curso curso;

	private LocalDate semestreConclusao;
	// TODO: Acrescentar Atributo imagem; Include The Image Attribute for Student
	private List<String> links;

	@ManyToOne
	@JoinColumns({
	    @JoinColumn(name = "codigo_curso", referencedColumnName = "codigoCurso"),
	    @JoinColumn(name = "ano", referencedColumnName = "ano"),
	    @JoinColumn(name = "semestre", referencedColumnName = "semestre")
	})
	@JsonBackReference("turma-alunos")
	private Turma turma;


	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference("historico-aluno")
	private List<Historico> historicos;



	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference("comentario-aluno")
	private List<Comentario> comentarios;


	public Aluno() {
		super();
	}

	// Getters e Setters
	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public LocalDate getSemestreConclusao() {
		return semestreConclusao;
	}

	public void setSemestreConclusao(LocalDate semestreConclusao) {
		this.semestreConclusao = semestreConclusao;
	}

	public List<String> getLinks() {
		return links;
	}

	public void setLinks(List<String> links) {
		this.links = links;
	}

	public Turma getTurma() {
		return turma;
	}
	
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Aluno [ra=" + ra + ", nome=" + nome + ", curso=" + curso + "]";
	}
}
