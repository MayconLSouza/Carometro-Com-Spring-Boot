package br.fateczl.carometro.model.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Aluno implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id // primary key
	private String ra;
	private String nome;
	private String curso;
	private String semestreConclusao;
	// TODO: Acrescentar Atributo imagem; Include The Image Attribute for Student
	private List<String> links;

	// TODO: Acrescentar Classe Turma; Include Attribute Turma Class in Student

	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference // for serializable the Owner of relationship
	private List<Historico> historicos;

	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference // for serializable the Owner of relationship
	private List<Comentario> comentarios; // Um aluno pode ter muitos comentários

	public Aluno() {
		super();
	}

	// Getters e Setters
	public String getRa() {
		return ra;
	}

	public String setRa(String ra) {
		return this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getSemestreConclusao() {
		return semestreConclusao;
	}

	public void setSemestreConclusao(String semestreConclusao) {
		this.semestreConclusao = semestreConclusao;
	}

	public List<String> getLinks() {
		return links;
	}

	public void setLinks(List<String> links) {
		this.links = links;
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
